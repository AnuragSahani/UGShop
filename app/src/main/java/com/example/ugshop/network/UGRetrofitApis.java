package com.example.ugshop.network;

import com.example.ugshop.model.CatsResponse;
import com.example.ugshop.model.request.AddAddressRequest;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.request.DeleteUserProfileRequest;
import com.example.ugshop.model.request.GetPtoductBySearchStringRequest;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.request.PlaceOrderRequest;
import com.example.ugshop.model.request.RemoveAddressRequest;
import com.example.ugshop.model.request.RemoveFromCartRequest;
import com.example.ugshop.model.request.SignupRequest;
import com.example.ugshop.model.response.AddAddressResponse;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.ChangePasswordResponse;
import com.example.ugshop.model.response.DeleteUserProfileResponse;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.model.response.FetchOrderResponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.model.response.ForgetPasswordResponse;
import com.example.ugshop.model.response.GenerateOtpResponse;
import com.example.ugshop.model.response.GetPtoductBySearchStringResponse;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.model.response.PlaceOrderResponse;
import com.example.ugshop.model.response.RemoveAddressResponse;
import com.example.ugshop.model.response.RemoveFromCartResponse;
import com.example.ugshop.model.response.RemoveUserResponse;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.model.response.VerifyOtpResponse;
import com.example.ugshop.model.response.ViewCartResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UGRetrofitApis {

    //    @Headers({"Accept: application/json"})
    @GET("fetchaddress")
    Call<FetchAddressResponse> fetchAddress(@Query("email") String email);

    @POST("addaddress")
    Call<AddAddressResponse> addAddress(@Body AddAddressRequest request);

    @POST("removeaddress")
    Call<RemoveAddressResponse> removeAddress(@Body RemoveAddressRequest request);

    @POST("addtocart")
    Call<AddToCartResponse> addToCart(@Body AddToCartRequest request);

    @POST("removefromcart")
    Call<RemoveFromCartResponse> removeFromCart(@Body RemoveFromCartRequest request);

    @GET("viewcart")
    Call<ViewCartResponse> viewCart(@Query("email") String email);

    @GET("categories")
    Call<FetchCategoryResponse> fetchCategoryList();

    //Doubt..............................
    @POST("login")
    Call<LoginResponse> fetchLogIn(@Body LoginRequest request);
//...................................

    @POST("changePassword")
    Call<ChangePasswordResponse> changePassword(LoginRequest loginRequest);

    @GET("products")
    Call<FetchProductListResponse> fetchProductList();
//
//    @POST("fetchProductCategoryMapping")
//    Call<FetchProductCategoryMappingResponse>  fetchProductCategoryMapping (@Body FetchProductCategoryMappingRequest request);

    @GET("productbycategory")
    Call<FetchProductListResponse> fetchProductListByCategory(@Query("catId") int catId);

    @GET("productbysubcategory")
    Call<FetchProductListResponse> fetchProductBySubCategory(@Query("catId") int catId, @Query("subCatId") int subCatId);

    @GET("getPtoductBySearchString")
    Call<GetPtoductBySearchStringResponse> getPtoductBySearchString(@Body GetPtoductBySearchStringRequest request);
//.....................................

    @POST("signup")
    Call<SignupResponse> signup(@Body SignupRequest request);


    @POST("deleteUserProfile")
    Call<DeleteUserProfileResponse> deleteUserProfile(@Body DeleteUserProfileRequest request);

    @GET("catapi/rest/")
    Call<CatsResponse> getCatsApi();//For testing

    @GET("generateotp")
    Call<GenerateOtpResponse> generateOtp(@Query("email") String email);

    @GET("verifyotp")
    Call<VerifyOtpResponse> verifyOtp(@Query("otpCode") int otpCode, @Query("email") String email);

    @GET("forgetpassword")
    Call<ForgetPasswordResponse> forgetPassword(@Query("email") String email);

    @POST("placeorder")
    Call<PlaceOrderResponse> placeOrder(@Body PlaceOrderRequest placeOrderRequest);

    @GET("fetchorderlist")
    Call<FetchOrderResponse> fetchOrderList(@Query("email") String email);

    @POST("removeuser")
    Call<RemoveUserResponse> removeUserProfile(@Body LoginRequest loginRequest);
}
