package com.example.finalterm

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//data access object
@Dao
interface AppointmentDao {
    // upsert will update data if it is already present else simply insert
    @Upsert
    fun upsertAppointment(appointment: Appointment)

    // observables,
    // notify about data changes
    // Flow -->  as long as data changes it will give us new list of data automatically
    @Query("SELECT * FROM appointment")
    fun getAllAppointments(): Flow<List<Appointment>>

    @Query("SELECT * FROM appointment ORDER BY price")
    fun getAllAppointmentsByPrice(): Flow<List<Appointment>>
}