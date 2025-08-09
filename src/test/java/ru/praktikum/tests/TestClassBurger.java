package ru.praktikum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestClassBurger {
    private Burger burger;
    @Mock
    private Bun mockBun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() throws Exception {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }
}
