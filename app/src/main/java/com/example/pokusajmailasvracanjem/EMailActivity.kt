package com.example.pokusajmailasvracanjem

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class EMailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable("main") {
                    MaterialTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            SimpleButton(navController = navController)
                        }
                    }
                }

                composable("sendMail") {
                    MaterialTheme {
                        SendMailFragment(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleButton(navController: NavController) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.darrrr),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Klikom na gumb \"Konačno rezerviraj\" ćete biti prebačeni na e-mail poslužitelj gdje trebate ispuniti tražene podatke te slanjem ispunjenog e-maila potvrđujete rezervaciju.",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp
                )
            }


            Button(
                onClick = {
                    navController.navigate("sendMail")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Konačno rezerviraj", fontSize = 30.sp)
            }


            Button(
                onClick = {

                    val intent = Intent(context, ProizvodiActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Katalog", fontSize = 30.sp)
            }
        }
    }
}

@Composable
fun SendMailFragment(navController: NavController) {
    val context = LocalContext.current



    val emailSubject = "Rezervacija proizvoda"
    val emailBody = "Šifra artikla: \nDatum i vrijeme preuzimanja: "


    sendMail(context, "zvonimirtopic1999@gmail.com", emailSubject, emailBody)


    navController.popBackStack("main", inclusive = false)
}

fun sendMail(context: Context, to: String, subject: String, body: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        context.startActivity(Intent.createChooser(intent, "Send Email"))
    } catch (e: Exception) {
        // TODO: Handle exception
    }
}

@Composable
@Preview(showBackground = true)
fun SimpleButtonPreview() {
    MaterialTheme {
        SimpleButton(navController = rememberNavController())
    }}