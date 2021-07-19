package com.example.ugshop.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class TopBrandsRecyclerAdapter extends RecyclerView.Adapter<TopBrandsRecyclerAdapter.TopBrandsViewHolder> {

    private final int TOP_BRANDS_CNT = 4;

    public TopBrandsRecyclerAdapter(Activity context) {
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public TopBrandsRecyclerAdapter.TopBrandsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_items_fregments, parent, false);
        return new TopBrandsRecyclerAdapter.TopBrandsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopBrandsRecyclerAdapter.TopBrandsViewHolder holder, int position) {
//        holder.getCircleImageView().setImageResource(mHelper.getDrawableByCatId(mCategoriesList.get(position)));


            switch (position){
                case 0: holder.getCircleImageView().setImageResource(R.drawable.mens_shirt_item4_1);
                    holder.mProductName.setText("Men Shirt");
                    holder.mDiscountTv.setText("Flat 20% Off");
                    break;
                case 1: holder.getCircleImageView().setImageResource(R.drawable.womens_kurties_item1_2);
                    holder.mProductName.setText("Women Kurtie");
                    holder.mDiscountTv.setText("Flat 35% Off");
                break;
                case 3: holder.getCircleImageView().setImageResource(R.drawable.womens_tops_item2_2);
                    holder.mProductName.setText("Women Tops");
                    holder.mDiscountTv.setText("Flat 25% Off");
                break;
            }
    }

    @Override
    public int getItemCount() {
        return TOP_BRANDS_CNT;
    }

    static class TopBrandsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         final CircleImageView mCircleImageView;
         final TextView mProductName, mDiscountTv;

        public TopBrandsViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            mCircleImageView = (CircleImageView) view.findViewById(R.id.top_product_circle_image_slide);
            mProductName = (TextView) view.findViewById(R.id.product_name_tv);
            mDiscountTv = (TextView) view.findViewById(R.id.discount_tv);
            mCircleImageView.setOnClickListener(this);
        }

        public CircleImageView getCircleImageView() {
            return mCircleImageView;
        }

        @Override
        public void onClick(View view) {
            goToProductsPage();
        }

        private void goToProductsPage() {
        }
    }
}
