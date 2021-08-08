package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ugshop.R;
import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.common.OrderModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.model.request.PlaceOrderRequest;
import com.example.ugshop.model.response.PlaceOrderResponse;
import com.example.ugshop.model.response.RemoveFromCartResponse;
import com.example.ugshop.model.response.ViewCartResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.view.adapter.CartAdapter;
import com.example.ugshop.viewmodel.CartViewModel;
import com.example.ugshop.viewmodel.OrderViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewGroup mEmptyCartView, mBottomLayout;
    private RecyclerView mCartItemsRecyclerView;
    private Button mPlaceOrder;
    private List<ProductModel> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_cart_with_product);
        mPlaceOrder = findViewById(R.id.cart_place_order_btn);
        mPlaceOrder.setOnClickListener(this);
        initView();

    }

    private void initView() {
        mEmptyCartView = findViewById(R.id.empty_cart_view);
        mEmptyCartView.findViewById(R.id.shop_now_empty_cart).setOnClickListener(view -> finish());
        mBottomLayout = findViewById(R.id.bottom_layout);
        mCartItemsRecyclerView = findViewById(R.id.cart_items_recycler_view);

        setEmptyCartVisible(true);

        makeViewCartCall();
    }

    private void makeViewCartCall() {
        CartViewModel cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        UGPreferences preferences = new UGPreferences(getApplicationContext());
        String email = preferences.getStringValue(Helper.LOGIN_ID);
        cartViewModel.viewCart(email)
                .observe(this, viewCartResponseApiResource -> {
                    switch(viewCartResponseApiResource.getStatus()){
                        case LOADING:
//                      mProgressDialog.show();
                            break;
                        case SUCCESS:
                            ViewCartResponse viewCartRes = viewCartResponseApiResource.getData();
                            Log.d("Anurag","response : " + viewCartRes);
                            if(viewCartRes != null && viewCartRes.getProductList() != null && !viewCartRes.getProductList().isEmpty()){
                                productList = viewCartRes.getProductList();
                                inflateProducts(productList);
                            } else {
                                setEmptyCartVisible(true);
                                //For tesing only
                                /*List<ProductModel> productList = new ArrayList<>();
                                ProductModel productModel = new ProductModel();
                                productModel.setProductId(3);
                                productModel.setCatId(1);
                                productModel.setStockQuantity(1);
                                productModel.setPrice(1200);
                                productModel.setDescription("100% cotton fabric");
                                productModel.setSubCatId(1);

                                productList.add(productModel);
                                inflateProducts(productList);*/
                            }
                            break;
                        case ERROR:
                            new Helper(MyCartActivity.this).showToast(R.string.add_address_failed);
                            break;
                    }
                });
    }

    private void inflateProducts(List<ProductModel> productList) {
        setEmptyCartVisible(false);
        mCartItemsRecyclerView.setHasFixedSize(true);
        mCartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CartAdapter adapter = new CartAdapter(this, productList);
        mCartItemsRecyclerView.setAdapter(adapter);
        ((TextView)mBottomLayout.findViewById(R.id.total_cart_amount)).setText("Rs. " + adapter.getTotalPrice());

    }

    private void setEmptyCartVisible(boolean isEmpty) {
        if (isEmpty) {
            mEmptyCartView.setVisibility(View.VISIBLE);
            mBottomLayout.setVisibility(View.GONE);
            mCartItemsRecyclerView.setVisibility(View.GONE);
            animateEmptyView(mEmptyCartView);
        } else {
            mEmptyCartView.setVisibility(View.GONE);
            mBottomLayout.setVisibility(View.VISIBLE);
            mCartItemsRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void animateEmptyView(ViewGroup emptyCartView) {
        LottieAnimationView lottieAnimationView = emptyCartView.findViewById(R.id.empty_cart_anim);
        lottieAnimationView.animate().setDuration(1000).setStartDelay(4000);
    }

    public void callRemoveFromCart(ProductModel product) {
        CartViewModel cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        UGPreferences preferences = new UGPreferences(getApplication());
        String email = preferences.getStringValue(Helper.LOGIN_ID);
        CartModel cartModel = new CartModel();
        cartModel.setProductId(product.getProductId());
        cartModel.setQuantity(product.getProductCartQuantity());
        cartViewModel.removeFromCart(email, cartModel)
                .observe(this, removeFromCartResponseApiResource -> {
                    switch(removeFromCartResponseApiResource.getStatus()){
                        case LOADING:
//                      mProgressDialog.show();
                            break;
                        case SUCCESS:
                            RemoveFromCartResponse removeFromCartRes = removeFromCartResponseApiResource.getData();
                            if(removeFromCartRes != null && removeFromCartRes.isRemoved()){
                                makeViewCartCall();
                            }
                            break;
                        case ERROR:
                            new Helper(MyCartActivity.this).showToast(R.string.add_address_failed);
                            break;
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.cart_place_order_btn){
            callPlaceOrder();
        }
    }

    private void callPlaceOrder() {
        UGPreferences preferences = new UGPreferences(getApplicationContext());
        String email = preferences.getStringValue(Helper.LOGIN_ID);
        String deliveryAddress ="";
        long orderAmount = 0;
        for(ProductModel m : productList) {
            orderAmount = orderAmount + (m.getPrice() * m.getProductCartQuantity());
        }
        boolean paymentStatus=false;
        PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
        placeOrderRequest.setDeliveryAddress(deliveryAddress);
        placeOrderRequest.setEmail(email);
        placeOrderRequest.setProductModel(productList);
        placeOrderRequest.setOrderAmount(orderAmount);
        placeOrderRequest.setPaymentStatus(paymentStatus);
        OrderViewModel orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.placeOrder(placeOrderRequest).observe(this, new Observer<ApiResource<PlaceOrderResponse>>() {
            @Override
            public void onChanged(ApiResource<PlaceOrderResponse> placeOrderResponseApiResource) {
                switch (placeOrderResponseApiResource.getStatus()){
                    case ERROR:
                        break;
                    case SUCCESS:
                        PlaceOrderResponse response = placeOrderResponseApiResource.getData();
                        if(response.isOrdered()){

                        }
                        break;

                    case LOADING:
                        break;
                }
            }
        });
    }
}