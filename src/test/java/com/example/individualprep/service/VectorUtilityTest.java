package com.example.individualprep.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VectorUtilityTest {

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
    void norm_computesNorm() {
        VectorUtility vectorUtility = new VectorUtility();

        assertEquals(13.0, vectorUtility.norm(new double[] {3.0, 4.0, 12.0}));
        assertEquals(13.0, vectorUtility.norm(new double[] {3.0, -4.0, -12.0}));
    }

    @Test
    void norm_handlesEmptyVector() {
        VectorUtility vectorUtility = new VectorUtility();

        assertEquals(0.0, vectorUtility.norm(new double[] {}));
    }

    @Test
    void norm_throwsOnNullVector() {
        VectorUtility vectorUtility = new VectorUtility();

        assertThrows(IllegalArgumentException.class, () -> vectorUtility.norm(null));
    }

    @Test
    void norm_handlesEdgeCases() {
        VectorUtility vectorUtility = new VectorUtility();

        assertEquals(Double.POSITIVE_INFINITY, vectorUtility.norm(new double[] {Double.POSITIVE_INFINITY, -4.0, -12.0}));
        assertEquals(Double.POSITIVE_INFINITY, vectorUtility.norm(new double[] {Double.NEGATIVE_INFINITY, -4.0, -12.0}));
        assertEquals(Double.POSITIVE_INFINITY, vectorUtility.norm(new double[] {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}));
        assertTrue(Double.isNaN(vectorUtility.norm(new double[] {3.0, -4.0, Double.NaN})));
    }
}
