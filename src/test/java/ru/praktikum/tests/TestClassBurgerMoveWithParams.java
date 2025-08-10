package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestClassBurgerMoveWithParams {
    private Burger burger;

    private final int oldIndex;
    private final int newIndex;

    public TestClassBurgerMoveWithParams(int oldIndex, int newIndex) {
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters(name = "Тестовые данные {index}: {0} {1}")
    public static Object[][] getOrderData() {
        return new Object[][] {
                {1, 0},
                {2, 1},
                {0, 2},
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testRemoveIngredient() throws Exception {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);
        Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Ingredient movedIngredient = burger.ingredients.get(oldIndex);
        burger.moveIngredient(oldIndex, newIndex);

        assertEquals(movedIngredient, burger.ingredients.get(newIndex));
        assertNotEquals(movedIngredient, burger.ingredients.get(oldIndex));
    }
}