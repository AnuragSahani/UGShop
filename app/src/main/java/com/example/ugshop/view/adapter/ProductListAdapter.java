package com.example.ugshop.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
        itemImg.setImageDrawable(getDrawable(productItem.getCatId(),productItem.getSubCatId(),position));

        /*if(position % 2 == 0) {
            itemImg.setImageResource(R.drawable.mens_shirt_item1_1);
        } else if (position % 3 == 0) {
            itemImg.setImageResource(R.drawable.mens_shirt_item2_1);
        } else {
            itemImg.setImageResource(R.drawable.mens_shirt_item3_1);
        }*/
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
    private static  int MenShirtCount= 0;
    private static  int MenTshirt= 0;
    private static  int MenTrouser=0;
    private static  int MenShorts= 0;

    private static  int WomenKurtiesCount= 0;
    private static  int WomenTops= 0;
    private static  int WomenTrouser=0;
    private static  int WomenTshirt= 0;

    private  static  int KidTrousersCount;
    private  static  int KidTshirtCount;
    private Drawable getDrawable(int cat_id, int sub_cat_id,int position){
        Resources res = mContext.getResources();
        switch (cat_id){
            //cat ID must be 1, 2 ,3
            case 1:
                switch (sub_cat_id){
                    case 1:
                        TypedArray icons = res.obtainTypedArray(R.array.men_shirt);
                        Drawable drawable = icons.getDrawable(MenShirtCount);
                        MenShirtCount++;
                        return drawable;
                    case 2:
                        icons = res.obtainTypedArray(R.array.men_t_shirt);
                        drawable = icons.getDrawable(MenTshirt);
                        MenTshirt++;
                        return drawable;
                    case 3:
                        icons = res.obtainTypedArray(R.array.men_trouser);
                        drawable = icons.getDrawable(MenTrouser);
                        MenTrouser++;
                        return drawable;
                    case 4:
                        icons = res.obtainTypedArray(R.array.men_shorts);
                        drawable = icons.getDrawable(MenShorts);
                        MenShorts++;
                        return drawable;
                }
                break;
            case 2:
                switch (sub_cat_id){
                    case 1:
                        TypedArray icons = res.obtainTypedArray(R.array.womens_kurties);
                        Drawable drawable = icons.getDrawable(WomenKurtiesCount);
                        WomenKurtiesCount++;
                        return drawable;
                    case 2:
                        icons = res.obtainTypedArray(R.array.womens_tops);
                        drawable = icons.getDrawable(WomenTops);
                        WomenTops++;
                        return drawable;
                    case 3:
                        icons = res.obtainTypedArray(R.array.womens_trousers);
                        drawable = icons.getDrawable(WomenTrouser);
                        WomenTrouser++;
                        return drawable;
                    case 4:
                        icons = res.obtainTypedArray(R.array.womens_tshirts);
                        drawable = icons.getDrawable(WomenTshirt);
                        WomenTshirt++;
                        return drawable;
                }
                break;

            case 3:
                switch (sub_cat_id){
                    case 1:
                        TypedArray icons = res.obtainTypedArray(R.array.kids_trousers);
                        Drawable drawable = icons.getDrawable(KidTrousersCount);
                        KidTrousersCount++;
                        return drawable;
                    case 2:
                        icons = res.obtainTypedArray(R.array.kids_tshirts);
                        drawable = icons.getDrawable(KidTshirtCount);
                        KidTshirtCount++;
                        return drawable;
                }
                break;
        }
        return null;
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
