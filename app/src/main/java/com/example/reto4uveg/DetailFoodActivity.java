package com.example.reto4uveg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        ImageView ivBack = (ImageView) findViewById(R.id.ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener((b) -> onBackPressed());

        String foodName = getIntent().getStringExtra("food_name");
        /*
        String foodPrice = getIntent().getStringExtra("food_price");
        String foodDescription = getIntent().getStringExtra("food_description");*/

        /*

        TextView tvFoodName = (TextView) findViewById(R.id.tvFoodName);
        TextView tvFoodPrice = (TextView) findViewById(R.id.tvFoodPrice);
        TextView tvFoodDescription = (TextView) findViewById(R.id.tvFoodDescription);
        tvFoodName.setText(foodName);
        tvFoodPrice.setText(foodPrice);
        tvFoodDescription.setText(foodDescription);*/

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(foodName);
        tvTitle.setTextAppearance(R.style.Body);




    }
}