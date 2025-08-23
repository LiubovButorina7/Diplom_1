package ru.praktikum.tests;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestClassBurgerGetReceiptWithParams {
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredientFirst;
    @Mock
    private Ingredient mockIngredientSecond;

    private final String bunName;
    private final float bunPrice;
    private final IngredientType firstIngredientType;
    private final String firstIngredientName;
    private final float firstIngredientPrice;
    private final IngredientType secondIngredientType;
    private final String secondIngredientName;
    private final float secondIngredientPrice;
    private final float burgerPrice;

    public TestClassBurgerGetReceiptWithParams(String bunName, float bunPrice, IngredientType firstIngredientType, String firstIngredientName, float firstIngredientPrice, IngredientType secondIngredientType, String secondIngredientName, float secondIngredientPrice, float burgerPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.firstIngredientType = firstIngredientType;
        this.firstIngredientName = firstIngredientName;
        this.firstIngredientPrice = firstIngredientPrice;
        this.secondIngredientType = secondIngredientType;
        this.secondIngredientName = secondIngredientName;
        this.secondIngredientPrice = secondIngredientPrice;
        this.burgerPrice = burgerPrice;

        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters(name = "Тестовые данные {index}: {0} {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] getOrderData() {
        return new Object[][] {
                {
                    "black bun", 100f,
                    IngredientType.SAUCE, "sour cream", 200f,
                    IngredientType.FILLING, "sausage", 300f,
                    700f
                },
                {
                    "red bun", 300f,
                    IngredientType.SAUCE, "chili sauce", 300f,
                    IngredientType.FILLING, "cutlet", 100f,
                    1000f
                },
        };
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFirst);
        burger.addIngredient(mockIngredientSecond);

        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIngredientFirst.getType()).thenReturn(firstIngredientType);
        Mockito.when(mockIngredientFirst.getName()).thenReturn(firstIngredientName);
        Mockito.when(mockIngredientFirst.getPrice()).thenReturn(firstIngredientPrice);
        Mockito.when(mockIngredientSecond.getType()).thenReturn(secondIngredientType);
        Mockito.when(mockIngredientSecond.getName()).thenReturn(secondIngredientName);
        Mockito.when(mockIngredientSecond.getPrice()).thenReturn(secondIngredientPrice);

        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
            bunName, firstIngredientType.toString().toLowerCase(), firstIngredientName,
                     secondIngredientType.toString().toLowerCase(), secondIngredientName,
            bunName, burgerPrice);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}