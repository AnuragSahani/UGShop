package com.example.ugshop.util;

import android.content.Context;
import android.content.SharedPreferences;

public class UGPreferences {

    private final String PREF_NAME = "UGShopSharedPref";
    private SharedPreferences mPref;

    public UGPreferences(Context context) {
        mPref = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE); // 0 - for private mode
    }

    public void addStringValue(String key, String value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void addBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void addIntValue(String key, int value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void addFloatValue(String key, float value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void addLongValue(String key, long value) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public String getStringValue(String key) {
        return mPref.getString(key, null); // getting String
    }

    public void getIntValue(String key) {
        mPref.getInt(key, -1); // getting Integer
    }

    public void getFloatValue(String key) {
        mPref.getFloat(key, -1); // getting Float
    }

    public void getLongValue(String key) {
        mPref.getLong(key, -1); // getting Long
    }

    public void getBooleanValue(String key) {
        mPref.getBoolean(key, false); // getting Float
    }

    public void removeValue(String key) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.remove(key); // will delete key
        editor.apply();
    }

    public void clearPref() {
        SharedPreferences.Editor editor = mPref.edit();
        editor.clear();
        editor.apply();
    }
}
