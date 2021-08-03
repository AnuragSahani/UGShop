package com.example.ugshop.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ugshop.R;
import com.example.ugshop.model.response.ForgetPasswordResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.viewmodel.LoginPageViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reset_Password_Fragment newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reset_Password_Fragment extends AppCompatActivity implements View.OnClickListener /*Fragment*/ {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//    public Reset_Password_Fragment() {
//        // Required empty public constructor
//    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reset_Password_Fragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static Reset_Password_Fragment newInstance(String param1, String param2) {
//        Reset_Password_Fragment fragment = new Reset_Password_Fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
    private Button forgetBtn;
    private EditText emailId;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reset__password_);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        forgetBtn = findViewById(R.id.reset_password_btn);
        emailId = findViewById(R.id.forgot_password_email);
        forgetBtn.setOnClickListener(this);
    }

    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_reset__password_, container, false);
//    }

    @Override
    public void onClick(View view) {
//        String email = String.valueOf(emailId.getText());
//        if (email.length() == 0) {
//            emailId.requestFocus();
//            emailId.setError("Email can't be Empty");
//            return;
//        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
//            emailId.requestFocus();
//            emailId.setError("Given email-id is not valid");
//            return;
//        }
        if(view.getId() == R.id.reset_password_btn){
            String email = String.valueOf(emailId.getText());
            if (email.length() == 0) {
                emailId.requestFocus();
                emailId.setError("Email can't be Empty");
                return;
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                emailId.requestFocus();
                emailId.setError("Given email-id is not valid");
                return;
            }
            LoginPageViewModel loginPageViewModel = new ViewModelProvider(this).get(LoginPageViewModel.class);
            loginPageViewModel.forgetPassword(email)
                    .observe(this, new Observer<ApiResource<ForgetPasswordResponse>>() {
                @Override
                public void onChanged(ApiResource<ForgetPasswordResponse> forgetPasswordResponseApiResource) {
                    switch (forgetPasswordResponseApiResource.getStatus()){
                        case LOADING:
                            break;
                        case SUCCESS:
                            ForgetPasswordResponse response = forgetPasswordResponseApiResource.getData();
                            if(response.isSend()){
                                new Helper(Reset_Password_Fragment.this).showToast(R.string.password_send);
                            }
                            else{
                                new Helper(Reset_Password_Fragment.this).showToast(R.string.something_error);
                            }
                            break;
                        case ERROR:
                            new Helper(Reset_Password_Fragment.this).showToast(R.string.check_connection);
                            break;
                    }
                }
            });
        }
    }
}