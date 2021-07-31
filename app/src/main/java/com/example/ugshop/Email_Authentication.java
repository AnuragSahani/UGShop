package com.example.ugshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ugshop.model.response.GenerateOtpResponse;
import com.example.ugshop.model.response.VerifyOtpResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.view.LoginActivity;
import com.example.ugshop.viewmodel.GenerateOtpViewModel;
import com.example.ugshop.viewmodel.SignupViewModel;
import com.example.ugshop.viewmodel.VerifyOtpViewModel;

public class Email_Authentication extends AppCompatActivity {

    TextView timer;
    EditText email_et, otp_et;
    Button sendOtpBtn, resendBtn, verifyBtn;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_authentication);

         timer = findViewById(R.id.timer_Authentication);
         sendOtpBtn = findViewById(R.id.Send_otp_btn_Authentication);
         resendBtn = findViewById(R.id.Resend_otp_Authentication);
         verifyBtn = findViewById(R.id.Verify_otp_Authentication);
         email_et = findViewById(R.id.Email_ID_Authentication);
         otp_et = findViewById(R.id.Enter_otp_Authentication);

         countDownTimer = new CountDownTimer(5000,1000) {
             @Override
             public void onTick(long l) {
                 timer.setText(l/1000+"sec left");
             }

             @Override
             public void onFinish() {
                 timer.setText("time finish");
                 resendBtn.setVisibility(View.VISIBLE);
             }
         };

         sendOtpBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 sendOtpBtn.setVisibility(View.INVISIBLE);
                 countDownTimer.start();
                 generateOTP(email_et.getText().toString());


             }
         });

        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
                generateOTP(email_et.getText().toString());

            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //TODO: network call (From here send the OTP to backend)
                int otp_be = Integer.parseInt(otp_et.getText().toString());
                apiCallForVerifyOtp(otp_be,email_et.getText().toString());

            }
        });


    }
    private void apiCallForVerifyOtp(int otp_be, String email) {

        VerifyOtpViewModel verifyOtpViewModel = new ViewModelProvider(this).get(VerifyOtpViewModel.class);
        verifyOtpViewModel.verifyOtp(otp_be,email)
                .observe(this, new Observer<ApiResource<VerifyOtpResponse>>() {


                    @Override
                    public void onChanged(ApiResource<VerifyOtpResponse> verifyOtpResponseApiResource) {

                        switch (verifyOtpResponseApiResource.getStatus()){

                            case SUCCESS:
                                VerifyOtpResponse response = verifyOtpResponseApiResource.getData();
                                if(response.isVerified()){
                                    //TODO: change toast msg
                                    new Helper(Email_Authentication.this).showToast(R.string.OTP_Send_Sucessfully);
                                    Intent intent = new Intent(Email_Authentication.this,LoginActivity.class);
                                    startActivity(intent);
                                    finish();

                                   // Toast.makeText(getApplicationContext(),"Verified Successfully",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    //TODO: ma'am why it's comes in the else part always????????
                                    /*Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(intent);
                                    finish();*/
                                    Toast.makeText(getApplicationContext(),"Not Verified",Toast.LENGTH_LONG).show();
                                }
                                break;

                            case ERROR:
                                //TODO: Error
                                break;

                            case LOADING:
                                //TODO: Loading
                                break;

                        }

                    }
                });
    }

    private void setVerifyLayoutVisibility(boolean visibility) {
        if (visibility) {
            otp_et.setVisibility(View.VISIBLE);
            timer.setVisibility(View.VISIBLE);
            verifyBtn.setVisibility(View.VISIBLE);
        } else {
            otp_et.setVisibility(View.GONE);
            timer.setVisibility(View.GONE);
            verifyBtn.setVisibility(View.GONE);
        }
    }
    private void generateOTP(String email_send){
        //TODO: network call (From here send the email and receive OTP)
        GenerateOtpViewModel generateOtpViewModel = new ViewModelProvider(this).get(GenerateOtpViewModel.class);
        generateOtpViewModel.generateOtp(email_send)
                .observe(this, new Observer<ApiResource<GenerateOtpResponse>>() {
                    @Override
                    public void onChanged(ApiResource<GenerateOtpResponse> generateOtpResponseApiResource) {
                        switch (generateOtpResponseApiResource.getStatus()){

                            case SUCCESS:
                                GenerateOtpResponse generateOtpResponse = generateOtpResponseApiResource.getData();
                                if(generateOtpResponse.isSent()){
                                    setVerifyLayoutVisibility(true);
//                                    new Helper((Activity) getApplicationContext()).showToast(R.string.OTP_Send_Sucessfully);
                                    Toast.makeText(getApplicationContext(),"Sending Successfully",Toast.LENGTH_LONG).show();
                                }
                                else {
                                    setVerifyLayoutVisibility(false);
                                    Toast.makeText(getApplicationContext(),"Sending Failed",Toast.LENGTH_LONG).show();
                                }
                                break;

                            case ERROR:
                                //TODO: Error
                                break;

                            case LOADING:
                                //TODO: Loading
                                break;

                        }
                    }
                });
    }
}