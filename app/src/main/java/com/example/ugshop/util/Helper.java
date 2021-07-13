package com.example.ugshop.util;

import android.app.Activity;
import android.widget.Toast;

public class Helper {

    public static final String LOGIN_ID = "LoginEmail";
    public static final String PASSWORD = "LoginPassword";

    private Activity mActivty;

    public Helper(Activity activity) {
        mActivty = activity;
    }

    public void showToast(int message) {
        Toast.makeText(mActivty, mActivty.getString(message), Toast.LENGTH_LONG).show();
    }
}
