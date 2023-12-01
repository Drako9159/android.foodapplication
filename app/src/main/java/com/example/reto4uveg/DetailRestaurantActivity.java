package com.example.reto4uveg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailRestaurantActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_restaurant);

        String restaurant = getIntent().getStringExtra("restaurant_name");
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(restaurant);
        tvTitle.setTextAppearance(R.style.Body);

        ImageView ivBack = (ImageView) findViewById(R.id.ivBack);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener((b) -> onBackPressed());



    }
}