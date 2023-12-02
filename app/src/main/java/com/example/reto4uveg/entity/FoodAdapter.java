package com.example.reto4uveg.entity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto4uveg.R;

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

        holder.setTextViewName(foodArrayList.get(position).getName(), foodArrayList.get(position).getPrice().toString()+"$");
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

        public void setTextViewName(String foodName, String foodPrice) {
            tvFoodName.setText(foodName);
            tvFoodPrice.setText(foodPrice);
        }
    }
}
