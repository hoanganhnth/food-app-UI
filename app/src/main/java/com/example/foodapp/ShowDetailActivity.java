package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ShowDetailActivity extends AppCompatActivity {

    int number = 1;
    private PopularDomain object;
    private TextView btnAddToCart;
    private TextView txtCost,txtDes,txtNumber,txtName;
    private ImageView btnMinus,btnPlus,imgFood;

    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();

    }

    private void getBundle() {
        object = (PopularDomain)getIntent().getSerializableExtra("object");
        int drawableResourceId =this.getResources().getIdentifier(object.getUrlImg(),"drawable", this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(imgFood);
        txtName.setText(object.getName());
        txtCost.setText("$" + object.getCost());
        txtDes.setText(object.getDescreption());
        txtNumber.setText(String.valueOf(number));
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number ++;
                txtNumber.setText(String.valueOf(number));

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number>1) {
                    number --;
                }
                txtNumber.setText(String.valueOf(number));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(number);
                managementCart.insertFood(object);
                Toast.makeText(ShowDetailActivity.this, "Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        btnAddToCart = findViewById(R.id.btnAddToCart);
        txtCost = findViewById(R.id.txtCost);
        txtDes = findViewById(R.id.txtDescription);
        txtNumber = findViewById(R.id.txtNumber);
        txtName = findViewById(R.id.txtName);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        imgFood = findViewById(R.id.imgFood);
    }
}