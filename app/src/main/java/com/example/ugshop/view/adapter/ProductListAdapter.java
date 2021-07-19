package com.example.ugshop.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ugshop.util.Constants;
import com.example.ugshop.util.ItemConstant;

public class ProductListAdapter extends BaseAdapter {
    private Context aContext;
    private int aCount;
    private ItemConstant.ITEM_LIST mItemList;
    private Integer[] mSubCatDrawableIds;
    private String[] mSubCatNames;


    public ProductListAdapter(Context context, ItemConstant.ITEM_LIST item) {
        aContext=context;
        mItemList = item;

        aCount = getSubItemCntFromItemList(mItemList);
    }

    private int getSubItemCntFromItemList(ItemConstant.ITEM_LIST item) {
        switch (item) {
            case SHIRT:
            case T_SHIRT:
                return 4;
            case TROUSER:
                return 2;
            case SHORTS:
                return 6;
        }
        return 0;


    }
    @Override
    public int getCount() { return aCount; }

    @Override
    public Object getItem(int i) { return i; }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        return null;
    }
}
