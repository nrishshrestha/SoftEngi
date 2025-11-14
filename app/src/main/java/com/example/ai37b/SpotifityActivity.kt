package com.example.ai37b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SpotifyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}


@Composable
fun SpotifyBody() {
Scaffold { padding ->
    Modifier.padding(padding)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Recently played",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_notifications_24
                ),
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_history_24
                ),
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(15.dp))
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_settings_24
                ),
                contentDescription = null,
                tint = Color.White

                )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.testimage
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "Artist",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.test3
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "Artist",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                )

            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.test2
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(75.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 10.dp),
                horizontalAlignment = Alignment.Start

            ) {
                Text("#SPOTIFYWRAPPED",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Your 2025 in review",
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp)
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.test3
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(125.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "Your Top Songs 2025",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ducati
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(125.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "Your Artists Revealed",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
        ) {
            Text("Editor's picks",
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),

        ) {
            Column() {
                Image(
                    painter = painterResource(
                        id = R.drawable.testimage
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(125.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "Artist, Artist",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
                Text(
                    "Artist, Artist",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Image(
                    painter = painterResource(
                        id = R.drawable.test4
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(125.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    "Artist, Artist",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
                Text(
                    "Artist, Artist",
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp
                )
            }
        }
    }
}
}

@Preview
@Composable
fun SpotifyBodyPreview() {
    SpotifyBody()
}