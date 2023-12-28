package com.example.finalterm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalterm.ui.theme.maskColor
import com.example.finalterm.ui.theme.primaryColor
import com.example.finalterm.ui.theme.whiteColor

@Composable
fun AppSplashScreen(navController: NavController) {
    Background()
    {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        )
        {
            Spacer(modifier = Modifier.height(100.dp))
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(318.dp)
                    .height(173.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = stringResource(id = R.string.moto), fontSize = 22.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(100.dp))
            TextButton(
                onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                },
                modifier = Modifier
                    .background(color = primaryColor, shape = RoundedCornerShape(20.dp))
                    .width(258.dp)
                    .height(53.dp)
            )
            {
                Text(text = "Lets start", color= whiteColor,  fontSize = 20.sp,)
            }
        }
    }
}

@Composable
fun Background( content: @Composable (Modifier) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    )
    {
        Image(
            painterResource(id = R.drawable.background_app),
            contentDescription = "",
            colorFilter = ColorFilter.tint(maskColor, blendMode = BlendMode.Screen),
            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .matchParentSize()
        )
        content(Modifier)
    }
}