package com.example.ugshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class My_Cart_Empty extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__cart__empty);

        button = findViewById(R.id.shop_now_empty_cart);
        lottieAnimationView =findViewById(R.id.empty_cart_anim);

        lottieAnimationView.animate().setDuration(1000).setStartDelay(4000);
    }
}