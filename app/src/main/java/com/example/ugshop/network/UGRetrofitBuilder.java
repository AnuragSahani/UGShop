package com.example.ugshop.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UGRetrofitBuilder {

    private static final String BASE_URL = "http://9b6d62ee9fb5.ngrok.io/";//"http://bbfd1f3cb175.ngrok.io/" // https://thatcopy.pw//;
    private static Retrofit sRetrofitInstance;

    private static Retrofit getRetrofit() {
        if (sRetrofitInstance != null) {
            return sRetrofitInstance;
        }
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                /*.addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                                Credentials.basic("aUsername", "aPassword"));

                        Request newRequest = builder.build();
                        return chain.proceed(newRequest);
                    }
                })*/
//                .connectTimeout(90, TimeUnit.SECONDS)
//                .readTimeout(90, TimeUnit.SECONDS)
//                .writeTimeout(90, TimeUnit.SECONDS)
                .build();

        sRetrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return sRetrofitInstance;
    }

    public static UGRetrofitApis getNetworkApi() {
        return getRetrofit().create(UGRetrofitApis.class);
    }
}
