package com.example.ugshop.network;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.response.FetchAddressResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UGRetrofitApis {

    @POST("fetchaddress")
    Call<FetchAddressResponse> fetchAddress(@Body FetchAddressRequest request);

    @GET("catapi/rest/")
    Call<CatsResponse> getCatsApi();//For testing
}
