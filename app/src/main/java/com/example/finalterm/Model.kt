package com.example.finalterm

import androidx.room.Entity
import androidx.room.PrimaryKey



data class HairStylist(
    val name: String,
    val rating: Int,
    val contact: String
)