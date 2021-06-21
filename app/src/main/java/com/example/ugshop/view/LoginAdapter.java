package com.example.ugshop.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ugshop.R;

public class LoginAdapter extends FragmentPagerAdapter {
    int totalTabs;
    String[] loginTabs;

    @Override
    public int getCount() {
        return totalTabs;
    }

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.totalTabs = totalTabs;
        loginTabs = context.getResources().getStringArray(R.array.login_tabs);
    }

    @NonNull
    public Fragment getItem(int position) {
        if (position == 1) {
            return new SignupTabFragment();
        }
        return new LoginTabFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return loginTabs[position];
    }
}
