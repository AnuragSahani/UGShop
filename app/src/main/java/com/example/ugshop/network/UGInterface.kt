package com.example.ugshop.network

import retrofit2.http.POST

interface UGInterface {

    @POST("login")
    fun login(email : String, password : String) : Boolean

}