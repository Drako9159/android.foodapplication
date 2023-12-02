package com.example.reto4uveg;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.reto4uveg.entity.FoodAdapter;
import com.example.reto4uveg.tab.ViewPagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

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

        generateTabs();




    }

    /*
    public void generateListFood() {
        ArrayList<String> userArrayList;
        RecyclerView recyclerView;

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        userArrayList = new ArrayList<>();
        userArrayList.add("Juan");
        userArrayList.add("Mariana");
        FoodAdapter foodAdapter = new FoodAdapter(userArrayList);
        recyclerView.setAdapter(foodAdapter);

    }*/


    public void generateTabs() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        TabItem tabFood = (TabItem) findViewById(R.id.tabFood);
        TabItem tabDrink = (TabItem) findViewById(R.id.tabDrink);
        TabItem tabComplement = (TabItem) findViewById(R.id.tabComplements);



        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == (0 | 1 | 2)) {
                    viewPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}