package com.example.ugshop.network;

import android.util.Log;

import androidx.lifecycle.LiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitLiveData<T> extends LiveData<ApiResource<T>> {//Observable design pattern
    private final String TAG = this.getClass().getSimpleName();

    private Call<T> call;

    public RetrofitLiveData(Call<T> call) {
        this.call = call;
        setValue(ApiResource.loading());
    }

    Callback<T> callback = new Callback<T>() {
        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            Log.d(TAG, "Response Received is : " + response);
            setValue(ApiResource.create(response));
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.d(TAG, "Network Call Failed with : " + t.getMessage());
            setValue(ApiResource.failure(t.getMessage()));
        }
    };

    @Override
    protected void onActive() {
        super.onActive();
        try {
            call.enqueue(callback);
        } catch (IllegalStateException e) {

        }
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        if (!hasActiveObservers()) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
    }
}
