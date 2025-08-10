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
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;
    @Mock
    private Ingredient mockIngredient3;

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
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.addIngredient(mockIngredient3);

        Mockito.when(mockBun.getPrice()).thenReturn(500f);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(200f);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(400f);
        Mockito.when(mockIngredient3.getPrice()).thenReturn(300f);

        float expectedPrice = 1900;
        float delta = 0.001f;
        assertEquals(expectedPrice, burger.getPrice(), delta);
    }

}
