package com.example.finalterm


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreen() {
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
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_menu),
                    contentDescription ="menu",
                    tint = Color(0xFF2A2E3B),
                    modifier = Modifier
                        .size(40.dp)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
            horizontalAlignment =  Alignment.CenterHorizontally,
            ) {
                // profile image
                Image(
                    painterResource(id = R.drawable.background_app),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )

                Text(text = "Name", fontSize = 27.sp , fontWeight = FontWeight.Bold,)
            }

            val appointmentsHistory = listOf("Hair Dryer", "Spa", "Shampoo")
            Text(text = "Appointment History", fontSize = 27.sp, modifier = Modifier.padding(16.dp))
            LazyColumn(
                content = {
                    items(appointmentsHistory) { type: String ->
                        AppointmentItem(type = type)
                    }
                }
            )
        }

    }
}

@Composable
fun AppointmentItem(type:String) {
    Surface(
        color = Color(0xFFC8C8C8),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.secondary),
        tonalElevation = 2.dp,
        shadowElevation = 5.dp,
        modifier = Modifier
            .padding(bottom = 10.dp)
    )
    {
        Column(
            modifier = Modifier
                .padding(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = type, fontSize = 21.sp, fontWeight = FontWeight.Bold)
                Text(text = "date of appointment", fontSize = 15.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                val name = "nadeem"
                Text(text = "Hair Stylist: $name", fontSize = 15.sp, color = MaterialTheme.colorScheme.secondary)
                Text(text = "appointment date and time", fontSize = 15.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                val price = 40
                Text(text = "Total Price: $price$", fontSize = 15.sp, color = Color.Green)
            }
        }

    }
}

