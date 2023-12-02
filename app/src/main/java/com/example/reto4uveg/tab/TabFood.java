package com.example.reto4uveg.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto4uveg.R;
import com.example.reto4uveg.entity.Food;
import com.example.reto4uveg.entity.FoodAdapter;
import com.example.reto4uveg.entity.FoodType;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFood#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFood extends Fragment {

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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*return inflater.inflate(R.layout.fragment_tab_food, container, false);*/
        View view = inflater.inflate(R.layout.fragment_tab_food, container, false);


        ArrayList<Food> foodArrayList;
        RecyclerView recyclerView;

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        foodArrayList = new ArrayList<>();

        foodArrayList.add(new Food(1, "Carnitas Michoacán", 129.9, "1Kg, Excelentes carnitas al estilo michoacán", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(2, "Tacos dorados", 12.9, "1 Porción, Tacos preparados con ensalada", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(3, "Sopes", 15.5, "1 Porción, Disfruta de nuestros ricos sopes de pollo", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(4, "Margarita", 25.0, "1 Porción, Tenemos deliciosas bebidas con citricas y alcohol", FoodType.DRINK_TYPE));
        foodArrayList.add(new Food(5, "Tortas", 15.0, "1 Porción, Se lleva una torta completa con milanesa", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(6, "Cerveza Lata", 22.0, "355 ml", FoodType.DRINK_TYPE));
        foodArrayList.add(new Food(7, "Cerveza Botella", 25.0, "355 ml", FoodType.DRINK_TYPE));
        foodArrayList.add(new Food(8, "Pastel de Fresa", 55.0, "1 Porción, Prueba nuestro delicioso pastel sabor fresa", FoodType.COMPLEMENT_TYPE));
        foodArrayList.add(new Food(9, "Pastel de Chocolate", 55.0, "1 Porción, Prueba nuestro delicioso pastel sabor Chocolate", FoodType.COMPLEMENT_TYPE));
        foodArrayList.add(new Food(10, "Pastel de Mango", 55.0, "1 Porción, Prueba nuestro delicioso pastel sabor Mango", FoodType.COMPLEMENT_TYPE));
        foodArrayList.add(new Food(11, "Helado Napolitano", 25.0, "230 ml, Prueba nuestro sabroso helado multisabor", FoodType.COMPLEMENT_TYPE));
        foodArrayList.add(new Food(12, "Helado de Galleta", 25.0, "230 ml, Prueba nuestro sabrodo helado con galleta Oreo", FoodType.COMPLEMENT_TYPE));
        foodArrayList.add(new Food(13, "Malteada de Chocolate", 35.0, "350 ml, Nuestra malteada de chocolate te refrescará el día", FoodType.DRINK_TYPE));


        FoodAdapter foodAdapter = new FoodAdapter(foodArrayList);
        recyclerView.setAdapter(foodAdapter);

        return view;
    }
}