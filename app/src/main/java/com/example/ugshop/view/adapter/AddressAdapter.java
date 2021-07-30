package com.example.ugshop.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ugshop.R;
import com.example.ugshop.model.common.AddressModel;
import com.example.ugshop.util.Helper;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {
    private final List<AddressModel> mAddressList;
    private final Helper mHelper;

    public AddressAdapter(Activity context, List<AddressModel> mAddressList) {
        this.mAddressList = mAddressList;
        this.mHelper = new Helper(context);
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list,parent,false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        TextView textView = holder.getTextView();
        AddressModel address = mAddressList.get(position);

        textView.setText(address.getHouseNo()+","+address.getLandmark()+","+ address.getArea()+","+address.getCity()+","+address.getState()+","+address.getPin());
        textView.setTag(position+1);
    }

    @Override
    public int getItemCount() {
        return mAddressList.size();
    }

    static class AddressViewHolder extends  RecyclerView.ViewHolder{
        private final TextView mAddressView ;
        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            mAddressView = itemView.findViewById(R.id.addressText);

        }
        public TextView getTextView(){
            return mAddressView;
        }
    }

}
