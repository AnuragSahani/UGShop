package com.example.ugshop.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.ugshop.R;
import com.example.ugshop.util.Constants;

public class SubCategoriesAdapter extends BaseAdapter {
    private Context mContext;
    private Constants.CATEGORIES mCategory;
    private Integer[] mSubCatDrawableIds;
    private String[] mSubCatNames;
    private int mCount;

    // Constructor
    public SubCategoriesAdapter(Context context, Constants.CATEGORIES category) {
        mContext = context;
        mCategory = category;

        mCount = getSubCatCntFromCat(mCategory);
        mSubCatDrawableIds = getArrayForCategory(mCategory);
        mSubCatNames = getNamesForSubCategory(mCategory);
    }

    public int getCount() {
        return mCount;
    }

    private int getSubCatCntFromCat(Constants.CATEGORIES category) {
        switch (category) {
            case MEN:
            case WOMEN:
                return 4;
            case KIDS:
                return 2;
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    public long getItemId(int position) { return position; }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView;

        if (convertView == null) {
//            rootView = LayoutInflater.from(mContext).inflate(R.layout.sub_cat_item_layout, null);
            rootView = View.inflate(mContext, R.layout.sub_cat_item_layout, null);
        } else {
            rootView = (View) convertView;
        }
//        imageView.setImageResource(mThumbIds[position]);
        ((AppCompatImageView)rootView.findViewById(R.id.sub_cat_imageview)).setImageResource(mSubCatDrawableIds[position]);
        ((TextView) rootView.findViewById(R.id.sub_cat_textview)).setText(mSubCatNames[position]);
        rootView.setTag(position);
        return rootView;
    }

    private String[] getNamesForSubCategory(Constants.CATEGORIES category) {
        int id = -1;
        switch (category) {

            case MEN:
                id = R.array.men_sub_cat;
                break;
            case WOMEN:
                id = R.array.women_sub_cat;
                break;
            case KIDS:
                id = R.array.kid_sub_cat;
                break;
        }
        String[] array = mContext.getResources().getStringArray(id);
        return array;
    }

    private Integer[] getArrayForCategory(Constants.CATEGORIES category) {
        switch (category) {

            case MEN:
                return mMenSubCatIds;
            case WOMEN:
                return mWomenSubCatIds;
            case KIDS:
                return mKidSubCatIds;
        }
        return null;
    }

    // Keep all Images in array
    public Integer[] mMenSubCatIds = {
            R.drawable.m_shirt, R.drawable.m_t_shirt,
            R.drawable.m_trouse, R.drawable.m_shorts
    };
    public Integer[] mWomenSubCatIds = {
            R.drawable.w_kurtis, R.drawable.w_tees,
            R.drawable.w_tops, R.drawable.w_trouser
    };
    public Integer[] mKidSubCatIds = {
            R.drawable.trouser, R.drawable.shirt
    };
}
