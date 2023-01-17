package com.example.aves;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ItemDetailActivity extends AppCompatActivity {

    private ImageView photo;
    private TextView bio;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        photo = findViewById(R.id.itemView_photo);
        bio = findViewById(R.id.itemView_bio);
        progressBar = findViewById(R.id.progress_photo);

        bio.setText(getIntent().getStringExtra("description"));
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