package com.example.finalterm

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Appointment::class],
    version = 1
)
abstract class SalonDatabase: RoomDatabase() {
    abstract fun appointmentDao(): AppointmentDao
}