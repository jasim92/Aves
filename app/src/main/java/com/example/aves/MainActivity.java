package com.example.aves;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.aves.Adapters.ProfileAdapter;
import com.example.aves.ApiServices.ApiController;
import com.example.aves.Listners.ListItemClickListner;
import com.example.aves.Models.AvesProfile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ListItemClickListner {

    private RecyclerView profileRc;

    private ProfileAdapter profileAdapter;

    private List<AvesProfile> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileRc = findViewById(R.id.profile_rc);
        profileRc.setHasFixedSize(true);
        profileRc.setLayoutManager(new LinearLayoutManager(this));

        profileList = new ArrayList<>();

        getNetworkData();


    }

    private void getNetworkData()
    {
        Call<List<AvesProfile>> call = ApiController.getInstance().getApis().getProfile();
        call.enqueue(new Callback<List<AvesProfile>>() {
            @Override
            public void onResponse(Call<List<AvesProfile>> call, Response<List<AvesProfile>> response) {

                if (response.isSuccessful())
                {
                    profileList = response.body();
                    for (AvesProfile av:profileList) {

                        Log.e("data", av.getUser().getName());

                    }
                    profileAdapter = new ProfileAdapter(profileList, MainActivity.this);
                    profileRc.setAdapter(profileAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<AvesProfile>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(String id) {

        Log.e("index", id);

        for (AvesProfile av: profileList) {
            if (av.getId()==id)
            {
                String description = av.getAlt_description();
                String image = av.getUrls().getRegular();
                Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
                intent.putExtra("description", description);
                intent.putExtra("image", image);
                startActivity(intent);
            }

        }

    }

    @Override
    public void onPhotoClick(String id) {
        for (AvesProfile av: profileList) {
            if (av.getId()==id)
            {
                String description = av.getAlt_description();
                String username = av.getUser().getName();
                String image = av.getUrls().getRegular();
                String userImage = av.getUser().getProfileImage().getLarge();
                Intent intent = new Intent(MainActivity.this, PhotoDetailsActivity.class);
                intent.putExtra("description", description);
                intent.putExtra("image", image);
                intent.putExtra("userImage", userImage);
                intent.putExtra("username", username);
                startActivity(intent);
            }

        }

    }
}