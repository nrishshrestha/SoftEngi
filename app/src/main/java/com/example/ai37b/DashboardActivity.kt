package com.example.ai37b

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashboardBody()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardBody() {
    val context = LocalContext.current
    val activity = context as Activity

    data class NavItem(val Label: String,val icon:Int)
    var selectedItem by remember { mutableIntStateOf(0) }

    val navList = listOf(
        NavItem("Home",R.drawable.baseline_home_24),
        NavItem("Search",R.drawable.baseline_search_24),
        NavItem("Notification",R.drawable.baseline_notifications_24),
        NavItem("Profile",R.drawable.baseline_person_24)
    )

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue ,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                title = { Text("Ecommerce") },
                navigationIcon = {
                    IconButton (onClick = {

//                        activity.finish()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = null
                        )

                    }
                },
            )
        },
        floatingActionButton = {
            Button(onClick = {
                val intent = Intent(context, AddProductAcitivity::class.java)
                context.startActivity(intent)
            }) {
                Text("Add Product")
            }
        },
        bottomBar = {
            NavigationBar {
                navList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(painter = painterResource(item.icon),
                                contentDescription = null)
                        },
                        label = {Text(item.Label)},
                        onClick = {
                            selectedItem = index
                        },
                        selected = selectedItem == index
                    )
                }
            }

        }
    ){padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (selectedItem) {
                0 -> HomeScreen()
                1 -> SearchScreen()
                2 -> NotificationScreen()
                3 -> ProfileScreen()
                else -> HomeScreen()
            }
        }
    }
}


@Composable
@Preview
fun DashPreview() {
    DashboardBody()
}
