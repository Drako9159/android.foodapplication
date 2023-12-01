package com.example.reto4uveg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.MutableLiveData;

import com.example.reto4uveg.entity.Restaurant;
import com.example.reto4uveg.entity.RestaurantAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //generateTabs();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        generateListRestaurants();
    }

    public void generateListRestaurants() {
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(this, restaurantArrayList);


        restaurantAdapter.add(new Restaurant(1, "La Fonda de Doña Mari"));
        restaurantAdapter.add(new Restaurant(2, "Alegres comidas"));
        restaurantAdapter.add(new Restaurant(3, "Antojitos Mexicanos"));
        restaurantAdapter.add(new Restaurant(4, "Restaurante y Bar"));
        restaurantAdapter.add(new Restaurant(5, "Comida Peruana"));
        restaurantAdapter.add(new Restaurant(6, "Bebidas Divertidas"));
        restaurantAdapter.add(new Restaurant(7, "Carnitas y más"));
        restaurantAdapter.add(new Restaurant(8, "Las Quesadillas de Juanita"));
        restaurantAdapter.add(new Restaurant(9, "Comida de Rancho"));
        restaurantAdapter.add(new Restaurant(10, "Cocinando con Tequila"));
        restaurantAdapter.add(new Restaurant(11, "El rincón enchilado"));
        restaurantAdapter.add(new Restaurant(12, "Fajitas aztecas"));
        restaurantAdapter.add(new Restaurant(13, "Puro sabor mexicano"));
        restaurantAdapter.add(new Restaurant(14, "México en tu casa"));
        restaurantAdapter.add(new Restaurant(15, "Nachos de Monterrey"));

        listView.setAdapter(restaurantAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.optionSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "Buscando...", Toast.LENGTH_SHORT).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        /*View searchViewLayout= LayoutInflater.from(this).inflate(R.layout.search_view_layout, null);
        androidx.appcompat.widget.SearchView searchView1 = searchViewLayout.findViewById(R.id.customSearchView);
        ViewGroup rootView = findViewById(android.R.id.content);
        rootView.addView(searchViewLayout);*/






        return true;
    }
/*
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
                toolbar.setTitle(tab.getText());
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
    }*/

    public void refreshToolbar() {
        MutableLiveData<String> mText;
        mText = new MutableLiveData<>();
        mText.setValue("This new title");
    }


}