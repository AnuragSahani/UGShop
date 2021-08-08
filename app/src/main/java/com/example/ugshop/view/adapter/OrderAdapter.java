package com.example.ugshop.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;
import com.example.ugshop.model.common.OrderModel;
import com.example.ugshop.model.common.ProductModel;
import com.example.ugshop.util.Helper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private final OrderModel orderModel;
    private final Helper mHelper;
    private final List<ProductModel> productModelList;
    public  OrderAdapter(Activity context, OrderModel orderModel){
        this.orderModel=orderModel;
        this.mHelper = new Helper(context);
        this.productModelList = orderModel.getProductModel();
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_items_layout,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {
        holder.mProductTitle.setText(orderModel.getProductModel().get(position).getName());
        Picasso.get().load(productModelList.get(position).getUrlModel().getBaseUrl()).into(holder.mProductImage);
        holder.mOrderDeliveredDate.setText("");
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder{

        ImageView mProductImage;
        TextView mProductTitle;
        TextView mOrderDeliveredDate;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            mProductTitle = itemView.findViewById(R.id.product_title);
            mProductImage = itemView.findViewById(R.id.product_image);
            mOrderDeliveredDate = itemView.findViewById(R.id.order_delivered_date);
        }
    }
}
