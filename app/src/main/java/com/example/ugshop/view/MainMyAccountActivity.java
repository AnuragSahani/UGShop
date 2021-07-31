package com.example.ugshop.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ugshop.R;
import com.example.ugshop.model.common.AddressModel;
import com.example.ugshop.model.request.FetchAddressRequest;
import com.example.ugshop.model.response.FetchAddressResponse;
import com.example.ugshop.network.ApiResource;
import com.example.ugshop.util.Helper;
import com.example.ugshop.view.adapter.AddressAdapter;
import com.example.ugshop.viewmodel.AddressPageViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainMyAccountActivity extends AppCompatActivity implements View.OnClickListener {

    Button signOut;
    GoogleSignInClient mGoogleSignInClient;
    TextView name,email,cellNo, addresses;
    CircleImageView pic;
    private Object CircleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_account);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        cellNo = findViewById(R.id.cellNo);
        CircleImageView = findViewById(R.id.pic);
        addresses = findViewById(R.id.addressText);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        Button Signout = findViewById(R.id.SignOut);

        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                finish();
            }
        });
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

//            This Google Data we Use..............................................................
        if (acct != null) {
            String personName = acct.getDisplayName();
//            String personGivenName = acct.getGivenName();
//            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            name.setText(personName);
            email.setText(personEmail);
            Glide.with(this).load(String.valueOf(personPhoto)).into(pic);
        }

        makeAddressApiCall();
        findViewById(R.id.add_address).setOnClickListener(this);
    }

    private void makeAddressApiCall() {
        AddressPageViewModel addressPageViewModel = new ViewModelProvider(this).get(AddressPageViewModel.class);
        String email = "nt840071@gmail.com";
//        FetchAddressRequest addressRequest = new FetchAddressRequest();
//        addressRequest.setEmail(email);
        addressPageViewModel.fetchAddresses(email).observe(this, new Observer<ApiResource<FetchAddressResponse>>() {
            @Override
            public void onChanged(ApiResource<FetchAddressResponse> fetchAddressResponseApiResource) {
                switch (fetchAddressResponseApiResource.getStatus()){
                    case SUCCESS:
                        FetchAddressResponse response = fetchAddressResponseApiResource.getData();
                        if(response.getFetchResList().isEmpty() || response == null || response.getFetchResList() == null){
                            new Helper().showToast(R.string.suggestion_to_addAddress);
                            return;
                        }else
                        inflateData(response.getFetchResList());
                        break;
                    case LOADING:
                        break;
                    case ERROR:
                        new Helper(MainMyAccountActivity.this).showToast(R.string.something_error);
                        break;
                }
            }
        });
    }

    private void inflateData(List<AddressModel> addressList) {
        setUpAddressRecyclerView(addressList);
    }

    private void setUpAddressRecyclerView(List<AddressModel> listAddress){
        RecyclerView recyclerView = findViewById(R.id.address_recycler);
        AddressAdapter addressAdapter = new AddressAdapter(this,listAddress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(addressAdapter);
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finishAffinity();
                        Toast toast = Toast.makeText(getApplicationContext(),"SignOutSuccess",Toast.LENGTH_LONG);
                        toast.show();

                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_address:
                Intent addAddressIntent = new Intent(this, AddDeliveryAddressActivity.class);
                startActivity(addAddressIntent);
                break;
        }
    }
}