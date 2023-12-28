package com.example.finalterm

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalterm.ui.theme.defaultHeight
import com.example.finalterm.ui.theme.defaultRadius
import com.example.finalterm.ui.theme.defaultWidth
import com.example.finalterm.ui.theme.maskColor
import com.example.finalterm.ui.theme.primaryColor
import com.example.finalterm.ui.theme.whiteColor

@Composable
fun SignUpScreen(navController: NavController)
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

            Spacer(modifier = Modifier.weight(1f))
            Row {
                TextButton(
                    onClick = {
                              navController.navigate(Screen.LoginScreen.route)
                    },
                    modifier = Modifier
                        .background(color = primaryColor, shape = MaterialTheme.shapes.extraLarge)
                        .width(defaultWidth)
                        .height(defaultHeight)
                )
                {
                    Text(text = "Login", color= whiteColor,  fontSize = 20.sp,)
                }

                Spacer(modifier = Modifier.width(10.dp))
                TextButton(
                    onClick = {
//                        navController.navigate(Screen.LoginScreen.route)
                    },
                    modifier = Modifier
                        .background(color = whiteColor, shape = MaterialTheme.shapes.extraLarge)
                        .width(defaultWidth)
                        .height(defaultHeight)
                )
                {
                    Text(text = stringResource(id = R.string.signup), color= primaryColor,  fontSize = 20.sp,)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            var username by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = username,
                onValueChange = { username = it},
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
                onValueChange = { password = it},
                label = {
                    Text(text = "password")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Lock , contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                ),
                visualTransformation =  PasswordVisualTransformation('*'),

            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                label = {
                    Text(text = "confirm password")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Lock , contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                ),
                visualTransformation =  PasswordVisualTransformation('*'),
            )

            Spacer(modifier = Modifier.height(15.dp))

//            Text(text = "Remember me?")
//            Spacer(modifier = Modifier.height(15.dp))
            Button(color = primaryColor, label = stringResource(id = R.string.signup) , textColor = whiteColor, width = 317 )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

//@Composable
//fun InputField(state: MutableState<String>, label:String, type: KeyboardType, imageVector: ImageVector,)
//{
//    OutlinedTextField(
//        value = state,
//        onValueChange = { state = it},
//        label = {
//            Text(text = label)
//        },
//        trailingIcon = {
//            Icon(imageVector = imageVector, contentDescription = null)
//        },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = type,
//
//        ),
//    )
//}