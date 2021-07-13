package com.example.ugshop.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ugshop.R;
import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            //                int id = MenuItem.getItemId();
//                switch (id) {
//                    case R.id.home:
//                        break;
//                    case R.id.search:
//                        break;
//                    case R.id.myOrder:
//                        break;
//                    case R.id.setting:
//                        break;
//                    case R.id.Account:
//                        break;
//                    default:
//                        return true;
//                }
            return true;
        });
        findViewById(R.id.cart).setOnClickListener(this);

        makeNetworkCalls();
    }

    private void makeNetworkCalls() {
        String email = getIntent().getStringExtra("EMAIL");///TODO: take value from shared preference
        //TODO: fetch category list
        //TODO: after response
        //inflateData();
    }

    private void inflateData() {
        //main_recycler : adapter
        //TODO: Neeraj : top Products-> network call OR
        //top_brand recycler view inflate with data
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart:
                Intent cartIntent = new Intent(this, MyCartEmpty.class);
                startActivity(cartIntent);
                break;
        }
    }
}