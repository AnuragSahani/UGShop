package com.example.ugshop.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.view.CartItemModel;
import com.example.ugshop.view.MyCartActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartItemViewholder> {

    private final List<ProductModel> mProductsList;
    private final MyCartActivity mCartActivity;

    public CartAdapter(MyCartActivity context, List<ProductModel> productModels) {
        mCartActivity = context;
        mProductsList = productModels;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mProductsList.size()) {
            return CartItemModel.TOTAL_AMOUNT;
        } else {
            return CartItemModel.CART_ITEM;
        }
    }

    @NonNull
    @Override
    public CartItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView;
        if (viewType == CartItemModel.TOTAL_AMOUNT) {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout, parent, false);
        } else {
            rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        }
        rootView.setTag(viewType);
        return new CartItemViewholder(rootView);
    }

    public long getTotalPrice() {
        return mTotalPrice;
    }

    public long getTotalOriginalPrice() {
        return mTotalOriginalPrice;
    }

    private long mTotalPrice = 0, mTotalOriginalPrice = 0;
    @Override
    public void onBindViewHolder(@NonNull CartItemViewholder holder, int position) {
        if (position == mProductsList.size()) {
            //BIND total amount data
            //totalItemsPrice, totalPrice, deliveryAmount, savedAmount
            holder.totalItemsPrice.setText("Rs. " + mTotalPrice);
            holder.totalPrice.setText("Rs. " + mTotalOriginalPrice);
            holder.deliveryAmount.setText("Rs. 0");
            holder.savedAmount.setText("You saved " + "Rs. " + (mTotalOriginalPrice-mTotalPrice) + " on this order");
        } else {
            final ProductModel product = mProductsList.get(position);
            holder.productName.setText(product.getName());
            int price = product.getPrice();
            holder.productPrice.setText("Rs. " + price);
            mTotalPrice += price;
            int originalPrice = (int) (product.getPrice() * 1.2);
            mTotalOriginalPrice += originalPrice;
            holder.originalPrice.setText("Rs. " + originalPrice);
            holder.quantity.setText(product.getStockQuantity()+"");
            Picasso.get()
                    .load(product.getUrlModel().getBaseUrl())
                    .into(holder.productImage);
            holder.removeItemLayout.setOnClickListener(view -> {
                callRemoveFromCartApi(product);
            });
        }
    }

    private void callRemoveFromCartApi(ProductModel product) {
        mCartActivity.callRemoveFromCart(product);
    }

    @Override
    public int getItemCount() {
        return mProductsList.size() + 1;
    }

    static class CartItemViewholder extends RecyclerView.ViewHolder {
        int mViewType = -1;
        TextView productName, productPrice, originalPrice, quantity, totalItemsPrice, totalPrice, deliveryAmount, savedAmount;
        ViewGroup removeItemLayout;
        ImageView productImage;

        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            mViewType = (Integer) itemView.getTag();
            if (mViewType == CartItemModel.CART_ITEM) {
                productName = itemView.findViewById(R.id.product_title);
                productPrice = itemView.findViewById(R.id.product_price);
                originalPrice = itemView.findViewById(R.id.cutted_price);
                quantity = itemView.findViewById(R.id.product_quantity);
                productImage = itemView.findViewById(R.id.cart_product_img);
                removeItemLayout = itemView.findViewById(R.id.remove_item_btn);
            } else if (mViewType == CartItemModel.TOTAL_AMOUNT) {
                totalItemsPrice = itemView.findViewById(R.id.total_items_price);
                deliveryAmount = itemView.findViewById(R.id.delivery_price);
                totalPrice = itemView.findViewById(R.id.total_price);
                savedAmount = itemView.findViewById(R.id.saved_amount);
            }
        }
    }
}
