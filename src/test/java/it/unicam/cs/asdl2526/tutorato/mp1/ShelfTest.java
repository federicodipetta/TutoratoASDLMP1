package it.unicam.cs.asdl2526.tutorato.mp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShelfTest {
    /*
     * Costante piccola per il confronto di due numeri double
     */
    private static final double EPSILON = 1.0E-15;

    private final Book b1 = new Book(
            "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest,"
                    + " Clifford Stein",
            "Introduzione agli algoritmi e strutture dati", 2010,
            "McGraw-Hill Education", "978-8838665158", 26.6, 19.08, 1720);

    private final Book b1Equals = new Book("", "", 0, "", "978-8838665158", 0, 0, 0);

    private final Book b2 = new Book("Maurizio Gabbrielli, Simone Martini",
            "Linguaggi di programmazione. Principi e paradigmi", 2011,
            "McGraw-Hill Education", "978-8838665738", 24.13, 17.15, 939);

    private final Book b2Equals = new Book("", "", 0, "", "978-8838665738", 0, 0, 0);

    private final Book b3 = new Book("Cay S. Horstmann",
            "Concetti di informatica e fondamenti di Java. 7a edizione", 2020,
            "Maggioli Editore", "978-8891639431", 26.6, 19.08, 1280);

    private final Book b3Equals = new Book("", "", 0, "", "978-8891639431", 0, 0, 0);

    private final RoundLamp l1 = new RoundLamp(10, 1230, "Ticino", "Lindby");

    private final RoundLamp l1Equals = new RoundLamp(0, 0, "Ticino", "Lindby");

    private final RoundLamp l2 = new RoundLamp(13, 1550, "Tibby", "Lindby");

    private final RoundLamp l2Equals = new RoundLamp(0, 0, "Tibby", "Lindby");

    private final RoundLamp l3 = new RoundLamp(11, 2550, "Ronja", "Lindby");

    private final RoundLamp l3Equals = new RoundLamp(0, 0, "Tibby", "Lindby");

    @Test
    final void testAddItem1() {
        Shelf shelf = new Shelf(15, 13, 1000, 3000);
        // Eccede lunghezza e larghezza
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(b1));
    }

    @Test
    final void testAddItem2() {
        Shelf shelf = new Shelf(15, 20, 1000, 3000);
        // Eccede lunghezza
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(b1));
    }

    @Test
    final void testAddItem3() {
        Shelf shelf = new Shelf(27, 13, 1000, 3000);
        // Eccede larghezza
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(b1));
    }

    @Test
    final void testAddItem4() {
        Shelf shelf = new Shelf(27, 20, 1000, 1700);
        // Eccede il peso
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(b1));
    }

    @Test
    final void testAddItem5() {
        Shelf shelf = new Shelf(27, 20, 190, 1700);
        // Eccede la superficie
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(b1));
    }

    @Test
    final void testAddItem6() {
        Shelf shelf = new Shelf(27, 20, 508 + 414, 9700);
        shelf.addItem(b1);
        shelf.addItem(b2);
        // Eccede la superficie
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(l1));
    }

    @Test
    final void testAddItem7() {
        Shelf shelf = new Shelf(27, 20, 508, 2800);
        shelf.addItem(l1);
        shelf.addItem(l2);
        // Eccede il peso
        assertThrows(IllegalArgumentException.class, () -> shelf.addItem(l3));
    }

    @Test
    final void testAddItem8() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        assertEquals(0, shelf.getNumberOfItems());
        shelf.addItem(l1);
        assertEquals(1, shelf.getNumberOfItems());
        shelf.addItem(l2);
        assertEquals(2, shelf.getNumberOfItems());
        shelf.addItem(l3);
        assertEquals(3, shelf.getNumberOfItems());
        shelf.addItem(b1);
        assertEquals(4, shelf.getNumberOfItems());
        shelf.addItem(b2);
        assertEquals(5, shelf.getNumberOfItems());
        // raggiunta massima posizione
        assertEquals(5, shelf.getItems().length);
        // raddoppia
        shelf.addItem(b3);
        assertEquals(6, shelf.getNumberOfItems());
        assertEquals(10, shelf.getItems().length);
    }

    @Test
    final void testAddItem9() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        shelf.addItem(l1);
        shelf.addItem(l2);
        shelf.addItem(l3);
        shelf.addItem(b1);
        shelf.addItem(b2);
        // raggiunta massima posizione
        assertEquals(5, shelf.getItems().length);
        // raddoppia
        shelf.addItem(b3);
        assertEquals(6, shelf.getNumberOfItems());
        assertEquals(10, shelf.getItems().length);
        assertEquals(shelf.getItems()[0], l1);
        assertEquals(shelf.getItems()[1], l2);
        assertEquals(shelf.getItems()[2], l3);
        assertEquals(shelf.getItems()[3], b1);
        assertEquals(shelf.getItems()[4], b2);
        assertEquals(shelf.getItems()[5], b3);
    }

    @Test
    final void testSearch1() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        shelf.addItem(l1);
        shelf.addItem(l2);
        shelf.addItem(l3);
        shelf.addItem(b1);
        shelf.addItem(b2);
        assertNotNull(shelf.search(l1Equals));
        ShelfItem searchResult = shelf.search(l1Equals);
        // Controlla se è stato tirato fuori l'oggetto nell'array
        RoundLamp l1Cast = (RoundLamp) searchResult;
        assertEquals(10, l1Cast.getDiameter());
    }

    @Test
    final void testSearch2() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        shelf.addItem(l1);
        shelf.addItem(l2);
        shelf.addItem(l3);
        shelf.addItem(b1);
        shelf.addItem(b2);
        assertNull(shelf.search(b3Equals));
    }

    @Test
    final void testSearch3() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        assertNull(shelf.search(l1));
        shelf.addItem(l1);
        assertNotNull(shelf.search(l1Equals));
        assertNotNull(shelf.search(l1));
        assertNull(shelf.search(l2Equals));
        shelf.addItem(l2);
        assertNotNull(shelf.search(l2Equals));
        assertNull(shelf.search(b1));
        shelf.addItem(b1);
        assertNotNull(shelf.search(b1Equals));
        assertNotNull(shelf.search(b1));
        assertNull(shelf.search(b2Equals));
        shelf.addItem(b2);
        assertNotNull(shelf.search(b2Equals));
    }

    @Test
    final void testSearch4() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        assertNull(shelf.search(l1));
        shelf.addItem(l1);
        assertNotNull(shelf.search(l1Equals));
        assertNotNull(shelf.search(l1));
        assertNull(shelf.search(l2Equals));
        shelf.addItem(l2);
        assertNotNull(shelf.search(l2Equals));
        assertNull(shelf.search(b1));
        shelf.addItem(b1);
        assertNotNull(shelf.search(b1Equals));
        assertNotNull(shelf.search(b1));
        assertNull(shelf.search(b2Equals));
        shelf.addItem(b2);
        assertNotNull(shelf.search(b2Equals));
        shelf.addItem(b3);
        shelf.addItem(l3);
        assertNotNull(shelf.search(b3Equals));
        assertNotNull(shelf.search(l3Equals));
    }

    @Test
    final void testSearch5() {
        Shelf shelf = new Shelf(27, 20, 2508, 10000);
        assertThrows(NullPointerException.class, () -> shelf.search(null));
    }

    @Test
    final void testGetNumberOfItems() {
        Shelf shelf = new Shelf(27, 20, 508, 2800);
        assertEquals(0, shelf.getNumberOfItems());
        shelf.addItem(l1);
        assertEquals(1, shelf.getNumberOfItems());
        shelf.addItem(l2);
        assertEquals(2, shelf.getNumberOfItems());
    }

    @Test
    final void testGetItems() {
        Shelf shelf = new Shelf(27, 20, 508, 2800);
        assertEquals(0, shelf.getNumberOfItems());
        shelf.addItem(l1);
        assertEquals(1, shelf.getNumberOfItems());
        shelf.addItem(l2);
        assertEquals(2, shelf.getNumberOfItems());
        assertEquals(shelf.getItems()[0], l1Equals);
        assertEquals(shelf.getItems()[1], l2Equals);
        assertNull(shelf.getItems()[2]);
    }

    @Test
    final void testGetCurrentTotalWeight() {
        Shelf shelf = new Shelf(27, 20, 508, 2800);
        assertEquals(0, shelf.getCurrentTotalWeight());
        shelf.addItem(l1);
        assertEquals(1230, shelf.getCurrentTotalWeight());
        shelf.addItem(l2);
        assertTrue(Math
                .abs(shelf.getCurrentTotalWeight() - (1230 + 1550)) < EPSILON);
    }

    @Test
    final void testGetCurrentTotalOccupiedSurface() {
        Shelf shelf = new Shelf(27, 20, 508, 2800);
        assertEquals(0, shelf.getCurrentTotalOccupiedSurface());
        shelf.addItem(l1);
        assertTrue(Math.abs(shelf.getCurrentTotalOccupiedSurface()
                - (5 * 5 * Math.PI)) < EPSILON);
        shelf.addItem(l2);
        assertTrue(Math
                .abs(shelf.getCurrentTotalOccupiedSurface() - ((5 * 5 * Math.PI)
                        + ((13.0 / 2) * (13.0 / 2) * Math.PI))) < EPSILON);
    }

}
