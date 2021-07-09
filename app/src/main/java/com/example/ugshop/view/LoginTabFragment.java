package com.example.ugshop.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ugshop.R;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.viewmodel.ApiViewModel;

public class LoginTabFragment extends Fragment implements View.OnClickListener {
    private final String TAG = LoginTabFragment.class.getSimpleName();
    EditText email;
    EditText password;
    Button login;
    TextView forgetpass;
    float v = 0;

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

        email.setAlpha(v);
        password.setAlpha(v);
        forgetpass.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        login.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            ApiViewModel apiViewModel = ViewModelProviders.of(requireActivity()).get(ApiViewModel.class);
            FetchAddressRequest request = new FetchAddressRequest();
            request.setEmail("nt840071@gmail.com");
            apiViewModel.fetchAddresses(request).observe(getViewLifecycleOwner(), new Observer<ApiResource<FetchAddressResponse>>() {
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
            });
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
                /*Intent homePageIntent = new Intent(getActivity(), HomePage.class);
                startActivity(homePageIntent);*/
        }
    }
}
