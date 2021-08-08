package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.airbnb.lottie.L;
import com.example.ugshop.R;
import com.example.ugshop.model.request.LoginRequest;
import com.example.ugshop.model.response.RemoveUserResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.viewmodel.LoginPageViewModel;

public class DeactivateAccount extends AppCompatActivity implements View.OnClickListener {
    private Button deactivateBtn;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deacivate_account);
        deactivateBtn = findViewById(R.id.deactivate_account_btn);
        password = findViewById(R.id.password_deactive_acc);
        deactivateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.deactivate_account_btn){
            makeDeactivateApiCall();
        }
    }

    private void makeDeactivateApiCall() {
        UGPreferences preferences = new UGPreferences(getApplicationContext());
        String email = preferences.getStringValue(Helper.LOGIN_ID);
        String password = this.password.getText().toString();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        LoginPageViewModel loginPageViewModel = new ViewModelProvider(this).get(LoginPageViewModel.class);
        loginPageViewModel.removeUserProfile(loginRequest).observe(this, new Observer<ApiResource<RemoveUserResponse>>() {
            @Override
            public void onChanged(ApiResource<RemoveUserResponse> removeUserResponseApiResource) {
                switch (removeUserResponseApiResource.getStatus()){
                    case ERROR:
                        new Helper(DeactivateAccount.this).showToast(R.string.something_error);
                        break;
                    case SUCCESS:
                        RemoveUserResponse response = removeUserResponseApiResource.getData();
                        if(response.isDeleted()){
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finishAffinity();
                            new Helper(DeactivateAccount.this).showToast(R.string.account_deactivated);
                        }
                        else{
                            new Helper(DeactivateAccount.this).showToast(R.string.something_error);
                        }
                        break;
                    case LOADING:

                        break;
                }
            }
        });
    }
}