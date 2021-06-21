package com.example.ugshop.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import com.example.ugshop.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    TabLayout tabLayout;
    ViewPager viewPager;
    float v = 0;
    private AppCompatButton google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        google = findViewById(R.id.fab_google);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected : " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);

        google.setTranslationY(300);
        tabLayout.setTranslationY(300);

        google.setAlpha(v);
        tabLayout.setAlpha(v);

        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();


    }
}