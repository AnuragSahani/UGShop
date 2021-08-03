package com.example.ugshop.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.ugshop.R;
import com.example.ugshop.model.common.AddressModel;
import com.example.ugshop.model.request.AddAddressRequest;
import com.example.ugshop.model.response.AddAddressResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.viewmodel.AddressPageViewModel;

public class AddDeliveryAddressActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameV, mobile_numberV, alternate_mobileV, stateV,cityV, house_noV, areaV, landmarkV;
    private EditText pinV;
    private RadioButton addressHome,addressWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery_addresss);
        nameV = findViewById(R.id.first_name);
        mobile_numberV = findViewById(R.id.mobile_num);
        alternate_mobileV = findViewById(R.id.alternate_mobile_num);
        stateV = findViewById(R.id.state);
        cityV = findViewById(R.id.houseNo);
        house_noV = findViewById(R.id.houseNo);
        areaV = findViewById(R.id.area);
        landmarkV = findViewById(R.id.other);
        pinV = findViewById(R.id.Pin);
        addressHome = findViewById(R.id.Home);
        addressWork = findViewById(R.id.Work);
        findViewById(R.id.save_address).setOnClickListener(this);

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Home:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.Work:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    @Override
    public void onClick(View view) {
//        String name = nameV.getText().toString();
//        String mobileNumber = mobile_numberV.getText().toString();
//        String alterMobile = alternate_mobileV.getText().toString();
//        String state = stateV.getText().toString();
//        String city = cityV.getText().toString();
//        String houseNo = house_noV.getText().toString();
//        String area = areaV.getText().toString();
//        String landmark = landmarkV.getText().toString();
//        String typeOfAddress="";
//        if(addressHome.isSelected()){
//            typeOfAddress = "H";
//        }
//        else if(addressWork.isSelected()){
//            typeOfAddress = "W";
//        }

        if (view.getId() == R.id.save_address) {
            makeAddAddressApiCall();
        }

    }

    private void makeAddAddressApiCall() {
        String email ="anuragsahani0123@gmail.com";
        String name = nameV.getText().toString();
        String mobileNumber = mobile_numberV.getText().toString();
        String alterMobile = alternate_mobileV.getText().toString();
        String state = stateV.getText().toString();
        String city = cityV.getText().toString();
        String houseNo = house_noV.getText().toString();
        String area = areaV.getText().toString();
        String landmark = landmarkV.getText().toString();
        int pin = Integer.valueOf(pinV.getText().toString());
        String typeOfAddress="";
        if(addressHome.isSelected()){
            typeOfAddress = "H";
        }
        else if(addressWork.isSelected()){
            typeOfAddress = "W";
        }
        AddressModel address = new AddressModel();
        address.setPin(pin);
        address.setArea(area);
        address.setCity(city);
        address.setHouseNo(houseNo);
        address.setState(state);
        address.setTypeOfAddress(typeOfAddress);
        address.setLandmark(landmark);
        address.setEmail(email);
        AddAddressRequest addAddressRequest = new AddAddressRequest();
        addAddressRequest.setAddressModel(address);
        AddressPageViewModel addressPageViewModel = new ViewModelProvider(this).get(AddressPageViewModel.class);
        addressPageViewModel.addAddress(addAddressRequest).observe(this, new Observer<ApiResource<AddAddressResponse>>() {
            @Override
            public void onChanged(ApiResource<AddAddressResponse> addAddressResponseApiResource) {
                switch (addAddressResponseApiResource.getStatus()){
                case SUCCESS:
                //Save values to preference
                    Log.d("Mariya", "response : " + addAddressResponseApiResource.getData());
                    AddAddressResponse response = addAddressResponseApiResource.getData();
                    if (response.isSuccessfullyAddAddress()){
                        Intent intent = new Intent(getApplicationContext(), MainMyAccountActivity.class);
                        startActivity(intent);
                        new Helper((Activity) getApplicationContext()).showToast(R.string.address_added);
                        finish();
                    }
                    break;

                case ERROR:
                    new Helper(AddDeliveryAddressActivity.this).showToast(R.string.add_address_failed);
                    break;
                case LOADING:
//                        mProgressDialog.show();
                    break;
            }
            }
        });

    }


}