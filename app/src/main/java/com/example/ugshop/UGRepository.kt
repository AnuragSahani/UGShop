package com.example.ugshop

object UGRepository {
    fun login(name : String, password : String) : Boolean {
        return UGRetrofit.getRetrofit().login(name, password)
    }
}