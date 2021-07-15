package com.example.ugshop.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ugshop.R;
import com.example.ugshop.model.common.CategoryModel;
import com.example.ugshop.util.Helper;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private final List<CategoryModel> mCategoriesList;
    private final Helper mHelper;

    public CategoriesAdapter(Activity context, List<CategoryModel> categoriesList) {
        this.mCategoriesList = categoriesList;
        mHelper = new Helper(context);
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
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
//        holder.getCircleImageView().setImageResource(mHelper.getDrawableByCatId(mCategoriesList.get(position)));
    }

    @Override
    public int getItemCount() {
        return 3;//mCategoriesList.size();
    }

    static class CategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CircleImageView mCircleImageView;

        public CategoriesViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            mCircleImageView = (CircleImageView) view.findViewById(R.id.category);
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
