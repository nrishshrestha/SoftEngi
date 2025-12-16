package com.example.ai37b


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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


class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}
@Composable
fun ProfileBody() {
    Scaffold { padding ->
        Modifier.padding(padding)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null
                )
                Text("nrishshrestha",
                    fontWeight = FontWeight.Bold)
                Icon(
                    painter = painterResource(
                        id = R.drawable.baseline_more_horiz_24
                    ),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                Image(
                    painter = painterResource(id = R.drawable.testimage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop

                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("000")
                    Text("Post",
                        fontWeight = FontWeight.Bold)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("000")
                    Text("Followers",
                        fontWeight = FontWeight.Bold)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("000")
                    Text("Followings",
                        fontWeight = FontWeight.Bold)
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text("Bio",
                    fontWeight = FontWeight.Bold)
                Text("Follow Me :D")
                Text("Link goes here",
                    color = Color(0xFF00BCD4))
                Text("Followed by username and username")

            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),

                ) {
                Text("Button")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4C5FD7),
                        contentColor = Color.White
                    )
                ) {
                    Text("Follow",
                        fontWeight = FontWeight.Bold)
                }
                OutlinedButton(onClick = {},
                    shape = RoundedCornerShape(8.dp),) {
                    Text("Message",
                        fontWeight = FontWeight.Bold)
                }
                OutlinedButton(onClick = {},
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text("Email",
                        fontWeight = FontWeight.Bold)
                }
                OutlinedButton(onClick = {},
                    shape = RoundedCornerShape(8.dp),)
                {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.baseline_keyboard_arrow_down_24
                        ),
                        contentDescription = null
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.testimage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 1")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.test2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 2")

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.test3),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text("Story 3")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

        }

    }
}

@Preview
@Composable
fun PreviewProfile(){
    ProfileBody()
}