package com.example.ugshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import static android.graphics.Color.alpha;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton google;
    float v =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout= findViewById(R.id.tab_layout);
        viewPager= findViewById(R.id.view__pager);
        google= findViewById(R.id.fab_google);
         tabLayout.addTab(tabLayout.newTab().setText("Login"));
         tabLayout.addTab(tabLayout.newTab().setText("Signup"));
         tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

         final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
         viewPager.setAdapter(adapter);

         viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

         google.setTranslationY(300);
         google.setAlpha(v);
         // here we animate
         
    }
}