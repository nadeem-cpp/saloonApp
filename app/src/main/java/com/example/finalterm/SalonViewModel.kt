package com.example.finalterm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SalonViewModel(
    private val appointmentDao: AppointmentDao
): ViewModel() {
//    fun getAppointments(): Flow<List<Appointment>> {
//        return appointmentDao.getAllAppointments()
//    }
//    private val _dataFlow = MutableStateFlow<List<Appointment>>(emptyList())
//    val dataFlow: StateFlow<List<Appointment>> get() = _dataFlow
//
//    // Function to fetch data from the database
//    fun fetchData() {
//        // Use viewModelScope for coroutine in ViewModel
//        viewModelScope.launch {
//            // Assuming you have a function in DbHelper to fetch data
//            val data = appointmentDao.getAllAppointments()
//            _dataFlow.value = data
//        }
//    }
}