package com.example.ai37b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CardAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardAppBody()
        }
    }
}

@Composable
fun CardAppBody() {
    Scaffold { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).background(Color(0xFF7ED991))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.test3
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Column (
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                Text("Card", modifier = Modifier,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFFFF)
                )
                Text("Simple and easy to use app",modifier = Modifier,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFFFFFFF))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                NewCard(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f),
                    R.drawable.baseline_menu_book_24,
                    label = ("Text")
                )
                Spacer(modifier = Modifier.width(10.dp))
                NewCard(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f),
                    R.drawable.baseline_menu_book_24,
                    label = ("Text")
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            ) {
                NewCard(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f),
                    R.drawable.baseline_menu_book_24,
                    label = ("Text")
                )
                Spacer(modifier = Modifier.width(10.dp))
                NewCard(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f),
                    R.drawable.baseline_menu_book_24,
                    label = ("Text")
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            ) {
                NewCard(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f),
                    R.drawable.baseline_menu_book_24,
                    label = ("Text")
                )
                Spacer(modifier = Modifier.width(10.dp))
                NewCard(
                    modifier = Modifier
                        .height(150.dp)
                        .weight(1f),
                    R.drawable.baseline_menu_book_24,
                    label = ("Text")
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            ) {
                Card(
                    modifier = Modifier
                        .height(75.dp).weight(1f)
                ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.baseline_keyboard_arrow_down_24
                        ),
                        contentDescription = null,
                        modifier = Modifier.width(100.dp).height(75.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        "Settings", modifier = Modifier.padding(10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}

@Composable
fun NewCard(modifier: Modifier, image: Int, label: String
) {
    Card(modifier) {
        Column (modifier = modifier.fillMaxSize().padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(label)
        }

    }
}



@Preview
@Composable
fun CardAppPreview() {
    CardAppBody()
}