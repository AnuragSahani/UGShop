package com.example.ugshop.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ugshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TopProductSliderAdapter extends PagerAdapter {

    private List<TopProductsSliderModel> topProductsSliderModelList;

    public TopProductSliderAdapter(List<TopProductsSliderModel> topProductsSliderModelList) {
        this.topProductsSliderModelList = topProductsSliderModelList;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.top_items_fregments,container,false);
        CircleImageView banner = view.findViewById(R.id.top_product_circle_image_slide);
        banner.setImageResource(topProductsSliderModelList.get(position).getBanner());
        container.addView(view,0);
        return  view;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return topProductsSliderModelList.size();
    }
}
