package com.example.ugshop;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.example.ugshop.view.ProductImagesAdapter;
import com.example.ugshop.view.adapter.ProductDetailsAdapter;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    //first page product_image_layout
    private ViewPager productImageViewPager;
    private TableLayout viewpagerIndicator;

    //second page product_description_text_layout
    private ViewPager productDetailsViewPager;
    private  TableLayout productDetailsTabLayout;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //TODO: ma'am please fix here toolbar error 1
   //1     setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Variable Assign 1st Page
        productImageViewPager = findViewById(R.id.product_images_viewpager);
        viewpagerIndicator = findViewById(R.id.viewpager_indicator);
        //Variable Assign 2nd Page
        productImageViewPager = findViewById(R.id.product_details_viewPager);
        productDetailsTabLayout = findViewById(R.id.product_details_tabLayout);


        //TODO:  Here we want to connect dot with View Pager
  //2      viewpagerIndicator.setupWithViewPager(productImageViewPager,true);

        //TODO: here we create a list for testing

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.m_t_shirt);
        productImages.add(R.drawable.m_trouse);
        productImages.add(R.drawable.m_shorts);
        productImages.add(R.drawable.w_kurtis);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
  //3      productImageViewPager.setupWithViewPager(productImageViewPager,true);

  //4      viewpagerIndicator.setupWithViewPager(productImageViewPager,true);



// for the second page ProductDescription

     /*   productDetailsViewPager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailsTabLayout.getTabCount()));

        productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
        productDetailsTabLayout.addOnTabSelectedListner(new TabLayout.Tab tab){
            //TODO: Two method automatically appear onTabselected and onTabUnselected

            //Do: onTabSelected
            //  productDetailsViewPager.seCurrentItem(tab.getPosition());
        }*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_and_cart_icon,menu);
        return true;
    }
//Search icon and Cart Icon Usage
    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_search_icon) {
            //TODO: Search ma'am please fix 2
            return true;
        }else  if (id == R.id.main_cart_icon){
            //TODO: Search ma'am please fix 3
            return true;
        }else  if (id == R.id.home){
            //TODO: Search ma'am please fix 3
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}