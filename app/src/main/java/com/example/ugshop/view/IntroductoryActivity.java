package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ugshop.R;
import com.example.ugshop.util.Constants;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        splashImg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        UGPreferences preferences = new UGPreferences(this);
        String emailID = preferences.getStringValue(Helper.LOGIN_ID);
        if (TextUtils.isEmpty(emailID)) {
            new Handler().postDelayed(()->{
                Intent intent = new Intent(IntroductoryActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            },3000);
        } else {//TODO: launch home intent
            Intent homePageIntent = new Intent(this, HomePage.class);
            homePageIntent.putExtra(Constants.EXTRA_EMAIL, emailID);
            startActivity(homePageIntent);

            finish();
        }

    }

}