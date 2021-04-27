package com.example.ugshop;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTab;

    @Override
    public int getCount() {
        return totalTab;
    }

    public LoginAdapter(FragmentManager fm, Context context, int totalTab){
        super(fm);
        this.context = context;
        this.totalTab = totalTab;
    }

    public Fragment getItem(int position){
        switch (position){
            case  0:
                LoginTabFragment loginTabFragment =new LoginTabFragment();
                return loginTabFragment;
            case  1:
                SignupTabFragment signupTabFragment=  new SignupTabFragment();
                return signupTabFragment;
            default:return null;

        }
    }
}
