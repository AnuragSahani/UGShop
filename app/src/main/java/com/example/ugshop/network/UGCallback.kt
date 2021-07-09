package com.example.ugshop.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UGCallback<T> :  Callback<T>{
    override fun onResponse(call: Call<T>, response: Response<T>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        TODO("Not yet implemented")
    }
}