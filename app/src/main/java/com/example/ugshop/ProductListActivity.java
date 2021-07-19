package com.example.ugshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.util.Constants;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.view.adapter.ProductListAdapter;
import com.example.ugshop.viewmodel.ProductListViewModel;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private Helper mHelper;
    private ProductListViewModel mProductListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mProgressDialog = new ProgressDialog(this);
        mHelper = new Helper(this);
        setupToolBar();

        if (getIntent() == null && getIntent().getExtras() == null) {
            mHelper.showToast(R.string.no_products_available);
            return;
        }
        Intent getIntent = getIntent();
        int catId = getIntent.getIntExtra(Constants.EXTRA_CAT_ID, -1);
        int subCatId = getIntent.getIntExtra(Constants.EXTRA_SUB_CAT_ID, -1);

        mProductListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        getProductList(catId, subCatId);
    }

    private void setupToolBar() {

    }

    private void getProductList(int catId, int subCatId) {
        if (catId != -1) {
            mProductListViewModel.fetchProductList()
                    .observe(this, fetchProductListResponseApiResource -> {
                        mProgressDialog.dismiss();
                        switch (fetchProductListResponseApiResource.getStatus()) {
                            case SUCCESS:
                                FetchProductListResponse body = fetchProductListResponseApiResource.getData();
                                if (body == null || body.getProductList() == null || body.getProductList().isEmpty()) {
                                    mHelper.showToast(R.string.category_failed);
                                    return;
                                }
                                List<ProductModel> productsList = body.getProductList();
                                Log.d("Mariya", "list size: " + productsList.size());
                                inflateDataForProductsAdapter(productsList);
                                break;
                            case ERROR:
                                mHelper.showToast(R.string.get_products_list_failed);
                                break;
                            case LOADING:
                                mProgressDialog.show();
                                break;
                        }
                    });
        }
    }

    private void inflateDataForProductsAdapter(List<ProductModel> productsList) {
        GridView gridView = findViewById(R.id.products_grid_view);
        ProductListAdapter adapter = new ProductListAdapter(this, productsList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            //launch ProductDetails page
        });
    }

    public void makeAddToCartApiCall(ProductModel productModel) {
        CartModel cartModelItem = new CartModel();
        cartModelItem.setProductId(productModel.getProductId());
        cartModelItem.setQuantity(1);
        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setUserEmail(new UGPreferences(this).getStringValue(Constants.EXTRA_EMAIL));
        addToCartRequest.setCartModel(cartModelItem);

        mProductListViewModel.addToCart(addToCartRequest)
                .observe(this, addToCartResponseApiResource -> {
                    mProgressDialog.dismiss();
                    switch (addToCartResponseApiResource.getStatus()) {
                        case SUCCESS:
                            AddToCartResponse body = addToCartResponseApiResource.getData();
                            if (body == null) {
                                mHelper.showToast(R.string.add_to_cart_failed);
                                return;
                            } else {
                                mHelper.showToast(R.string.item_added_to_cart);
                            }
                            break;
                        case ERROR:
                            mHelper.showToast(R.string.add_to_cart_failed);
                            break;
                        case LOADING:
                            mProgressDialog.show();
                            break;
                    }
                });
    }
}