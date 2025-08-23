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
    private Ingredient mockIngredientCutlet;
    @Mock
    private Ingredient mockIngredientSauce;
    @Mock
    private Ingredient mockIngredientSausage;

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
    public void testGetPrice() throws Exception {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientCutlet);
        burger.addIngredient(mockIngredientSauce);
        burger.addIngredient(mockIngredientSausage);

        Mockito.when(mockBun.getPrice()).thenReturn(500f);
        Mockito.when(mockIngredientSauce.getPrice()).thenReturn(200f);
        Mockito.when(mockIngredientCutlet.getPrice()).thenReturn(400f);
        Mockito.when(mockIngredientSausage.getPrice()).thenReturn(300f);

        float expectedPrice = 1900;
        float delta = 0.001f;
        assertEquals(expectedPrice, burger.getPrice(), delta);
    }

}
