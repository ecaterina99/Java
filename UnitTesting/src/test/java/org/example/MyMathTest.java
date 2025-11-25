package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyMathTest {

    @Test
    public void zeroDenominatorShouldThrowException() {
        assertThrows(ArithmeticException.class, () -> {
            MyMath.divide(1, 0);
        });
    }
}