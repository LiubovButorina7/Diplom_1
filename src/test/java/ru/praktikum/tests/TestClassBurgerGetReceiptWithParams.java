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
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredientType1;
    private final String ingredientName1;
    private final float ingredientPrice1;
    private final IngredientType ingredientType2;
    private final String ingredientName2;
    private final float ingredientPrice2;
    private final float burgerPrice;

    public TestClassBurgerGetReceiptWithParams(String bunName, float bunPrice, IngredientType ingredientType1, String ingredientName1, float ingredientPrice1, IngredientType ingredientType2, String ingredientName2, float ingredientPrice2, float burgerPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType1 = ingredientType1;
        this.ingredientName1 = ingredientName1;
        this.ingredientPrice1 = ingredientPrice1;
        this.ingredientType2 = ingredientType2;
        this.ingredientName2 = ingredientName2;
        this.ingredientPrice2 = ingredientPrice2;
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
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIngredient1.getType()).thenReturn(ingredientType1);
        Mockito.when(mockIngredient1.getName()).thenReturn(ingredientName1);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(ingredientPrice1);
        Mockito.when(mockIngredient2.getType()).thenReturn(ingredientType2);
        Mockito.when(mockIngredient2.getName()).thenReturn(ingredientName2);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(ingredientPrice2);

        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
            bunName, ingredientType1.toString().toLowerCase(), ingredientName1,
                     ingredientType2.toString().toLowerCase(), ingredientName2,
            bunName, burgerPrice);
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
