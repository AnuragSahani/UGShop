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

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ugshop.R;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.viewmodel.LoginPageViewModel;

public class LoginTabFragment extends Fragment implements View.OnClickListener {
    private final String TAG = LoginTabFragment.class.getSimpleName();

    EditText email;
    EditText password;
    Button login;
    TextView forgetpass;
    private ProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        login = root.findViewById(R.id.login);
        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        forgetpass = root.findViewById(R.id.forget_password);

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

        login.setOnClickListener(this);

        mProgressDialog = new ProgressDialog(getActivity());

        return root;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            LoginPageViewModel loginPageViewModel = ViewModelProviders.of(requireActivity()).get(LoginPageViewModel.class);
            final String emailText = email.getText().toString();
            loginPageViewModel.login(emailText, password.getText().toString())
                    .observe(getViewLifecycleOwner(), loginResponseApiResource -> {
                        if (getActivity() == null) {
                            return;
                        }
                        mProgressDialog.dismiss();
                        switch (loginResponseApiResource.getStatus()) {
                            case SUCCESS:
                                //Save values to preference
                                UGPreferences preferences = new UGPreferences(getActivity());
                                preferences.addStringValue(Helper.LOGIN_ID, emailText);
                                //launch home page
                                Intent homePageIntent = new Intent(getActivity(), HomePage.class);
                                startActivity(homePageIntent);

                                getActivity().finish();

                                break;
                            case ERROR:
                                new Helper(getActivity()).showToast(R.string.login_failed);
                                break;
                            case LOADING:
                                mProgressDialog.show();
                                break;
                        }
                    });



            /*
            FetchAddressRequest request = new FetchAddressRequest();
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
    }
}
