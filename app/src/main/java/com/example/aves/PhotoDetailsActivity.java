package com.example.aves;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PhotoDetailsActivity extends AppCompatActivity {

    private TextView desc, username;
    private ImageView userImage, photo;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_details);
        desc = findViewById(R.id.photoDetail_des);
        userImage = findViewById(R.id.photoDetail_profile);
        username = findViewById(R.id.photoDetail_user);
        photo = findViewById(R.id.photoDetail_photo);
        progressBar = findViewById(R.id.progress_photo_details);

        desc.setText(getIntent().getStringExtra("description"));
        username.setText(getIntent().getStringExtra("username"));
        Picasso.get().load(getIntent().getStringExtra("userImage")).into(userImage);
        Picasso.get().load(getIntent().getStringExtra("image")).into(photo, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}