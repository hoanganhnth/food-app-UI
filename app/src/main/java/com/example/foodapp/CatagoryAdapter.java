package com.example.foodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.ViewHolder> {
    ArrayList<CatogoryDomain> catogoryDomains ;

    public CatagoryAdapter(ArrayList<CatogoryDomain> catogoryDomains) {
        this.catogoryDomains = catogoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_catagory,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.catagoryName.setText(catogoryDomains.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0:
                picUrl = "cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroud1));
                break;
            case 1:
                picUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroud2));
                break;
            case 2:
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroud3));
                break;
            case 3:
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroud4));
                break;
            case 4:
                picUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_backgroud5));
                break;
        }
        int drawableResourceId = holder.itemView.getContext().getResources().
                getIdentifier(picUrl,"drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.cateagoryImg);
    }

    @Override
    public int getItemCount() {
        return catogoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView catagoryName;
        ImageView cateagoryImg;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryName = itemView.findViewById(R.id.catagoryName);
            cateagoryImg = itemView.findViewById(R.id.catagoryImg);
            mainLayout = itemView.findViewById(R.id.mainLayoutCatagory);

        }
    }
}
