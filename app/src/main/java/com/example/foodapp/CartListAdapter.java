package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ManagementCart managementCart;
    private ArrayList<PopularDomain> listFood;
    ChangeNumberItemListener changeNumberItemListener  ;

    public CartListAdapter(ArrayList<PopularDomain> listFood, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.managementCart = new ManagementCart(context);
        this.listFood = listFood;
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cart,parent,false);
        return new ViewHolder(infate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txtNameCart.setText(listFood.get(position).getName());
        holder.txtCost1.setText(String.valueOf(listFood.get(position).getCost()));
        holder.txtCostTotal.setText(String.valueOf(Math.round((listFood.get(position).getCost() * listFood.get(position).getNumberInCart()) *100)/100));
        holder.txtNumber.setText(String.valueOf(listFood.get(position).getNumberInCart()));

        int drawableResource = holder.itemView.getContext().getResources().getIdentifier(listFood.get(position).getUrlImg(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResource).into(holder.imgFoodCart);
        holder.btnMinusCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.minusNumberFood(listFood, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });
        holder.btnPlusCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.plusNumberFood(listFood, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCost1,txtCostTotal,txtNameCart,txtNumber;
        private ImageView btnMinusCart,btnPlusCart,imgFoodCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameCart = itemView.findViewById(R.id.txtNameCart);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtCost1 = itemView.findViewById(R.id.txtCost1);
            txtCostTotal = itemView.findViewById(R.id.txtCostTotal);
            btnMinusCart = itemView.findViewById(R.id.btnMinusCart);
            btnPlusCart = itemView.findViewById(R.id.btnPlusCart);
            imgFoodCart = itemView.findViewById(R.id.imgFoodCart);
        }
    }
}
