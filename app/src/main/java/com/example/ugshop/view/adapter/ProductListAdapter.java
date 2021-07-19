package com.example.ugshop.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        ProductModel productItem = mProductsList.get(position);
        ImageView itemImg = rootView.findViewById(R.id.item_img);
        if(position % 2 == 0) {
            itemImg.setImageResource(R.drawable.mens_shirt_item1_1);
        } else if (position % 3 == 0) {
            itemImg.setImageResource(R.drawable.mens_shirt_item2_1);
        } else {
            itemImg.setImageResource(R.drawable.mens_shirt_item3_1);
        }
        TextView productName = rootView.findViewById(R.id.brand_name_item);
        TextView productDescription = rootView.findViewById(R.id.brand_description_item);
        TextView productPrice = rootView.findViewById(R.id.product_price);
        TextView originalPrice = rootView.findViewById(R.id.cuttedPrice);
        Button addToCart = rootView.findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(this);

        productName.setText(productItem.getName());
        productDescription.setText(productItem.getDescription());
        productPrice.setText("Rs. " + productItem.getPrice());
        originalPrice.setText("Rs. " + (1.2 * productItem.getPrice()));

        rootView.setTag(productItem);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_to_cart:
                ProductModel productItem = (ProductModel) view.getTag();
                makeAddToCartApiCall(productItem);
                break;
        }
    }

    private void makeAddToCartApiCall(ProductModel product) {
        ((ProductListActivity) mContext).makeAddToCartApiCall(product);
    }
}
