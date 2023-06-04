package com.example.trabajoandroid.model

data class User(
    val id: Int,
    val firstName: String,
    val lastName : String,
    val maidenName : String,
    val image: String,
    val company: Company
) : java.io.Serializable

data class Company(
    val name: String
) : java.io.Serializable