package com.example.ugshop.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugshop.R;
import com.example.ugshop.model.response.SignupResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
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

//Validation............................................................
        final  String emailSignup= mEmail.getText().toString();
        final  String passwordSignUpField = mPassword.getText().toString();
        final String usernameSignup =mUsername.getText().toString();
        final String mobileSignup = mMobileNum.getText().toString();

        if (usernameSignup.length()==0){
            mUsername.requestFocus();
            mUsername.setError("Name field can't be empty");
        }
        else if(!usernameSignup.matches("[a-zA-Z ]+")){
            mUsername.requestFocus();
            mUsername.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        if (mobileSignup.length()==0){
            mMobileNum.requestFocus();
            mMobileNum.setError("Mobile number can't be Empty!");
        }
        else if(!mobileSignup.matches("^\\d{10}$")){
            mMobileNum.requestFocus();
            mMobileNum.setError("Invalid! Mobile Number");
        }
        if (emailSignup.length()==0){
            mEmail.requestFocus();
            mEmail.setError("Email can't be Empty");
        }
        else if (!emailSignup.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            mEmail.requestFocus();
            mEmail.setError("Given email-id is not valid");
        }
        if (passwordSignUpField.length()==0){
            mPassword.requestFocus();
            mPassword.setError("Password can't be Empty");
        }
        else if(!passwordSignUpField.matches("^(?=.*[0-9])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$")){
            mPassword.requestFocus();
            mPassword.setError("Password at least 8 character.Please! Enter at least 1 digit & 1 special Symbol.Blank Space Not allowed");
        }

        else if (view.getId() == R.id.Signup){
            makeSignUpApiCall();
        }
// Validation...................................................................


     /*   if (view.getId() == R.id.Signup) {
            makeSignUpApiCall();
        }*/
    }

    private void makeSignUpApiCall() {
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
                        SignupResponse responce = signupResponseApiResource.getData();
                        if (responce.isSigned()){
                        UGPreferences preferences = new UGPreferences(getActivity());
                        preferences.addStringValue(Helper.LOGIN_ID, emailText);
                        //TODO: send call back to login activities to scroll page to login tab
                        ((LoginActivity)getActivity()).setCurrentViewPagerItem(1);
                        new Helper(getActivity()).showToast(R.string.sign_success);
                        }
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
