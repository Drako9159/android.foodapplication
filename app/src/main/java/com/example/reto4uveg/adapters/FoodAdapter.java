package com.example.reto4uveg.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto4uveg.DetailFoodActivity;
import com.example.reto4uveg.R;
import com.example.reto4uveg.entity.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    ArrayList<Food> foodArrayList;

    public FoodAdapter(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_item, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        holder.setViewElements(new Food(
                foodArrayList.get(position).get_id(),
                foodArrayList.get(position).getName(),
                foodArrayList.get(position).getPrice(),
                foodArrayList.get(position).getDescription(),
                foodArrayList.get(position).getFoodType()
        ));
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFoodName;
        TextView tvFoodPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFoodName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvFoodPrice = (TextView) itemView.findViewById(R.id.tvFoodPrice);
        }

        public void setViewElements(Food food) {
            tvFoodName.setText(food.getName());
            tvFoodPrice.setText(food.getPrice().toString() + "$");
            tvFoodName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailFoodActivity.class);
                    intent.putExtra("food_name", food.getName());
                    intent.putExtra("food_description", food.getDescription());
                    intent.putExtra("food_price", "Precio: " + food.getPrice().toString() + "$");
                    itemView.getContext().startActivity(intent);
                    Toast.makeText(itemView.getContext(), food.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
