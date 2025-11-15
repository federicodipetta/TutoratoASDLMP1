package it.unicam.cs.asdl2526.tutorato.mp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactoriserTest {
    private static final Factoriser f = new Factoriser();

    @Test
    final void testGetFactors1() {
        assertThrows(IllegalArgumentException.class, () -> f.getFactors(0));
    }

    @Test
    final void testGetFactors2() {
        Factor[] r = f.getFactors(1);
        assertEquals(0, r.length);
    }

    @Test
    final void testGetFactors3() {
        Factor[] r = f.getFactors(2);
        assertEquals(1, r.length);
        assertEquals(new Factor(2, 1), r[0]);
    }

    @Test
    final void testGetFactors4() {
        Factor[] r = f.getFactors(8);
        assertEquals(1, r.length);
        assertEquals(new Factor(2, 3), r[0]);
    }

    @Test
    final void testGetFactors5() {
        Factor[] r = f.getFactors(24);
        assertEquals(2, r.length);
        assertEquals(new Factor(2, 3), r[0]);
        assertEquals(new Factor(3, 1), r[1]);
    }

    @Test
    final void testGetFactors6() {
        Factor[] r = f.getFactors(24 * 3);
        assertEquals(2, r.length);
        assertEquals(new Factor(2, 3), r[0]);
        assertEquals(new Factor(3, 2), r[1]);
    }

    @Test
    final void testGetFactors7() {
        Factor[] r = f.getFactors(24 * 3 * 7);
        assertEquals(3, r.length);
        assertEquals(new Factor(2, 3), r[0]);
        assertEquals(new Factor(3, 2), r[1]);
        assertEquals(new Factor(7, 1), r[2]);
    }

    @Test
    final void testGetFactors8() {
        Factor[] r = f.getFactors(24 * 3 * 7 * 7 * 7);
        assertEquals(3, r.length);
        assertEquals(new Factor(2, 3), r[0]);
        assertEquals(new Factor(3, 2), r[1]);
        assertEquals(new Factor(7, 3), r[2]);
    }

    @Test
    final void testGetFactors9() {
        Factor[] r = f.getFactors(24 * 3 * 7 * 7 * 7 * 23);
        assertEquals(4, r.length);
        assertEquals(new Factor(2, 3), r[0]);
        assertEquals(new Factor(3, 2), r[1]);
        assertEquals(new Factor(7, 3), r[2]);
        assertEquals(new Factor(23, 1), r[3]);
    }

    @Test
    final void testGetFactors10() {
        Factor[] r = f.getFactors(24 * 3 * 7 * 7 * 7 * 23 * 23 * 23);
        assertEquals(4, r.length);
        assertEquals(new Factor(2, 3), r[0]);
        assertEquals(new Factor(3, 2), r[1]);
        assertEquals(new Factor(7, 3), r[2]);
        assertEquals(new Factor(23, 3), r[3]);
    }

    @Test
    final void testGetFactors11() {
        Factor[] r = f.getFactors(1386);
        assertEquals(4, r.length);
        assertEquals(new Factor(2, 1), r[0]);
        assertEquals(new Factor(3, 2), r[1]);
        assertEquals(new Factor(7, 1), r[2]);
        assertEquals(new Factor(11, 1), r[3]);
    }

    @Test
    final void testGetFactors12() {
        Factor[] r = f.getFactors(42890);
        assertEquals(3, r.length);
        assertEquals(new Factor(2, 1), r[0]);
        assertEquals(new Factor(5, 1), r[1]);
        assertEquals(new Factor(4289, 1), r[2]);
    }
}
