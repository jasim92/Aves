package com.example.aves;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aves.Models.AvesProfile;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>{

    List<AvesProfile> profileList;
    ListItemClickListner itemClickListner;

    public ProfileAdapter(List<AvesProfile> profileList, ListItemClickListner itemClickListner) {
        this.profileList = profileList;
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album,parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        AvesProfile avesProfile = profileList.get(position);

        holder.uName.setText(avesProfile.getUser().getName());
        holder.location.setText(avesProfile.getUser().getLocation());
        holder.bio.setText(avesProfile.getUser().getBio());

        Picasso.get().load(avesProfile.getUser().getProfileImage().getLarge()).into(holder.pImage);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder
{
    ImageView pImage;
    TextView uName, location, bio;

    LinearLayout itemBox;

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        pImage = itemView.findViewById(R.id.item_image);
        uName = itemView.findViewById(R.id.item_name);
        location = itemView.findViewById(R.id.item_location);
        bio = itemView.findViewById(R.id.item_bio);
        itemBox = itemView.findViewById(R.id.list_item_aves);

        itemBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AvesProfile avesProfile = profileList.get(getAdapterPosition());
                itemClickListner.onItemClick(avesProfile.getId());
            }
        });
        pImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AvesProfile avesProfile = profileList.get(getAdapterPosition());
                itemClickListner.onPhotoClick(avesProfile.getId());
            }
        });
    }

}
}
