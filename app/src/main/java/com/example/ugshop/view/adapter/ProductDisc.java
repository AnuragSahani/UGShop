package com.example.ugshop.view.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugshop.R;
import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.viewmodel.CartViewModel;

public class ProductDisc extends AppCompatActivity implements View.OnClickListener {
    private TextView quantity;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_disc);

        quantity = findViewById(R.id.product_quantity);

        findViewById(R.id.addToCart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addToCart){
            makeAddToCartApiCall();
        }
    }

    private void makeAddToCartApiCall() {
//        TODO -- get current email
        String email = "nt840071@gmail.com";
// TODO- get selected product's productId
        CartModel cartModel = new CartModel();
        cartModel.setProductId(3); // put productId
        int quantity = Integer.valueOf(this.quantity.getText().toString());
        CartViewModel cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.addToCart(email,cartModel).observe(this, new Observer<ApiResource<AddToCartResponse>>() {
            @Override
            public void onChanged(ApiResource<AddToCartResponse> addToCartResponseApiResource) {
                switch(addToCartResponseApiResource.getStatus()){
                    case LOADING:
//                      mProgressDialog.show();
                        break;
                    case SUCCESS:
                        AddToCartResponse addToCartResponse = addToCartResponseApiResource.getData();
                        if(addToCartResponse.isSuccessAddToCart()){
                            new Helper((Activity) getApplicationContext()).showToast(R.string.cartAdded);
                        }
                        break;
                    case ERROR:
                        new Helper().showToast(R.string.add_address_failed);
                        break;
                }
            }
        });
    }
}
