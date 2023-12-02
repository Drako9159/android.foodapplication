package com.example.reto4uveg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        String foodName = getIntent().getStringExtra("food_name");
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(foodName);

        tvTitle.setTextAppearance(R.style.Body);

        ImageView ivBack = (ImageView) findViewById(R.id.ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener((b) -> onBackPressed());


    }
}