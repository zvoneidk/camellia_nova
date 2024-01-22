package com.example.pokusajmailasvracanjem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


class ProizvodiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLazyColumnWithCardsAndButton(this)
        }
    }
}

@Composable
fun MyLazyColumnWithCardsAndButton(context: Context) {
    val imageUrls = listOf(
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a111.jpg?alt=media&token=d861b67f-981d-4e24-9655-637e0e7b529a",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a222.jpg?alt=media&token=920bdcbd-0bf5-4b31-9414-2902fc2cdead",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a333.jpg?alt=media&token=d18c3665-c277-4027-b0b4-41b9f68ca9e8",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a444.jpg?alt=media&token=51a27645-42a7-4bdf-8748-9b79d419d310",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a555.jpg?alt=media&token=5544de8c-b132-4a3c-871c-dfb042880e19",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a666.jpg?alt=media&token=46df62e2-f88b-4121-bc50-1795bbfea3da",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a777.jpg?alt=media&token=6f38fa21-56a4-4fee-b5b1-bc179e473bc2",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a888.jpg?alt=media&token=f48a2880-aafd-4eb8-b037-a75622961326",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a999.jpg?alt=media&token=f95818b5-3df6-461a-9336-58d80bec6cc4",
        "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a000.jpg?alt=media&token=9d35a636-d5b9-49fc-8943-7a06ef789a62"
    )

    val cardContents = listOf(
        "                            Buket",
        "                            Buket",
        "                  Božićni aranžman",
        "                    Vjenčić za vrata",
        "                            Buket",
        "                  Uskrsni aranžman",
        "                            Buket",
        "                  Uskrsni aranžman",
        "                            Buket",
        "                  Božićni aranžman"
    )

    val backgroundColor = Color(255, 182, 193)
    val cardColor = Color.Transparent
    val buttonColor = backgroundColor.copy(alpha = 0f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cvijeceokolo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(imageUrls.size) { index ->
                    val destinationActivity = when (index) {
                        0 -> DestinationActivity1::class.java
                        1 -> DestinationActivity2::class.java
                        2 -> DestinationActivity3::class.java
                        3 -> DestinationActivity4::class.java
                        4 -> DestinationActivity5::class.java
                        5 -> DestinationActivity6::class.java
                        6 -> DestinationActivity7::class.java
                        7 -> DestinationActivity8::class.java
                        8 -> DestinationActivity9::class.java
                        9 -> DestinationActivity10::class.java
                        else -> throw IllegalArgumentException("Invalid index: $index")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                                .background(color = cardColor),
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                val imageUrl = imageUrls[index]
                                Image(
                                    painter = rememberAsyncImagePainter(model = imageUrl),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(3f / 4f)
                                        .clip(shape = MaterialTheme.shapes.medium)
                                        .background(cardColor),
                                    contentScale = ContentScale.Crop
                                )

                                val cardContent = cardContents[index]
                                Text(
                                    text = cardContent,
                                    color = Color(128, 0, 128)
                                )
                            }
                        }

                        Button(
                            onClick = {
                                val intent = Intent(context, destinationActivity)
                                intent.putExtra("image_url", imageUrls[index])
                                context.startActivity(intent)
                            },
                            modifier = Modifier
                                .height(IntrinsicSize.Min)
                                .background(color = buttonColor)
                        ) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "Odaberi")
                        }
                    }
                }
            }

            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .background(color = buttonColor)
            ) {
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Povratak")
            }
        }
    }
}

@Composable
fun DestinationScreen(text: String, imageUrl: String) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(255, 182, 193))
        ) {
            Image(
                painter = painterResource(id = R.drawable.tamnoo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3f / 4f)
                        .clip(shape = MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.background.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }

                Button(
                    onClick = {
                        val intent = Intent(context, EMailActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .height(80.dp)
                        .width(240.dp)
                ) {
                    Text(text = "Rezerviraj", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = {
                        val intent = Intent(context, ProizvodiActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(text = "Povratak na katalog")
                }
            }
        }
    }
}

class DestinationActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:35€ Šifra:01", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:30€ Šifra:02", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:20€ Šifra:03", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:15€ Šifra:04", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:30€ Šifra:05", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:20€ Šifra:06", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity7 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:30€ Šifra:07", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:20€ Šifra:08", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity9 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:35€ Šifra:09", imageUrl = imageUrl)
        }
    }
}

class DestinationActivity10 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = intent.getStringExtra("image_url") ?: ""
        setContent {
            DestinationScreen(text = "Cijena:20€ Šifra:10", imageUrl = imageUrl)
        }
    }
}















@Preview(showBackground = true)
@Composable
fun DestinationActivity1Preview() {
    val imageUrl = "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a111.jpg?alt=media&token=d861b67f-981d-4e24-9655-637e0e7b529a"
    DestinationScreen(text = "Cijena:35€ Šifra:01", imageUrl = imageUrl)
}

@Preview(showBackground = true)
@Composable
fun DestinationActivity2Preview() {
    val imageUrl = "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a222.jpg?alt=media&token=920bdcbd-0bf5-4b31-9414-2902fc2cdead"
    DestinationScreen(text = "Cijena:30€ Šifra:02", imageUrl = imageUrl)
}

@Preview(showBackground = true)
@Composable
fun DestinationActivity3Preview() {
    val imageUrl = "https://firebasestorage.googleapis.com/v0/b/camellia-2ecfe.appspot.com/o/a333.jpg?alt=media&token=d18c3665-c277-4027-b0b4-41b9f68ca9e8"
    DestinationScreen(text = "Cijena:20€ Šifra:03", imageUrl = imageUrl)
}