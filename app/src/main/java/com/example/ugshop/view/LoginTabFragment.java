package com.example.ugshop.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugshop.Email_Authentication;
import com.example.ugshop.R;
import com.example.ugshop.model.response.LoginResponse;
import com.example.ugshop.util.Constants;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.viewmodel.LoginPageViewModel;

public class LoginTabFragment extends Fragment implements View.OnClickListener {
    private final String TAG = LoginTabFragment.class.getSimpleName();

    private EditText email;
    private EditText password;
    private Button login;
    private TextView forgetpass;
    private ProgressDialog mProgressDialog;
    private TextView username;
    private TextView mobileNumder;
    private TextView emailAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        login = root.findViewById(R.id.login);
        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        forgetpass = (TextView) root.findViewById(R.id.forget_password);
        username = root.findViewById(R.id.name);
        mobileNumder = root.findViewById(R.id.cellNo);
        emailAccount = root.findViewById(R.id.email);

        email.setTranslationX(800);
        password.setTranslationX(800);
        forgetpass.setTranslationX(800);
        login.setTranslationX(800);

        float v = 0;
        email.setAlpha(v);
        password.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        forgetpass.setOnClickListener(this);
        login.setOnClickListener(this);
        forgetpass.setOnClickListener(this);
        mProgressDialog = new ProgressDialog(getActivity());
        return root;
    }



//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        forgetpass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setTargetFragment(new Reset_Password_Fragment(), 5);
//            }
////            private void setFragment(Reset_Password_Fragment reset_password_fragment) {
////                Intent i = new Intent();
////                i.setClass(getActivity(), Reset_Password_Fragment.class);
////                startActivity(i);
////            }
//////          Intent forgetpasswordIntent = new Intent(forgetpass.getContext(),Reset_Password_Fragment.class);
////                forgetpass.getContext().startActivity(forgetpasswordIntent);
//        });
//    }

    @Override
    public void onClick(View view) {
        //Validation...................................................................
        if (view.getId() == R.id.login) {//View -> instance of ViewModel || ViewModel -> instance of Repository (network / database)
//            LoginPageViewModel loginPageViewModel = ViewModelProviders.of(requireActivity()).get(LoginPageViewModel.class);
            final String emailId = email.getText().toString();
            final String passwordField = password.getText().toString();
            if (emailId.length() == 0) {
                email.requestFocus();
                email.setError("Email can't be Empty");
                return;
            } else if (!emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                email.requestFocus();
                email.setError("Given email-id is not valid");
                return;
            }
            else if (passwordField.length() == 0) {
                password.requestFocus();
                password.setError("Password can't be Empty");
                return;
            }

            LoginPageViewModel loginPageViewModel = new ViewModelProvider(this).get(LoginPageViewModel.class);
            final String emailText = email.getText().toString();
            //validation
            loginPageViewModel.login(emailText, password.getText().toString())
                    .observe(getViewLifecycleOwner(), loginResponseApiResource -> {
                        if (getActivity() == null) {
                            return;
                        }
                        mProgressDialog.dismiss();
                        switch (loginResponseApiResource.getStatus()) {
                            case SUCCESS:
                                LoginResponse response = loginResponseApiResource.getData();
                                if(response.isLoginStatus()) {
                                    if (response.getLoginModel().getVerified() == 1) {
                                        //Save values to preference
                                        UGPreferences preferences = new UGPreferences(getActivity());
                                        preferences.addStringValue(Helper.LOGIN_ID, emailText);
                                        //launch home page
                                        Intent homePageIntent = new Intent(getActivity(), HomePage.class);
                                        homePageIntent.putExtra(Constants.EXTRA_EMAIL, emailText);
                                        startActivity(homePageIntent);
                                        getActivity().finish();
                                    } else {
                                        new Helper(getActivity()).showToast(R.string.verify_account);
                                        Intent intent = new Intent(getActivity(), Email_Authentication.class);
                                        startActivity(intent);
                                    }
                                }
                                break;
                            case ERROR:

                                new Helper(getActivity()).showToast(R.string.login_failed);
                                break;
                            case LOADING:
                                mProgressDialog.show();
                                break;
                        }
                    });
            /*FetchAddressRequest request = new FetchAddressRequest();
            request.setEmail("nt840071@gmail.com");
            Log.d("Mariya", "request : fetch address : " + request);
            loginPageViewModel.fetchAddresses(request).observe(getViewLifecycleOwner(), new Observer<ApiResource<FetchAddressResponse>>() {
                @Override
                public void onChanged(ApiResource<FetchAddressResponse> response) {
                    switch (response.getStatus()) {
                        case LOADING:
                            Log.i(TAG, "onChanged: Address fetching");
                            break;
                        case SUCCESS:
                            Log.i(TAG, "onChanged: Address received : " + (response.getData() != null ? response.getData().getFetchResList() : "null"));
                            break;
                        case ERROR:
                            Log.i(TAG, "onChanged: Address ERROR");
                            break;
                    }
                }
            });*/
                /*apiViewModel.getCats().observe(getViewLifecycleOwner(), new Observer<ApiResource<CatsResponse>>() {
                    @Override
                    public void onChanged(ApiResource<CatsResponse> stringApiResource) {
                        switch (stringApiResource.getStatus()) {
                            case LOADING:
                                Log.i(TAG, "onChanged: Cats fetching");
                                break;
                            case SUCCESS:
                                Log.i(TAG, "onChanged: Cats received : " + stringApiResource.getData());
                                break;
                            case ERROR:
                                Log.i(TAG, "onChanged: Cats Api ERROR");
                                break;
                        }
                    }
                });*/
        }
         else if(R.id.forget_password == view.getId()){
            Intent intent = new Intent(getContext(), Reset_Password_Fragment.class);
            startActivity(intent);
        }
    }
}
