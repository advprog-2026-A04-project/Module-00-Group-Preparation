package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorUtilityTest {

    @Test
    void add_nullVector1() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = null;
        double[] v2 = {1, 2, 3};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(v1, v2));
        assertEquals("Vector must not be null", exception.getMessage());
    }

    @Test
    void add_nullVector2() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = {1, 2, 3};
        double[] v2 = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(v1, v2));
        assertEquals("Vector must not be null", exception.getMessage());
    }

    @Test
    void add_differentLength() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = {1, 2};
        double[] v2 = {1, 2, 3};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vectorUtility.add(v1, v2));
        assertEquals("Vectors must have the same length", exception.getMessage());
    }

    @Test
    void add_success() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = {1, 2, 3};
        double[] v2 = {1, 2, 3};
        double[] expected = {2, 4, 6};

        assertArrayEquals(expected, vectorUtility.add(v1, v2));


    }

    @Test
    void multiply_multipliesEachElementByScalar() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] input = {1.0, -2.5, 0.0};

        double[] result = vectorUtility.multiply(input, 3);

        assertArrayEquals(new double[] {3.0, -7.5, 0.0}, result, 1e-9);
        assertArrayEquals(new double[] {1.0, -2.5, 0.0}, input, 1e-9);
    }

    @Test
    void multiply_handlesEmptyVector() {
        VectorUtility vectorUtility = new VectorUtility();
        assertEquals(0, vectorUtility.multiply(new double[0], 10).length);
    }

    @Test
    void multiply_throwsOnNullVector() {
        VectorUtility vectorUtility = new VectorUtility();

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> vectorUtility.multiply(null, 2));

        assertEquals("v1 must not be null", exception.getMessage());
    }

    @Test
    void dotProduct_nullVector1() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = null;
        double[] v2 = {1, 2, 3};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
        assertEquals("Vector must not be null", exception.getMessage());
    }

    @Test
    void dotProduct_nullVector2() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = {1, 2, 3};
        double[] v2 = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
        assertEquals("Vector must not be null", exception.getMessage());
    }

    @Test
    void dotProduct_differentLength() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = {1, 2};
        double[] v2 = {1, 2, 3};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> vectorUtility.dotProduct(v1, v2));
        assertEquals("Vectors must have the same length", exception.getMessage());
    }

    @Test
    void dotProduct_success() {
        VectorUtility vectorUtility = new VectorUtility();
        double[] v1 = {1, 2, 3};
        double[] v2 = {4, 5, 6};

        double result = vectorUtility.dotProduct(v1, v2);

        // 1*4 + 2*5 + 3*6 = 32
        assertEquals(32.0, result);
    }

}

