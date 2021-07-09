package com.example.ugshop

import com.example.ugshop.Controller.NetworkController

object UGRepository {
    val networkController = NetworkController()
    fun login(name : String, password : String) {
        networkController.login(name, password)
    }
}