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
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ugshop.R;
import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.model.response.RemoveFromCartResponse;
import com.example.ugshop.model.response.ViewCartResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.view.adapter.CartAdapter;
import com.example.ugshop.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartActivity extends AppCompatActivity {

    private ViewGroup mEmptyCartView, mBottomLayout;
    private RecyclerView mCartItemsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_cart_with_product);

        initView();

    }

    private void initView() {
        mEmptyCartView = findViewById(R.id.empty_cart_view);
        mBottomLayout = findViewById(R.id.bottom_layout);
        mCartItemsRecyclerView = findViewById(R.id.cart_items_recycler_view);

        setEmptyCartVisible(true);

        makeViewCartCall();
    }

    private void makeViewCartCall() {
        CartViewModel cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        cartViewModel.viewCart("nt840071@gmail.com")
                .observe(this, viewCartResponseApiResource -> {
                    switch(viewCartResponseApiResource.getStatus()){
                        case LOADING:
//                      mProgressDialog.show();
                            break;
                        case SUCCESS:
                            ViewCartResponse viewCartRes = viewCartResponseApiResource.getData();
                            Log.d("Anurag","response : " + viewCartRes);
                            if(viewCartRes != null && viewCartRes.getProductList() != null && !viewCartRes.getProductList().isEmpty()){
                                List<ProductModel> productList = viewCartRes.getProductList();
                                inflateProducts(productList);
                            } else {
                                //For tesing only
                                List<ProductModel> productList = new ArrayList<>();
                                ProductModel productModel = new ProductModel();
                                productModel.setProductId(3);
                                productModel.setCatId(1);
                                productModel.setQuantity(1);
                                productModel.setPrice(1200);
                                productModel.setDescription("100% cotton fabric");
                                productModel.setSubCatId(1);

                                productList.add(productModel);
                                inflateProducts(productList);
                            }
                            break;
                        case ERROR:
                            new Helper().showToast(R.string.add_address_failed);
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
        CartModel cartModel = new CartModel();
        cartModel.setProductId(product.getProductId());
        cartModel.setQuantity(product.getQuantity());
        cartViewModel.removeFromCart("nt840071@gmail.com", cartModel)
                .observe(this, removeFromCartResponseApiResource -> {
                    switch(removeFromCartResponseApiResource.getStatus()){
                        case LOADING:
//                      mProgressDialog.show();
                            break;
                        case SUCCESS:
                            RemoveFromCartResponse removeFromCartRes = removeFromCartResponseApiResource.getData();
                            if(removeFromCartRes != null && removeFromCartRes.isSuccessRemoveFromCart()){
                                makeViewCartCall();
                            }
                            break;
                        case ERROR:
                            new Helper().showToast(R.string.add_address_failed);
                            break;
                    }
                });
    }
}