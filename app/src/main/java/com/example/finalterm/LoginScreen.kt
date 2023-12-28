package com.example.finalterm

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalterm.ui.theme.defaultHeight
import com.example.finalterm.ui.theme.defaultRadius
import com.example.finalterm.ui.theme.defaultWidth
import com.example.finalterm.ui.theme.primaryColor
import com.example.finalterm.ui.theme.whiteColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(name:String?, navController: NavController)
{
    Background {
        TransparentCard()
        Column( modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            var warningMsg by remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = warningMsg, color = Color.Red)
            Spacer(modifier = Modifier.height(7.dp))
            Row {
                Button(color = whiteColor, radius = 20, "Login", textColor= primaryColor )
                Spacer(modifier = Modifier.width(10.dp))
                TextButton(
                    onClick = {
                        navController.navigate(Screen.SignUpScreen.route)
                    },
                    modifier = Modifier
                        .background(color = primaryColor, shape = MaterialTheme.shapes.extraLarge   )
                        .width(defaultWidth)
                        .height(defaultHeight)
                )
                {
                    Text(text = stringResource(id = R.string.signup), color= whiteColor,  fontSize = 20.sp,)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            var inputUsername by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputUsername,
                onValueChange = { inputUsername = it },
                label = {
                    Text(text = "username")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                ),
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(text = "password")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Lock , contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                ),
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Forget password?")
            Spacer(modifier = Modifier.height(15.dp))
            TextButton(
                onClick = {
                    val loginData = ApiClient.apiService.login(User(inputUsername, password))

                    loginData.enqueue(object : Callback<Boolean?> {
                        override fun onResponse( call: Call<Boolean?>, response: Response<Boolean?>)
                        {
                            // if api call is success
                            val responseBody = response.body()
                            if (responseBody  == true)
                            {
                                navController.navigate(Screen.HomeScreen.route)
                            }
                            else
                            {
                                warningMsg = "Invalid Username Or Password"
                            }
                            Log.d("User", "$responseBody" )
                        }

                        override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                            // if api call fail
                            Log.d("API failure", "$t" )
                        }
                    })

                },
                        modifier = Modifier
                            .background(
                                color = primaryColor,
                                shape = RoundedCornerShape(defaultRadius)
                            )
                            .width(317.dp)
                            .height(defaultHeight)
            )
            {
                Text(text = "Login", color= whiteColor,  fontSize = 20.sp,)
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun TransparentCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .height(399.dp)
                .width(360.dp)
                .background(
                    color = Color.White.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(30.dp)
                )
        )
    }
}


