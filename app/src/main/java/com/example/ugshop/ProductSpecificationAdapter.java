package com.example.ugshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductSpecificationAdapter extends RecyclerView.Adapter<ProductSpecificationAdapter.ViewHolder> {

        private List<ProductSpecificationModel> productSpecificationModelList;

    public ProductSpecificationAdapter(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }

    @NonNull
    @NotNull
    @Override
    public ProductSpecificationAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        //TODO: here error in getContext and viewGroup, and please remove the return statement in this method
 //       View view = LayoutInflater.from(ViewGroup.getContext()).Inflate(R.layout.product_specification_item_layout,ViewGroup,false);
 //       return new ViewHolder(view);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductSpecificationAdapter.ViewHolder holder, int position) {

        String featureTitle = productSpecificationModelList.get(position).getFeatureName();
        String featureDetail = productSpecificationModelList.get(position).getFeatureValue();
      //TODO: Here error in viewHolder;

//       viewHolder.setFeature(featureTitle,featureDetail);
    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            featureName = itemView.findViewById(R.id.feature_name);
            featureValue = itemView.findViewById(R.id.feature_value);
        }
        private void setFeatures(String featureTitle,String featureDetail){
            featureName.setText(featureTitle);
            featureValue.setText(featureDetail);
        }
    }
}
