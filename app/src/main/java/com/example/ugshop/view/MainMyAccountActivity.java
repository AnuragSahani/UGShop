package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ugshop.R;

public class MainMyAccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_account);

        findViewById(R.id.add_address).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_address:
                Intent addAddressIntent = new Intent(this, AddDeliveryAddressActivity.class);
                startActivity(addAddressIntent);
                break;
        }
    }
}