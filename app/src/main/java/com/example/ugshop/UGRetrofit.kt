package com.example.ugshop

import com.example.ugshop.network.UGInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UGRetrofit {
    fun getRetrofit() : UGInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(UGInterface :: class.java)
    }
}