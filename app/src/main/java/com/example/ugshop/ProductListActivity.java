package com.example.ugshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugshop.model.common.CartModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.model.request.AddToCartRequest;
import com.example.ugshop.model.response.AddToCartResponse;
import com.example.ugshop.model.response.FetchProductListResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Constants;
import com.example.ugshop.util.Helper;
import com.example.ugshop.util.UGPreferences;
import com.example.ugshop.view.MyCartActivity;
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

        TextView title = findViewById(R.id.categories_item_name_tv);
        title.setText(getCatSubCatString(catId, subCatId));
        mProductListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        getProductList(catId, subCatId);
    }

    //    menShirt, menTShirt,menTrouser, menShorts,
//    womenKurtis, womenTops, womenTrousers, womenTees,
//    kidTrousers, kidTShirts
    private String getCatSubCatString(int catId, int subCatId) {
        StringBuilder str = new StringBuilder();
        switch (catId) {
            case 1:
                str.append("Men");
                switch (subCatId) {
                    case 1:
                        str.append(" | Shirt");
                        break;
                    case 2:
                        str.append(" | T-Shirt");
                        break;
                    case 3:
                        str.append(" | Trouser");
                        break;
                    case 4:
                        str.append(" | Shorts");
                        break;
                }
                break;

            case 2:
                str.append("Women");
                switch (subCatId - 4) {
                    case 1:
                        str.append(" | Kurtis");
                        break;

                    case 2:
                        str.append(" | Tees");
                        break;

                    case 3:
                        str.append(" | Tops");
                        break;
                    case 4:
                        str.append(" | Trousers");
                        break;
                }
                break;

            case 3:
                str.append("Kids");
                switch (subCatId - 8) {
                    case 1:
                        str.append(" | Trousers");
                        break;

                    case 2:
                        str.append(" | T-Shirt");
                        break;
                }
        }
        return str.toString();
    }

    private void setupToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.findViewById(R.id.cart).setOnClickListener(view -> {
            Intent cartIntent = new Intent(ProductListActivity.this, MyCartActivity.class);
            startActivity(cartIntent);
        });
    }

    private void getProductList(int catId, int subCatId) {
        if (catId != -1) {
            if (subCatId != -1) {
                fetchProductsBySubCategory(catId, subCatId);
            } else {
                fetchProductsByCatId(catId);//TODO:
            }

        } else {
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

    private void fetchProductsByCatId(int catId) {

        ProductListViewModel productListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        productListViewModel.fetchProductByCategory(catId)
                .observe(ProductListActivity.this, new Observer<ApiResource<FetchProductListResponse>>() {
                    @Override
                    public void onChanged(ApiResource<FetchProductListResponse> fetchProductBySubCategoryresponseApiResource) {
                        switch (fetchProductBySubCategoryresponseApiResource.getStatus()) {
                            case SUCCESS:
                                //Save values to preference

                                Log.d("Mariya", "response : " + fetchProductBySubCategoryresponseApiResource.getData());
                                FetchProductListResponse response = fetchProductBySubCategoryresponseApiResource.getData();
                                List<ProductModel> productsList = response.getProductList();
                                Log.d("Mariya", "list size: " + productsList.size());
                                inflateDataForProductsAdapter(productsList);
                                break;
                            case ERROR:
                                new Helper(ProductListActivity.this).showToast(R.string.fetching_data_Error);
                                break;
                            case LOADING:
//                        mProgressDialog.show();
                                break;
                        }
                    }
                });


    }

    private void fetchProductsBySubCategory(int catId, int subCatId) {
        //TODO: land to products page by sub category id
        Log.d("Mariya", "catId = " + catId + " : subCatId = " + (subCatId + 1));

        ProductListViewModel productListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        productListViewModel.fetchProductBySubCategory(catId, subCatId)
                .observe(ProductListActivity.this, new Observer<ApiResource<FetchProductListResponse>>() {
                    @Override
                    public void onChanged(ApiResource<FetchProductListResponse> fetchProductBySubCategoryresponseApiResource) {
                        switch (fetchProductBySubCategoryresponseApiResource.getStatus()) {
                            case SUCCESS:
                                //Save values to preference

                                Log.d("Mariya", "response : " + fetchProductBySubCategoryresponseApiResource.getData());
                                FetchProductListResponse response = fetchProductBySubCategoryresponseApiResource.getData();
                                List<ProductModel> productsList = response.getProductList();
                                Log.d("Mariya", "list size: " + productsList.size());
                                inflateDataForProductsAdapter(productsList);
                                break;
                            case ERROR:
                                new Helper(ProductListActivity.this).showToast(R.string.fetching_data_Error);
                                break;
                            case LOADING:
//                        mProgressDialog.show();
                                break;
                        }
                    }
                });

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
        UGPreferences preferences = new UGPreferences(getApplication());
        String email = preferences.getStringValue(Helper.LOGIN_ID);
        AddToCartRequest addToCartRequest = new AddToCartRequest();
        addToCartRequest.setEmail(email);//(new UGPreferences(this).getStringValue(Constants.EXTRA_EMAIL));
        addToCartRequest.setCartModel(cartModelItem);

        mProductListViewModel.addToCart(addToCartRequest)
                .observe(this, addToCartResponseApiResource -> {
                    mProgressDialog.dismiss();
                    switch (addToCartResponseApiResource.getStatus()) {
                        case SUCCESS:
                            AddToCartResponse body = addToCartResponseApiResource.getData();
//                            if (body == null) {
//                                mHelper.showToast(R.string.add_to_cart_failed);
//                                return;
//                            }
                            /* else {
                                mHelper.showToast(R.string.item_added_to_cart);
                            }*/
                            if (body.isAdded()) {
                                mHelper.showToast(R.string.item_added_to_cart);
                            } else {
                                System.out.println("Else");
                                mHelper.showToast(R.string.add_to_cart_failed);
                            }
                            break;
                        case ERROR:
                            System.out.println("Error");
                            mHelper.showToast(R.string.add_to_cart_failed);
                            break;
                        case LOADING:
                            mProgressDialog.show();
                            break;
                    }
                });
    }
}