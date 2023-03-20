package com.example.foodapp;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String name;
    private String urlImg;
    private String descreption;
    private double cost;
    private int numberInCart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public PopularDomain(String name, String urlImg, String descreption, double cost) {
        this.name = name;
        this.urlImg = urlImg;
        this.descreption = descreption;
        this.cost = cost;
    }
}
