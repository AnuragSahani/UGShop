package com.example.ugshop.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ugshop.R;

public class AccountSetting extends AppCompatActivity implements View.OnClickListener {

    TextView deactivateAcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        deactivateAcc = findViewById(R.id.deactivate_account);

        deactivateAcc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.deactivate_account:
                Intent deactiveAccount = new Intent(this, DeactivateAccount.class);
                startActivity(deactiveAccount);
        }

    }
}