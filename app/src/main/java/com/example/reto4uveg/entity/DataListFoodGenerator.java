package com.example.reto4uveg.entity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DataListFoodGenerator {
    public static ArrayList<Food> getData() {
        ArrayList<Food> foodArrayList = new ArrayList<>();
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
        foodArrayList.add(new Food(14, "Café Americano", 25.0, "400 ml, Un Delicioso Café Americano para empezar tus mañanas", FoodType.DRINK_TYPE));
        foodArrayList.add(new Food(15, "Nuggets de Pollo", 65.0, "2 Porción, Con nuestra salsa especial y aderesos no te quedes con las ganas", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(16, "Pizza Familiar", 135.0, "Comparte con tu familia nuestra deliciosa Pizza", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(17, "Hamburguesa", 35.0, "Ven y prueba nuestra deliciosa hamburguesa con triple milaneassa extra", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(18, "Huevos Fritos", 35.0, "Empieza tu día con un desyuno especial para continuar con energía", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(19, "Fruta de temporada", 10.0, "Alimentate sanamente con nuestra fruta de temporada", FoodType.FOOD_TYPE));
        foodArrayList.add(new Food(20, "Refrescos", 16.0, "Acompaña tus comidas con bebida de tu preferencia", FoodType.DRINK_TYPE));
        return foodArrayList;
    }

    public static ArrayList<Food> getDataByFoodType(FoodType foodType) {
        if (foodType.equals(FoodType.FOOD_TYPE)) {
            return new ArrayList<>(new DataListFoodGenerator().getData().stream()
                    .filter(e -> e.getFoodType() == FoodType.FOOD_TYPE)
                    .collect(Collectors.toList()));
        }
        if (foodType.equals(FoodType.DRINK_TYPE)) {
            return new ArrayList<>(new DataListFoodGenerator().getData().stream()
                    .filter(e -> e.getFoodType() == FoodType.DRINK_TYPE)
                    .collect(Collectors.toList()));
        }
        if (foodType.equals(FoodType.COMPLEMENT_TYPE)) {
            return new ArrayList<>(new DataListFoodGenerator().getData().stream()
                    .filter(e -> e.getFoodType() == FoodType.COMPLEMENT_TYPE)
                    .collect(Collectors.toList()));
        }
        return null;
    }

}
