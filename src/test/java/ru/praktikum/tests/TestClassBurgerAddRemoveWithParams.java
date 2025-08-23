package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestClassBurgerAddRemoveWithParams {
    private Burger burger;

    private final IngredientType type;
    private final String name;
    private final float price;

    public TestClassBurgerAddRemoveWithParams(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Parameterized.Parameters(name = "Тестовые данные {index}: {0} {1} {2}")
    public static Object[][] getOrderData() {
        return new Object[][] {
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.FILLING, "sausage", 300f},
        };
    }

    @Test
    public void testAddIngredient() throws Exception {
        Ingredient ingredient = new Ingredient(type, name, price);

        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() throws Exception {
        Ingredient ingredient = new Ingredient(type, name, price);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

}
