/**
 * 
 */
package it.unicam.cs.asdl2526.tutorato.mp1;

import java.util.Objects;

/**
 * Un oggetto di questa classe rappresenta una lampada che ha un appoggio
 * circolare. Implementa l'interfaccia ShelfItem, ma come lunghezza e larghezza
 * ha il diametro della base. Ridefinisce il metodo di default per calcolare la
 * superficie occupata restituiendo l'area del cerchio che corrisponde alla
 * base. Una lampada è identificata dal nome e dal nome del brand.
 * 
 * @author Luca Tesei (template) // TODO INSERIRE NOME, COGNOME ED EMAIL
 *         xxxx@studenti.unicam.it DELLO STUDENTE (implementazione)
 *
 */
public class RoundLamp implements ShelfItem {

    private final double diameter;

    private final double weight;

    private final String name;

    private final String brandName;

    // TODO definire ulteriori variabili istanza che si ritengono necessarie per
    // implementare tutti i metodi

    /**
     * @param diameter
     *                      diametro della base in cm
     * @param weight
     *                      peso in grammi
     * @param name
     *                      nome del modello della lampada
     * @param brandName
     *                      nome del brand della lampada
     */
    public RoundLamp(double diameter, double weight, String name,
            String brandName) {
        this.diameter = diameter;
        this.weight = weight;
        this.name = name;
        this.brandName = brandName;
    }

    /*
     * Restituisce l'area del cerchio corrispondente alla base
     */
    @Override
    public double getOccupiedSurface() {
        return Math.PI * Math.pow(diameter / 2, 2);
    }

    /*
     * Restituisce il diametro della base
     */
    @Override
    public double getLength() {
        return this.diameter;
    }

    /*
     * Restituisce il diametro della base
     */
    @Override
    public double getWidth() {
        return this.diameter;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    /**
     * @return the diameter
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RoundLamp)) return false;
        RoundLamp roundLamp = (RoundLamp) o;
        return Objects.equals(name, roundLamp.name) && Objects.equals(brandName, roundLamp.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brandName);
    }


}
