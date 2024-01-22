package com.example.pokusajmailasvracanjem


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokusajmailasvracanjem.ProizvodiActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {

    val context = LocalContext.current


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.camellia),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    "Dobro došli na uslugu rezervacije cvjećarnice Camellia Nova!",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.height(16.dp))
            }


            Button(
                onClick = {

                    val intent = Intent(context, ProizvodiActivity::class.java)


                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(56.dp)


                    .align(Alignment.Center)
                    .offset(y = 65.dp)
            ) {

                Text(
                    "Katalog",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {

    MainContent()
}