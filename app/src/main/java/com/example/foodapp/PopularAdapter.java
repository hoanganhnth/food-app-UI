package com.example.foodapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private ArrayList<PopularDomain> popularDomains;
    public PopularAdapter(ArrayList<PopularDomain> popularDomains) {
        this.popularDomains = popularDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.popularName.setText(popularDomains.get(position).getName());
        holder.popularCost.setText(String.valueOf(popularDomains.get(position).getCost()));
        int drawableResourceId = holder.itemView.getContext().getResources().
                getIdentifier(popularDomains.get(position).getUrlImg(),"drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.popularImg);
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),ShowDetailActivity.class);
                intent.putExtra("object",popularDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return popularDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView popularName;
         ImageView popularImg;
         TextView popularCost;
         private TextView btnAdd;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popularName = itemView.findViewById(R.id.popularName);
            popularImg = itemView.findViewById(R.id.popularImg);
            mainLayout = itemView.findViewById(R.id.mainLayoutPopular);
            popularCost = itemView.findViewById(R.id.popularCost);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }

    }
}
