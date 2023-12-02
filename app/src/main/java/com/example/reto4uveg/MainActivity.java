package com.example.reto4uveg;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.reto4uveg.entity.Restaurant;
import com.example.reto4uveg.adapters.RestaurantAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

        //TextView textView = (TextView) findViewById(R.id.tvRestaurantName);
        //registerForContextMenu(textView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.optionSearch) {
            Toast.makeText(this, "Tiene comida", Toast.LENGTH_SHORT).show();
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