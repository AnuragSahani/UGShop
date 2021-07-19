package com.example.ugshop.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ugshop.ProductListActivity;
import com.example.ugshop.R;
import com.example.ugshop.model.common.ProductModel;

import java.util.List;

public class ProductListAdapter extends BaseAdapter implements View.OnClickListener {

    private final List<ProductModel> mProductsList;
    private Context mContext;

    public ProductListAdapter(Context context, List<ProductModel> productList) {
        mContext = context;
        mProductsList = productList;
    }

    @Override
    public int getCount() {
        return mProductsList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView;

        if (convertView == null) {
            rootView = View.inflate(mContext, R.layout.product_list_items, null);
        } else {
            rootView = (View) convertView;
        }
        rootView.setTag(position);
        rootView.findViewById(R.id.add_to_cart).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_cart:
                int position = (Integer) view.getTag();
                makeAddToCartApiCall(position);
                break;
        }
    }

    private void makeAddToCartApiCall(int position) {
        ((ProductListActivity) mContext).makeAddToCartApiCall(mProductsList.get(position));
    }
}
