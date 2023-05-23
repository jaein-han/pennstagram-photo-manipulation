package org.cis1200;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Use this file to test your implementation of Pixel.
 * 
 * We will manually grade this file to give you feedback
 * about the completeness of your test cases.
 */

public class MyPixelTest {

    /*
     * Remember, UNIT tests should ideally have one point of failure. Below we
     * give you two examples of unit tests for the Pixel constructor, one that
     * takes in three ints as arguments and one that takes in an array. We use
     * the getRed(), getGreen(), and getBlue() methods to check that the values
     * were set correctly. These two tests do not comprehensively test all of
     * Pixel so you must add your own.
     * 
     * You might want to look into assertEquals, assertTrue, assertFalse, and
     * assertArrayEquals at the following:
     * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
     *
     * Note, if you want to add global variables so that you can reuse Pixels
     * in multiple tests, feel free to do so.
     */

    @Test
    public void testConstructInBounds() {
        Pixel p = new Pixel(40, 50, 60);
        assertEquals(40, p.getRed());
        assertEquals(50, p.getGreen());
        assertEquals(60, p.getBlue());
    }

    @Test
    public void testConstructArrayLongerThan3() {
        int[] arr = { 10, 20, 30, 40 };
        Pixel p = new Pixel(arr);
        assertEquals(10, p.getRed());
        assertEquals(20, p.getGreen());
        assertEquals(30, p.getBlue());
    }

    /* ADD YOUR OWN TESTS BELOW */
    @Test
    public void testConstructOutOfBounds() {
        Pixel p = new Pixel(260, -40, 90);
        assertEquals(255, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(90, p.getBlue());
    }

    @Test
    public void testConstructArrayShorterThan3() {
        int[] arr = {270};
        Pixel p = new Pixel(arr);
        assertEquals(255, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testConstructEmptyArray() {
        int[] arr = {};
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testConstructNullArray() {
        int[] arr = null;
        Pixel p = new Pixel(arr);
        assertEquals(0, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(0, p.getBlue());
    }

    @Test
    public void testConstructArrayGeneral() {
        int[] arr = {60, -20, 90};
        Pixel p = new Pixel(arr);
        assertEquals(60, p.getRed());
        assertEquals(0, p.getGreen());
        assertEquals(90, p.getBlue());
    }

    @Test
    public void testGetComponents() {
        Pixel p = new Pixel(40, 50, 60);
        int[] arr = {40, 50, 60};
        assertArrayEquals(arr, p.getComponents());
    }

    @Test
    public void testDistanceGeneral() {
        Pixel p = new Pixel(40, 50, 60);
        Pixel pOther = new Pixel(50, 60, 70);
        assertEquals(30, p.distance(pOther));
    }

    @Test
    public void testDistanceNull() {
        Pixel p = null;
        assertEquals(-1, Pixel.GREEN.distance(p));
    }

    @Test
    public void testToStringGeneral() {
        assertEquals("(255, 0, 0)", Pixel.RED.toString());
    }

    @Test
    public void testSameRGBTrue() {
        Pixel p = new Pixel(255, 0, 0);
        assertTrue(p.sameRGB(Pixel.RED));
    }

    @Test
    public void testSameRGBFalse() {
        Pixel p = new Pixel(40, 50, 60);
        assertFalse(p.sameRGB(Pixel.GREEN));
    }
}
