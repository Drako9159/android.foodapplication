package com.example.reto4uveg.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reto4uveg.R;
import com.example.reto4uveg.entity.DataListGenerator;
import com.example.reto4uveg.entity.Food;
import com.example.reto4uveg.entity.FoodAdapter;
import com.example.reto4uveg.entity.FoodType;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabDrink#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabDrink extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabDrink() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabDrink.
     */
    // TODO: Rename and change types and number of parameters
    public static TabDrink newInstance(String param1, String param2) {
        TabDrink fragment = new TabDrink();
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

        RecyclerView recyclerView;

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));


        ArrayList<Food> arrayListFood = new ArrayList<>(new DataListGenerator().getData().stream()
                .filter(e -> e.getFoodType() == FoodType.DRINK_TYPE)
                .collect(Collectors.toList()));


        FoodAdapter foodAdapter = new FoodAdapter(arrayListFood);
        recyclerView.setAdapter(foodAdapter);

        return view;
    }
}