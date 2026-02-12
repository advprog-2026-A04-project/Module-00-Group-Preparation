package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilityTest {

    @Test
    void multiply_multipliesOperands() {
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

        assertEquals(12.5, arithmeticUtility.multiply(2.5, 5.0), 1e-9);
        assertEquals(-6.0, arithmeticUtility.multiply(2.0, -3.0), 1e-9);
        assertEquals(0.0, arithmeticUtility.multiply(0.0, 123.0), 1e-9);
    }

    @Test
    void add_addsOperands() {
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

        assertEquals(3.0, arithmeticUtility.add(1.0, 2.0));
        assertEquals(-4.0, arithmeticUtility.add(6.0, -10.0));

        assertEquals(3.75, arithmeticUtility.add(1.25, 2.5));
    }

    @Test
    void add_edgeCases() {
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

        assertEquals(Double.POSITIVE_INFINITY, arithmeticUtility.add(Double.POSITIVE_INFINITY, 0));
        assertEquals(Double.POSITIVE_INFINITY, arithmeticUtility.add(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        assertEquals(Double.NaN, arithmeticUtility.add(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
    }

    @Test
    void subtract_subtractsOperands() {
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

        assertEquals(-2.0, arithmeticUtility.subtract(1.0, 3.0));
        assertEquals(-4.0, arithmeticUtility.subtract(6.0, 10.0));
        assertEquals(-1.25, arithmeticUtility.subtract(1.25, 2.5));
    }

    @Test
    void subtract_edgeCases() {
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();

        assertEquals(Double.POSITIVE_INFINITY, arithmeticUtility.subtract(Double.POSITIVE_INFINITY, 0));
        assertEquals(Double.NEGATIVE_INFINITY, arithmeticUtility.subtract(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        assertEquals(Double.NaN, arithmeticUtility.subtract(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }

}
