package com.example.ugshop.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ugshop.R;

public class AccountSetting extends AppCompatActivity implements View.OnClickListener {

    TextView deactivateAcc;
    ImageView set_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);

        deactivateAcc = findViewById(R.id.deactivate_account);
        set_image = findViewById(R.id.pen_edit_image);
        set_image.setOnClickListener(this);
        deactivateAcc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.deactivate_account:
                Intent deactiveAccount = new Intent(this, DeactivateAccount.class);
                startActivity(deactiveAccount);
                break;
            case R.id.pen_edit_image:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("file/*");
                startActivity(intent);
        }

    }
}