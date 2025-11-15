package it.unicam.cs.asdl2526.tutorato.mp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorTest {

    @Test
    final void testFactor() {
        assertThrows(IllegalArgumentException.class, () -> new Factor(2, 0));
    }

    @Test
    final void testFactor1() {
        assertThrows(IllegalArgumentException.class, () -> new Factor(2, -1));
    }

    @Test
    final void testFactor2() {
        assertThrows(IllegalArgumentException.class, () -> new Factor(0, 1));
    }

    @Test
    final void testFactor3() {
        assertThrows(IllegalArgumentException.class, () -> new Factor(-1, 1));
    }

    @Test
    final void testHashCode() {
        Factor f = new Factor(2, 3);
        Factor f1 = new Factor(2, 3);
        assertEquals(f.hashCode(), f1.hashCode());
        assertEquals(f.hashCode(), f1.hashCode());
    }

    @Test
    final void testEqualsObject() {
        Factor f = new Factor(2, 3);
        Factor f1 = new Factor(2, 3);
        Factor f2 = new Factor(3, 2);
        assertEquals(f, f1);
        assertEquals(f1, f);
        assertNotEquals(f, f2);
        assertNotEquals(f2, f1);
        assertNotEquals(null, f);
        Factor f3 = new Factor(11, 31);
        Factor f4 = new Factor(2, 31);
        assertNotEquals(f3, f4);
        assertNotEquals(f4, f3);
        Factor f5 = new Factor(11, 31);
        Factor f6 = new Factor(11, 3);
        assertNotEquals(f5, f6);
        assertNotEquals(f6, f5);
    }

    @Test
    final void testCompareTo() {
        Factor f = new Factor(2, 3);
        Factor f1 = new Factor(2, 3);
        Factor f2 = new Factor(2, 5);
        Factor f3 = new Factor(2, 1);
        assertEquals(0, f.compareTo(f1));
        assertEquals(0, f1.compareTo(f));
        assertTrue(f.compareTo(f2) < 0);
        assertTrue(f2.compareTo(f) > 0);
        assertTrue(f.compareTo(f3) > 0);
        assertTrue(f3.compareTo(f) < 0);
    }

    @Test
    final void testCompareTo2() {
        Factor f = new Factor(2, 3);
        Factor f1 = new Factor(2, 3);
        Factor f2 = new Factor(2, 5);
        Factor f3 = new Factor(2, 1);
        Factor f4 = new Factor(3, 3);
        assertTrue(f4.compareTo(f) > 0);
        assertTrue(f4.compareTo(f1) > 0);
        assertTrue(f4.compareTo(f2) > 0);
        assertTrue(f4.compareTo(f3) > 0);
        assertTrue(f.compareTo(f4) < 0);
        assertTrue(f1.compareTo(f4) < 0);
        assertTrue(f2.compareTo(f4) < 0);
        assertTrue(f3.compareTo(f4) < 0);
    }

    @Test
    final void testToString() {
        Factor f = new Factor(2, 3);
        assertEquals("2^3", f.toString());
        Factor f1 = new Factor(11, 45);
        assertEquals("11^45", f1.toString());
    }

    @Test
    final void testConstructor() {
        Factor f = new Factor(2, 3);
        assertEquals(2, f.getPrimeValue());
        assertEquals(3, f.getMultiplicity());
    }

}
