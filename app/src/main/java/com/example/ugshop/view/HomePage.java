package com.example.ugshop.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;
import com.example.ugshop.model.common.CategoryModel;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.util.Constants;
import com.example.ugshop.util.Helper;
import com.example.ugshop.view.adapter.CategoriesAdapter;
import com.example.ugshop.view.adapter.SubCategoriesAdapter;
import com.example.ugshop.view.adapter.TopBrandsRecyclerAdapter;
import com.example.ugshop.viewmodel.HomePageViewModel;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;
    ProgressDialog mProgressDialog;
    private Helper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mHelper = new Helper(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            /*switch (id) {
                case R.id.home:
                    break;
                case R.id.search:
                    break;
                case R.id.myOrder:
                    break;
                case R.id.setting:
                    break;
                case R.id.Account:
                    break;
                default:
                    return true;
            }*/
            return true;
        });
        findViewById(R.id.cart).setOnClickListener(this);
        mProgressDialog = new ProgressDialog(this);
//      TODO: uncomment  makeNetworkCalls();

        inflateData(new ArrayList<>());

    makeTopProductApiCall();
    }

    private void makeTopProductApiCall() {
        // Urls of our images.

        String url1 = "https://source.unsplash.com/random/1080x600";
        String url2 = "https://source.unsplash.com/random/1080x600";
        String url3 = "https://source.unsplash.com/random/1080x600";
        String path = "E://Eclipse//FromGit//app//src//main//res//drawable//clothing.jpg";

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<SliderData>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.imageSlider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
//        sliderDataArrayList.add(new SliderData(path));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }

    private void makeNetworkCalls() {
        mProgressDialog.show();
        String email = getIntent().getStringExtra(Constants.EXTRA_EMAIL);///TODO: take value from shared preference
        HomePageViewModel homePageViewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
        homePageViewModel.fetchCategoryList()
                .observe(this, fetchCategoryResponseApiResource -> {
                    mProgressDialog.dismiss();
                    switch (fetchCategoryResponseApiResource.getStatus()) {
                        case ERROR:
                            mHelper.showToast(R.string.category_failed);
                            break;
                        case SUCCESS:
                            FetchCategoryResponse body = fetchCategoryResponseApiResource.getData();
                            if (body == null || body.getListCat() == null || body.getListCat().isEmpty()) {
                                mHelper.showToast(R.string.category_failed);
                                return;
                            }
                            List<CategoryModel> list = body.getListCat();
                            Log.d("Mandeep", "list size: " + list.size());
                            inflateData(list);
                            break;
                        case LOADING:
                            mProgressDialog.show();
                            break;
                    }
                });
    }

    private void inflateData(List<CategoryModel> list) {
        setUpCategoriesRecyclerView(list);
        //TODO: Neeraj : top Products-> network call OR
        //top_brand recycler view inflate with data
        setupTopBrandsRecyclerView();
        setUpSubCatGridView();
    }

    private void setupTopBrandsRecyclerView() {
        RecyclerView topBrandsRecyclerView = findViewById(R.id.top_brand);
        TopBrandsRecyclerAdapter adapter = new TopBrandsRecyclerAdapter(this);
        topBrandsRecyclerView.setHasFixedSize(true);
        topBrandsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topBrandsRecyclerView.setAdapter(adapter);
    }

    private void setUpCategoriesRecyclerView(List<CategoryModel> list) {
        RecyclerView categoriesRecyclerView = findViewById(R.id.main_recycler);
        CategoriesAdapter adapter = new CategoriesAdapter(this, list);
        categoriesRecyclerView.setHasFixedSize(true);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecyclerView.setAdapter(adapter);
    }


    private void setUpSubCatGridView() {
        GridView menSubCatGrid = findViewById(R.id.men_sub_cat);
        SubCategoriesAdapter adapter = new SubCategoriesAdapter(this, Constants.CATEGORIES.MEN);
        menSubCatGrid.setAdapter(adapter);
        menSubCatGrid.setOnItemClickListener((parent, view, position, id) -> fetchProductsBySubCategory(1, position));

        GridView womenSubCatGrid = findViewById(R.id.women_sub_cat);
        SubCategoriesAdapter adapter2 = new SubCategoriesAdapter(this, Constants.CATEGORIES.WOMEN);
        womenSubCatGrid.setAdapter(adapter2);
        womenSubCatGrid.setOnItemClickListener((parent, view, position, id) -> fetchProductsBySubCategory(2, position));

        GridView kidSubCatGrid = findViewById(R.id.kid_sub_cat);
        SubCategoriesAdapter adapterKid = new SubCategoriesAdapter(this, Constants.CATEGORIES.KIDS);
        kidSubCatGrid.setAdapter(adapterKid);
        kidSubCatGrid.setOnItemClickListener((parent, view, position, id) -> fetchProductsBySubCategory(3, position));
    }

    private void fetchProductsBySubCategory(int catId, int subCatId) {
        //TODO: land to products page by sub category id
        Log.d("Mariya", "catId = " + catId + " : subCatId = " + (subCatId + 1));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart:
                Intent cartIntent = new Intent(this, MyCartEmpty.class);
                startActivity(cartIntent);
                break;
            case R.id.searchView:

        }
    }
}