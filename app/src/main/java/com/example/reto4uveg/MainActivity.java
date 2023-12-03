package com.example.reto4uveg;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reto4uveg.adapters.RestaurantAdapter;
import com.example.reto4uveg.entity.DataListRestaurantGenerator;
import com.example.reto4uveg.entity.Restaurant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se establece el toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        // genera el listado de restaurantes
        generateListRestaurants();

    }

    public void generateListRestaurants() {
        listView = (ListView) findViewById(R.id.listView);
        ArrayList<Restaurant> restaurantArrayList = new DataListRestaurantGenerator().getData();
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(this, restaurantArrayList);
        listView.setAdapter(restaurantAdapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Restaurant selectedRestaurant = (Restaurant) listView.getItemAtPosition(info.position);

        if (item.getItemId() == R.id.itemFood) {
            Intent intent = new Intent(this, DetailRestaurantActivity.class);
            intent.putExtra("restaurant_name", selectedRestaurant.getName());
            intent.putExtra("food_type", "food_frame");
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.itemDrink) {
            Intent intent = new Intent(this, DetailRestaurantActivity.class);
            intent.putExtra("restaurant_name", selectedRestaurant.getName());
            intent.putExtra("food_type", "drink_frame");
            startActivity(intent);

            return true;
        } else if (item.getItemId() == R.id.itemComplement) {
            Intent intent = new Intent(this, DetailRestaurantActivity.class);
            intent.putExtra("restaurant_name", selectedRestaurant.getName());
            intent.putExtra("food_type", "complement_frame");
            startActivity(intent);

            return true;
        } else {
            return super.onContextItemSelected(item);
        }
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
        return true;
    }




}