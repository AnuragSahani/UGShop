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


        Resources res = mContext.getResources();
        menShirt = res.obtainTypedArray(R.array.men_shirt);
        menTShirt = res.obtainTypedArray(R.array.men_t_shirt);
        menTrouser = res.obtainTypedArray(R.array.men_trouser);
        menShorts = res.obtainTypedArray(R.array.men_shorts);

        womenKurtis = res.obtainTypedArray(R.array.womens_kurties);
        womenTops = res.obtainTypedArray(R.array.womens_tops);
        womenTrousers = res.obtainTypedArray(R.array.womens_trousers);
        womenTees = res.obtainTypedArray(R.array.womens_tshirts);

        kidTrousers = res.obtainTypedArray(R.array.kids_trousers);
        kidTShirts = res.obtainTypedArray(R.array.kids_tshirts);
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

        addToCart.setTag(productItem);

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

    private final TypedArray menShirt, menTShirt,menTrouser, menShorts,
    womenKurtis, womenTops, womenTrousers, womenTees,
    kidTrousers, kidTShirts;

    private Drawable getDrawable(int cat_id, int sub_cat_id,int position){
        Drawable drawable = null;
        switch (cat_id){
            //cat ID must be 1, 2 ,3
            case 1:
                switch (sub_cat_id){
                    case 1:
                        drawable = menShirt.getDrawable(MenShirtCount%menShirt.length());
                        MenShirtCount++;
                        break;
                    case 2:
                        drawable = menTShirt.getDrawable(MenTshirt%menTShirt.length());
                        MenTshirt++;
                        break;
                    case 3:
                        drawable = menTrouser.getDrawable(MenTrouser%menTrouser.length());
                        MenTrouser++;
                        break;
                    case 4:
                        drawable = menShorts.getDrawable(MenShorts%menShorts.length());
                        MenShorts++;
                        break;
                }
                break;
            case 2:
                switch (sub_cat_id){
                    case 1:
                        drawable = womenKurtis.getDrawable(WomenKurtiesCount%womenKurtis.length());
                        WomenKurtiesCount++;
                        break;
                    case 2:
                        drawable = womenTops.getDrawable(WomenTops%womenTops.length());
                        WomenTops++;
                        break;
                    case 3:
                        drawable = womenTrousers.getDrawable(WomenTrouser%womenTrousers.length());
                        WomenTrouser++;
                        break;
                    case 4:
                        drawable = womenTees.getDrawable(WomenTshirt%womenTees.length());
                        WomenTshirt++;
                        break;
                }
                break;

            case 3:
                switch (sub_cat_id){
                    case 1:
                        drawable = kidTrousers.getDrawable(KidTrousersCount%kidTrousers.length());
                        KidTrousersCount++;
                        break;
                    case 2:
                        drawable = kidTShirts.getDrawable(KidTshirtCount%kidTShirts.length());
                        KidTshirtCount++;
                        break;
                }
                break;
        }
        return drawable;
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
