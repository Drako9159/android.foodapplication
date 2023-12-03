package com.example.reto4uveg.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto4uveg.R;
import com.example.reto4uveg.adapters.FoodAdapter;
import com.example.reto4uveg.entity.DataListFoodGenerator;
import com.example.reto4uveg.entity.Food;
import com.example.reto4uveg.entity.FoodType;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFood#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFood extends Fragment {

    private FoodAdapter foodAdapter;
    private RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabFood() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabFood.
     */
    // TODO: Rename and change types and number of parameters
    public static TabFood newInstance(String param1, String param2) {
        TabFood fragment = new TabFood();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_tab_food, container, false);*/
        View view = inflater.inflate(R.layout.fragment_tab_food, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        generateListFood();
        return view;
    }

    public void generateListFood() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        foodAdapter = new FoodAdapter(DataListFoodGenerator.getDataByFoodType(FoodType.FOOD_TYPE));
        recyclerView.setAdapter(foodAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.optionSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar comida...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Toast.makeText(getContext(), "Buscando...", Toast.LENGTH_SHORT).show();
                ArrayList<Food> foodArrayList = DataListFoodGenerator.getDataByFoodType(FoodType.FOOD_TYPE);
                boolean isFound = false;
                assert foodArrayList != null;
                for (Food food : foodArrayList) {
                    if (food.getName().toLowerCase().contains(query.toLowerCase())) {
                        isFound = true;
                        Toast.makeText(getContext(), "Encontrado " + query, Toast.LENGTH_SHORT).show();
                        ArrayList<Food> resTest = new ArrayList<>();
                        resTest.add(food);
                        foodAdapter = new FoodAdapter(resTest);
                        recyclerView.setAdapter(foodAdapter);
                    }
                }
                if (!isFound) {
                    Toast.makeText(getContext(), "No se encontró", Toast.LENGTH_SHORT).show();
                    generateListFood();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}