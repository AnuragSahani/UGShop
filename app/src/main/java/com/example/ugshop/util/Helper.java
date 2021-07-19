package com.example.ugshop.util;

import android.app.Activity;
import android.widget.Toast;

import com.example.ugshop.R;
import com.example.ugshop.model.common.CategoryModel;

public class Helper {

    public static final String LOGIN_ID = "LoginEmail";
    public static final String PASSWORD = "LoginPassword";

    private Activity mActivty;

    public Helper(Activity activity) {
        mActivty = activity;
    }
    public Helper(){}

    public void showToast(int message) {
        Toast.makeText(mActivty, mActivty.getString(message), Toast.LENGTH_LONG).show();
    }

    public int getDrawableByCatId(CategoryModel categoryModel) {
        switch (categoryModel.getId()) {
            case 1:
                return R.drawable.men1;
            case 2:
                return R.drawable.women;
            case 3:
                return R.drawable.kid;
        }
        return 0;
    }

    public int getDrawableByCatId(int catId) {
        switch (catId) {
            case 1:
                return R.drawable.men1;
            case 2:
                return R.drawable.women;
            case 3:
                return R.drawable.kid;
        }
        return 0;
    }

    public int getAddressById(int i) {
        return 0;
    }
}
