package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.*;

import static org.junit.Assert.assertEquals;

public class TestClassBurger {
    private Burger burger;
    @Mock
    private Bun mockBun;

    @Before
    public void setUp() {
        burger = new Burger();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetBuns() throws Exception {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }
}
