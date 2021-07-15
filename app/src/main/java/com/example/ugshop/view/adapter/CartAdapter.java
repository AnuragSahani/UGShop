package com.example.ugshop.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;
import com.example.ugshop.view.CartItemModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartItemViewholder> {

    private final List<CartItemModel> cart_item_modelList;

    public CartAdapter(List<CartItemModel> cart_item_modelList) {
        this.cart_item_modelList = cart_item_modelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cart_item_modelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public CartItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CartItemModel.TOTAL_AMOUNT) {
            View totalAmountView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout, parent, false);
            return new CartItemViewholder(totalAmountView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        return new CartItemViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cart_item_modelList.size() + 1;
    }

    static class CartItemViewholder extends RecyclerView.ViewHolder {
        int mViewType = -1;

        CartItemViewholder(int viewType, View itemView) {
            this(itemView);
            mViewType = viewType;
        }

        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            if (mViewType == CartItemModel.CART_ITEM) {

            } else if (mViewType == CartItemModel.TOTAL_AMOUNT) {

            }
        }
    }

    static class CartTotalAmountViewHolder extends RecyclerView.ViewHolder {

        public CartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
