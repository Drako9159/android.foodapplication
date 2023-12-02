package com.example.reto4uveg.entity;

import java.util.ArrayList;

public class DataListGenerator {

    public ArrayList<Food> getData() {
        ArrayList<Food> foodArrayList;
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
        return foodArrayList;
    }

}
