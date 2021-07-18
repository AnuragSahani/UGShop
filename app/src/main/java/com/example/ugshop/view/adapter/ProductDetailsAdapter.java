package com.example.ugshop.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ugshop.view.ProductDescriptionFragment;
import com.example.ugshop.view.ProductSpecificationFragment;

import org.jetbrains.annotations.NotNull;

public class ProductDetailsAdapter extends FragmentPagerAdapter {

    private int totalTabs;
    public ProductDetailsAdapter(@NonNull @NotNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs=totalTabs;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProductDescriptionFragment productDescriptionFragment1 = new ProductDescriptionFragment();
                return productDescriptionFragment1;
            case 1:
                ProductSpecificationFragment productDescriptionFragment = new ProductSpecificationFragment();
                return productDescriptionFragment;
            case 2:
                ProductDescriptionFragment productDescriptionFragment2 = new ProductDescriptionFragment();
                return productDescriptionFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
