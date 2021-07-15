package com.example.ugshop.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugshop.R;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.viewmodel.LoginPageViewModel;
import com.example.ugshop.viewmodel.SignupViewModel;

public class SignupTabFragment extends Fragment implements View.OnClickListener{

    private EditText mEmail, mUsername, mPassword, mMobileNum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        mEmail = root.findViewById(R.id.email_signup);
        mUsername = root.findViewById(R.id.name);
        mPassword = root.findViewById(R.id.password_signup);
        mMobileNum = root.findViewById(R.id.mobile_number);

        root.findViewById(R.id.Signup).setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Signup) {
            makeSignupApiCall();
        }
    }

    private void makeSignupApiCall() {
        SignupViewModel signupViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        String emailText = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String mobNum = mMobileNum.getText().toString();
        String username = mUsername.getText().toString();
        signupViewModel.signup(emailText, password, username, mobNum)
        .observe(this, new Observer<ApiResource<SignupResponse>>() {
            @Override
            public void onChanged(ApiResource<SignupResponse> signupResponseApiResource) {
                switch (signupResponseApiResource.getStatus()) {
                    case SUCCESS:
                        //Save values to preference
                        Log.d("Mariya", "response : " + signupResponseApiResource.getData());

                        break;
                    case ERROR:
                        new Helper(getActivity()).showToast(R.string.signup_failed);
                        break;
                    case LOADING:
//                        mProgressDialog.show();
                        break;
                }
            }
        });
    }
}
