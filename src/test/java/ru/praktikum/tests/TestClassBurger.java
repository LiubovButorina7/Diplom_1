package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestClassBurger {
    private Burger burger;

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredientFirst;
    @Mock
    private Ingredient mockIngredientSecond;
    @Mock
    private Ingredient mockIngredientThird;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() throws Exception {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() throws Exception {
        burger.addIngredient(mockIngredientFirst);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() throws Exception {
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testGetPrice() throws Exception {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);
        burger.addIngredient(mockIngredientThird);

        Mockito.when(mockBun.getPrice()).thenReturn(500f);
        Mockito.when(mockIngredientFirst.getPrice()).thenReturn(200f);
        Mockito.when(mockIngredientSecond.getPrice()).thenReturn(400f);
        Mockito.when(mockIngredientThird.getPrice()).thenReturn(300f);

        float expectedPrice = 1900;
        float delta = 0.001f;

        assertEquals(expectedPrice, burger.getPrice(), delta);
    }

}
