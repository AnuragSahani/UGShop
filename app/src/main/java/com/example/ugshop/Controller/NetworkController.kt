package com.example.ugshop.Controller

import com.example.ugshop.UGRetrofit
import com.example.ugshop.network.UGCallback
import retrofit2.Call

class NetworkController {
    fun login(name: String, password: String) {
        var call : Call<ResponseEntity<Boolean>> = UGRetrofit.retrofit.login(name, password)
        call.enqueue(UGCallback())
    }
}