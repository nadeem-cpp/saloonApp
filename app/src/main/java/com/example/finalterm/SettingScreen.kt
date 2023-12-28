package com.example.finalterm

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SettingScreen() {
    Surface(
        color = Color(0xFFEEECEC),
        modifier = Modifier.fillMaxSize()
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            translate(left = -500f, top = -700f) {
                drawCircle(Color(0xFFFFB3B3), radius = 200.dp.toPx())
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Settings", fontSize = 22.sp)
                // profile image
                Image(
                    painterResource(id = R.drawable.background_app),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(57.dp)
                        .clip(CircleShape)
                )

            }
            Spacer(modifier = Modifier.height(50.dp))
            //account info
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Account Info", fontSize = 27.sp)
                DetailsIcon()
            }
            HorizontalDivider()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Language", fontSize = 27.sp)
                DetailsIcon()
            }
            HorizontalDivider()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Dark Mood", fontSize = 27.sp)
                var themeMode by remember { mutableStateOf(false) }
                Switch(
                    checked = themeMode,
                    onCheckedChange = {themeMode = it},
                )
            }
            HorizontalDivider()

            Text(text = "Help Center", fontSize = 22.sp , color = MaterialTheme.colorScheme.secondary)
            Text(text = "Privacy Policy", fontSize = 22.sp, color = MaterialTheme.colorScheme.secondary)
            Text(text = "Recommendations", fontSize = 22.sp, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(55.dp))
            Text(text = "Sign-out", fontSize = 25.sp, color = Color(0xFFFF4343))

        }
    }
}

@Composable
fun HorizontalDivider() {
    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp,
        modifier = Modifier.padding(top = 12.dp, bottom = 12.dp))
}

@Composable
fun DetailsIcon() {
    val color = MaterialTheme.colorScheme.secondary
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color.Transparent,
        border = BorderStroke(width = 1.dp, color = color),
        modifier = Modifier
            .size(50.dp)
    ) {
        Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "details",
            tint = color)

    }
}