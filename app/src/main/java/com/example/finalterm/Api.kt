package com.example.finalterm

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.Date

data class User(
    val username: String,
    val password: String
)

data class Appointment(
    val title: String,
    val date: String,
    val hairSpecialist: String,
    val appointmentDate: String,
    val price: Double
)

data class HairStylist(
    val name: String,
    val rating: Int,
    val contact: String
)



interface ApiService {
    @POST("authenticate")
    fun login(@Body user: User): Call<Boolean>

    @POST("signup")
    fun signup(@Body user: User): Call<Int> // return developer defined code in response
}

object ApiClient {

    private const val BASE_URL = "http://10.0.2.2:5000/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}

