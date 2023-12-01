package com.example.reto4uveg.entity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.reto4uveg.DetailRestaurantActivity;
import com.example.reto4uveg.R;

import java.util.ArrayList;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        super(context, 0, restaurants);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant restaurant = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);
        }

        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewName.setText(restaurant.getName());


        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LayoutInflater.from(getContext()).inflate(R.layout.activity_detail_restaurant, parent, false);

                Intent intent = new Intent(getContext(), DetailRestaurantActivity.class);
                intent.putExtra("restaurant_name", restaurant.getName());
                getContext().startActivity(intent);

                Toast.makeText(getContext(), restaurant.getName(), Toast.LENGTH_SHORT).show();
            }

        });
        return convertView;
        //return super.getView(position, convertView, parent);
    }
}
