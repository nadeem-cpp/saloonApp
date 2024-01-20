package com.example.finalterm


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import kotlinx.coroutines.flow.toList

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
                        .size(170.dp)
                        .clip(CircleShape)
                )

                Text(text = "Name", fontSize = 27.sp , fontWeight = FontWeight.Bold,)
            }
            val dbHelper = DBHelper(LocalContext.current)
            val appointmentsHistory: MutableList<Appointment> = dbHelper.selectAll()
            Text(text = "Appointment History", fontSize = 27.sp, modifier = Modifier.padding(16.dp))
            LazyColumn(
                content = {
                    items(appointmentsHistory) { appointment: Appointment ->
                        AppointmentItem(appointment = appointment)
                    }
                }
            )
        }

    }
}

@Composable
fun AppointmentItem(appointment: Appointment) {
    Surface(
        color = Color(0xFFDBDBDB),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(width = 0.dp, color = MaterialTheme.colorScheme.secondary),
        tonalElevation = 2.dp,
        shadowElevation = 5.dp,
        modifier = Modifier
            .padding(bottom = 10.dp)
    )
    {
        Column(
            modifier = Modifier
                .padding(12.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = appointment.title, fontSize = 21.sp, fontWeight = FontWeight.Bold)
                Text(text = appointment.date, fontSize = 15.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Hair Stylist: ${appointment.specialist}",
                    fontSize = 15.sp, color = MaterialTheme.colorScheme.secondary)
                Text(text = appointment.appointmentDate, fontSize = 15.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "Total Price: ${appointment.price}", fontSize = 15.sp, color = Color.Green)
            }
        }

    }
}

