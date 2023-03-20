package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private TextView txtItemTotal,txtDS,txtTax,txtTotal;
    private TextView btnCheckout;

    private  ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cart_list);

        initView();
        initList();

        caculateCart();
        BottomNavigation();

    }

    private void BottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.btnCart);
        LinearLayout btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter( managementCart.getListCart(),this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                caculateCart();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.rvMyCart);
        managementCart = new ManagementCart(this);
        txtItemTotal = findViewById(R.id.txtItemsTotal);
        txtDS = findViewById(R.id.txtDeliveryService);
        txtTax = findViewById(R.id.txtTax);
        txtTotal = findViewById(R.id.txtTotal);
        btnCheckout = findViewById(R.id.btnCheckout);

    }

    private void caculateCart() {
        double tax =0.02;
        double delivery =10;

        txtTax.setText("$" + String.valueOf(Math.round((managementCart.getTotalFee() * tax)*100)/100));
        txtItemTotal.setText("$" + String.valueOf(Math.round((managementCart.getTotalFee())*100)/100));
        txtTotal.setText("$" + String.valueOf(Math.round((managementCart.getTotalFee()*(1 + tax) + delivery )*100)/100));
        txtDS.setText("$" + String.valueOf(delivery));
    }
}