package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ugshop.R;

public class MyAccountMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_account);
        setAddress();
    }

    void setAddress(){
     String s = "BRD Medical College Near Power House Gorakhpur UP Pin - 273013";
    }
}