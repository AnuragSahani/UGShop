package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ugshop.R;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        findViewById(R.id.cart).setOnClickListener(this);
        findViewById(R.id.menu_line).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart:
                Intent cartIntent = new Intent(this, MyCartEmpty.class);
                startActivity(cartIntent);
                break;
            case R.id.menu_line:
                Intent accountSettings = new Intent(this, MainMyAccountActivity.class);
                startActivity(accountSettings);
                break;
        }
    }
}