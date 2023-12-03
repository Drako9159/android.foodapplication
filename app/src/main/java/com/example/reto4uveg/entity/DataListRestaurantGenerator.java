package com.example.reto4uveg.entity;

import java.util.ArrayList;

public class DataListRestaurantGenerator {
    public static ArrayList<Restaurant> getData() {
        ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
        restaurantArrayList.add(new Restaurant(1, "La Fonda de Doña Mari"));
        restaurantArrayList.add(new Restaurant(2, "Alegres comidas"));
        restaurantArrayList.add(new Restaurant(3, "Antojitos Mexicanos"));
        restaurantArrayList.add(new Restaurant(4, "Restaurante y Bar"));
        restaurantArrayList.add(new Restaurant(5, "Comida Peruana"));
        restaurantArrayList.add(new Restaurant(6, "Bebidas Divertidas"));
        restaurantArrayList.add(new Restaurant(7, "Carnitas y más"));
        restaurantArrayList.add(new Restaurant(8, "Las Quesadillas de Juanita"));
        restaurantArrayList.add(new Restaurant(9, "Comida de Rancho"));
        restaurantArrayList.add(new Restaurant(10, "Cocinando con Tequila"));
        restaurantArrayList.add(new Restaurant(11, "El rincón enchilado"));
        restaurantArrayList.add(new Restaurant(12, "Fajitas aztecas"));
        restaurantArrayList.add(new Restaurant(13, "Puro sabor mexicano"));
        restaurantArrayList.add(new Restaurant(14, "México en tu casa"));
        restaurantArrayList.add(new Restaurant(15, "Nachos de Monterrey"));
        return restaurantArrayList;
    }
}
