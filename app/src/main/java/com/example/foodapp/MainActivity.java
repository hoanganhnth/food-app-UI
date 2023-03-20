package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList;
private RecyclerView recyclerViewPopularList;
private FloatingActionButton btnCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });


    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.recyclerViewPopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PopularDomain> popularDomains = new ArrayList<>();
        popularDomains.add(new PopularDomain("Pepperoni pizza","pizza1","Pepperoni or pepperoni is a variety of salami of American origin made from a cured mixture of pork and beef seasoned with paprika or another chili pepper ",9.76));
        popularDomains.add(new PopularDomain("Cheese Burger","burger", "A cheeseburger is a hamburger topped with cheese. Traditionally, the slice of cheese is placed on top of the meat patty. The cheese is usually added to the cooking hamburger patty shortly before serving, which allows the cheese to melt. Cheeseburgers can include variations in structure, ingredients and composition.",8.79));
        popularDomains.add(new PopularDomain("Vegetable Pizza","pizza3","Green bell pepper, red onion, mushrooms, tomato, and olives are the classic veggie pizza toppings. But it's your pizza, and you can swap if you want to. Use whatever's in season and can be enjoyed raw or requires a short cooking time. (Or, pre-roast denser veggies like butternut squash.)",8.5));

        adapter2 = new PopularAdapter(popularDomains);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerViewCatagory);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CatogoryDomain> catogoryDomains = new ArrayList<>();
        catogoryDomains.add(new CatogoryDomain("Pizza","cat_1"));
        catogoryDomains.add(new CatogoryDomain("Burger","cat_2"));
        catogoryDomains.add(new CatogoryDomain("Hotdog","cat_3"));
        catogoryDomains.add(new CatogoryDomain("Drink","cat_4"));
        catogoryDomains.add(new CatogoryDomain("Donut","cat_5"));

        adapter = new CatagoryAdapter(catogoryDomains);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}