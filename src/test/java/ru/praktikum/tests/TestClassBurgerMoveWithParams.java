package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestClassBurgerMoveWithParams {
    private Burger burger;

    @Mock
    private Ingredient mockIngredientFirst;
    @Mock
    private Ingredient mockIngredientSecond;
    @Mock
    private Ingredient mockIngredientThird;

    private final int oldIndex;
    private final int newIndex;

    public TestClassBurgerMoveWithParams(int oldIndex, int newIndex) {
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;

        MockitoAnnotations.initMocks(this);
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
    public void testMoveIngredient() throws Exception {
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);
        burger.addIngredient(mockIngredientThird);

        Ingredient movedIngredient = burger.ingredients.get(oldIndex);
        burger.moveIngredient(oldIndex, newIndex);

        assertEquals(movedIngredient, burger.ingredients.get(newIndex));
    }
}