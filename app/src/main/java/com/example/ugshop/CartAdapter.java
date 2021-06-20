//package com.example.ugshop;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Switch;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class CartAdapter extends RecyclerView.Adapter {
//
//    private List<Cart_item_model> cart_item_modelList;
//
//    public CartAdapter(List<Cart_item_model> cart_item_modelList) {
//        this.cart_item_modelList = cart_item_modelList;
//    }
//cart_item_modelList
//    @Override
//    public int getItemViewType(int position) {
//        switch (cart_item_modelList.get(position).getType()){
//            case 0:
//                return Cart_item_model.CART_ITEM;
//            case 1:
//                return Cart_item_model.TOTAL_AMOUNT;
//            default:
//                return -1;
//        }
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        switch (viewType){
//            case Cart_item_model.CART_ITEM:
//             //   View view = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.cart_item_layout,ViewGroup,false);
//            case Cart_item_model.TOTAL_AMOUNT:
//            default:
//                return  null;
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    class cartItemViewholder extends  RecyclerView.ViewHolder{
//
//        public cartItemViewholder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//
//    class cartTotalAmountViewHolder extends  RecyclerView.ViewHolder{
//
//        public cartTotalAmountViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//}
