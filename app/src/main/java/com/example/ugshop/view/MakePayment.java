package com.example.ugshop.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ugshop.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MakePayment extends AppCompatActivity implements PaymentResultListener {

    private static final String TAG = MakePayment.class.getSimpleName();
    Checkout mCheckout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mk_payment);
        mCheckout = new Checkout();
        mCheckout.setKeyID("rzp_test_oO2euOluy8WI7W");
        Checkout.preload(getApplicationContext());




    }

    public void startPayment(View view) {
        try {
            JSONObject options = new JSONObject();
            options.put("key","rzp_test_oO2euOluy8WI7W");
            options.put("name", "UGShop");
            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits

            mCheckout.open(this, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, s+"pass", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        Log.d(TAG, s);
    }
}
