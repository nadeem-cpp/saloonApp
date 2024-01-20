package com.example.finalterm

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
data class Appointment(
    val title: String,
    val date: String,
    val specialist: String,
    val appointmentDate: String,
    val price: Double,
//    @PrimaryKey(autoGenerate = true)
//    val id:Int? = null,
)
//data class Appointment(
//    val title: String,
//    val date: String,
//    val specialist: String,
//    val appointmentDate: String,
//    val price: Double,
//)
