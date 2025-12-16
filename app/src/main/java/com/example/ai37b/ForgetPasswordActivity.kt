package com.example.ai37b

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.repository.UserRepoImpl
import com.example.ai37b.viewmodel.UserViewModel
import com.example.ai37b.viewmodel.ui.theme.AI37BTheme

class ForgetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AI37BTheme {
                ForgetPasswordBody()
            }
        }
    }
}

@Composable
fun ForgetPasswordBody() {
    val userViewModel = remember { UserViewModel(UserRepoImpl()) }

    var email by remember { mutableStateOf("") }
    var context = LocalContext.current

    val activity = context as Activity
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text("Forgot Password",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFF3460FB),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if (email.isNotBlank()) {
                    userViewModel.forgetPassword(email) { success, message ->
                        if (success) {
                            Toast.makeText(context, "Recovery Email Sent to $email", Toast.LENGTH_SHORT).show()

                            activity.finish()
                        } else {
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .height(60.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 15.dp
                ),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text("Confirm Email")
            }
        }
    }
}

@Composable
@Preview
fun ForgetPasswordPreview() {
    ForgetPasswordBody()
}