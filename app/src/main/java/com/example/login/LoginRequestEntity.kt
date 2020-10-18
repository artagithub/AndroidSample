package com.example.login

data class LoginRequestEntity(
    val client_id: String,
    val client_secret: String,
    val  audience :String,
    val grant_type:String

)