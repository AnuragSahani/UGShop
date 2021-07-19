package com.example.ugshop.view.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;
import com.example.ugshop.model.common.CategoryModel;
import com.example.ugshop.model.response.FetchCategoryResponse;
import com.example.ugshop.util.Constants;
import com.example.ugshop.util.Helper;
import com.example.ugshop.view.SliderAdapter;
import com.example.ugshop.view.SliderData;
import com.example.ugshop.view.adapter.CategoriesAdapter;
import com.example.ugshop.view.adapter.SubCategoriesAdapter;
import com.example.ugshop.view.adapter.TopBrandsRecyclerAdapter;
import com.example.ugshop.viewmodel.HomePageViewModel;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {
    private ViewGroup mRootView;
    private ProgressDialog mProgressDialog;
    private Helper mHelper;
    private Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        if (mActivity == null) {
            return;
        }
        mProgressDialog = new ProgressDialog(mActivity);
        mHelper = new Helper(mActivity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.home_page_content, container, false);

        makeNetworkCalls();
//        inflateData(new ArrayList<>());

        makeTopProductApiCall();
        return mRootView;//super.onCreateView(inflater, container, savedInstanceState);
    }

    private void makeNetworkCalls() {
        mProgressDialog.show();
//        String email = getIntent().getStringExtra(Constants.EXTRA_EMAIL);///TODO: take value from shared preference
        HomePageViewModel homePageViewModel = new ViewModelProvider(this).get(HomePageViewModel.class);
        homePageViewModel.fetchCategoryList()
                .observe(getViewLifecycleOwner(), fetchCategoryResponseApiResource -> {
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
        RecyclerView topBrandsRecyclerView = mRootView.findViewById(R.id.top_brand);
        TopBrandsRecyclerAdapter adapter = new TopBrandsRecyclerAdapter(mActivity);
        topBrandsRecyclerView.setHasFixedSize(true);
        topBrandsRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        topBrandsRecyclerView.setAdapter(adapter);
    }

    private void setUpCategoriesRecyclerView(List<CategoryModel> list) {
        RecyclerView categoriesRecyclerView = mRootView.findViewById(R.id.main_recycler);
        CategoriesAdapter adapter = new CategoriesAdapter(mActivity, list);
        categoriesRecyclerView.setHasFixedSize(true);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecyclerView.setAdapter(adapter);
    }

    private void setUpSubCatGridView() {
        GridView menSubCatGrid = mRootView.findViewById(R.id.men_sub_cat);
        SubCategoriesAdapter adapter = new SubCategoriesAdapter(mActivity, Constants.CATEGORIES.MEN);
        menSubCatGrid.setAdapter(adapter);
        menSubCatGrid.setOnItemClickListener((parent, view, position, id) -> fetchProductsBySubCategory(1, position));

        GridView womenSubCatGrid = mRootView.findViewById(R.id.women_sub_cat);
        SubCategoriesAdapter adapter2 = new SubCategoriesAdapter(mActivity, Constants.CATEGORIES.WOMEN);
        womenSubCatGrid.setAdapter(adapter2);
        womenSubCatGrid.setOnItemClickListener((parent, view, position, id) -> fetchProductsBySubCategory(2, position));

        GridView kidSubCatGrid = mRootView.findViewById(R.id.kid_sub_cat);
        SubCategoriesAdapter adapterKid = new SubCategoriesAdapter(mActivity, Constants.CATEGORIES.KIDS);
        kidSubCatGrid.setAdapter(adapterKid);
        kidSubCatGrid.setOnItemClickListener((parent, view, position, id) -> fetchProductsBySubCategory(3, position));
    }

    private void fetchProductsBySubCategory(int catId, int subCatId) {
        //TODO: land to products page by sub category id
        Log.d("Mariya", "catId = " + catId + " : subCatId = " + (subCatId + 1));
    }

    private void makeTopProductApiCall() {
        // Urls of our images.

        String url1 = "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/7/19/0561c26e-e90f-49e4-ba4f-3158a97179f21626700545599-Occasion_wear_Desk.jpg";
        String url2 = "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/7/19/bc0bb077-6ca5-414f-a30a-b7f8e4e2e8c11626700392540-H-N_Desk_Banner--1-.jpg";
        String url3 = "https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/7/19/e32201fa-5b83-41aa-a945-b700877fc56c1626700797439-desktop-main-banner-1-reference.jpg";

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = mRootView.findViewById(R.id.imageSlider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
//        sliderDataArrayList.add(new SliderData(path));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(mActivity, sliderDataArrayList);

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

}
