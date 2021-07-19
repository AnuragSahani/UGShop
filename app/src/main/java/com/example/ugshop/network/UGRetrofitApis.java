package com.example.ugshop.network;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.AddAddressRequest;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.request.DeleteUserProfileRequest;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.request.FetchCategoryRequest;
import com.example.ugshop.model.request.FetchProductBySubCategoryRequest;
import com.example.ugshop.model.request.FetchProductCategoryMappingRequest;
import com.example.ugshop.model.request.FetchProductListByCategoryRequest;
import com.example.ugshop.model.request.FetchProductListRequest;
import com.example.ugshop.model.request.GetPtoductBySearchStringRequest;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.request.RemoveAddressRequest;
import com.example.ugshop.model.request.RemoveFromCartRequest;
import com.example.ugshop.model.request.SignupRequest;
import com.example.ugshop.model.request.ViewCartRequest;
import com.example.ugshop.model.response.AddAddressResponse;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.ChangePasswordResponse;
import com.example.ugshop.model.response.DeleteUserProfileResponse;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.model.response.FetchProductBySubCategoryresponse;
import com.example.ugshop.model.response.FetchProductCategoryMappingResponse;
import com.example.ugshop.model.response.FetchProductListByCategoryResponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.model.response.GetPtoductBySearchStringResponse;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.model.response.RemoveAddressResponse;
import com.example.ugshop.model.response.RemoveFromCartResponse;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.model.response.ViewCartResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UGRetrofitApis {

    @Headers({"Accept: application/json"})
    @GET("fetchaddress")
    Call<FetchAddressResponse> fetchAddress(@Body FetchAddressRequest request);

    @POST("addaddress")
    Call<AddAddressResponse>  addAddress (@Body AddAddressRequest request);

    @POST("removeaddress")
    Call<RemoveAddressResponse>  removeAddress (@Body RemoveAddressRequest request);

    @POST("addtocart")
    Call<AddToCartResponse> addToCart (@Body AddToCartRequest request);

    @POST("removefromcart")
    Call<RemoveFromCartResponse>  removeFromCart (@Body RemoveFromCartRequest request);

    @POST("viewcart")
    Call<ViewCartResponse>  viewCart (@Body ViewCartRequest request);

    @GET("categories")
    Call<FetchCategoryResponse>  fetchCategoryList ();
//Doubt..............................
    @POST("login")
    Call<LoginResponse>  fetchLogIn (@Body LoginRequest request);
//...................................

    @POST("changePassword")
    Call<ChangePasswordResponse> changePassword(LoginRequest loginRequest);

    @GET("products")
    Call<FetchProductListResponse>  fetchProductList ();
//
//    @POST("fetchProductCategoryMapping")
//    Call<FetchProductCategoryMappingResponse>  fetchProductCategoryMapping (@Body FetchProductCategoryMappingRequest request);

    @POST("productbycategory")
    Call<FetchProductListByCategoryResponse>  fetchProductListByCategory  (@Body FetchProductListByCategoryRequest request);

    @POST("productbysubcategory")
    Call<FetchProductBySubCategoryresponse>  fetchProductBySubCategory  (@Body FetchProductBySubCategoryRequest request);

    @GET("getPtoductBySearchString")
    Call<GetPtoductBySearchStringResponse>  getPtoductBySearchString (@Body GetPtoductBySearchStringRequest request);
//.....................................

    @POST("signup")
    Call<SignupResponse>  signup (@Body SignupRequest request);


    @POST("deleteUserProfile")
    Call<DeleteUserProfileResponse> deleteUserProfile (@Body DeleteUserProfileRequest request);

    @GET("catapi/rest/")
    Call<CatsResponse> getCatsApi();//For testing

}
