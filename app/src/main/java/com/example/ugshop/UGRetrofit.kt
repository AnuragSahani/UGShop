package com.example.ugshop

import com.example.ugshop.network.UGInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UGRetrofit {
    var retrofit : UGInterface = Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(UGInterface :: class.java)
}