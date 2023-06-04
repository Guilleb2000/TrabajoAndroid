package com.example.trabajoandroid.api

import com.example.trabajoandroid.model.User
import com.example.trabajoandroid.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<Users>
}