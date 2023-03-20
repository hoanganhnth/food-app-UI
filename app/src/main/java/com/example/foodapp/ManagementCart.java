package com.example.foodapp;

import android.content.Context;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }
    public void insertFood(PopularDomain item) {
        ArrayList<PopularDomain> popularDomains=getListCart();
        boolean existAlready = false;
        int n=0;
        for (int i = 0; i < popularDomains.size();i++) {
            if (popularDomains.get(i).getName().equals(item.getName())) {
                existAlready = true;
                n= i;
                break;
            }
        }

        if (existAlready) {
            popularDomains.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            popularDomains.add(item);
        }
        tinyDB.putListObject("CartList",popularDomains);
    }

    public ArrayList<PopularDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<PopularDomain>listFood,int posision,ChangeNumberItemListener changeNumberItemListener) {
        listFood.get(posision).setNumberInCart(listFood.get(posision).getNumberInCart()+1);
        tinyDB.putListObject("CartList",listFood);
        changeNumberItemListener.changed();
    }

    public void minusNumberFood(ArrayList<PopularDomain>listFood,int posision,ChangeNumberItemListener changeNumberItemListener) {
        if (listFood.get(posision).getNumberInCart() == 1) {
            listFood.remove(posision);
        } else {
            listFood.get(posision).setNumberInCart(listFood.get(posision).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList",listFood);
        changeNumberItemListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<PopularDomain> listFood = getListCart();
        double fee = 0;
        for (PopularDomain f : listFood) {
            fee += f.getCost() * f.getNumberInCart() ;
        }
        return fee;
    }
}
