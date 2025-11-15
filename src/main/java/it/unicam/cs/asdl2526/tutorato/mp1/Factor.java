package it.unicam.cs.asdl2526.tutorato.mp1;

import java.util.Objects;

/**
 * Un oggetto di quest classe rappresenta un fattore primo di un numero naturale
 * con una certa molteplicità.
 * 
 * @author Luca Tesei (template)
 *
 */
public class Factor implements Comparable<Factor> {

    /*
     * Numero primo corrispondente a questo fattore
     */
    private final int primeValue;

    /*
     * Molteplicità del numero primo di questo fattore, deve essere maggiore o
     * uguale a 1.
     */
    private final int multiplicity;

    /**
     * Crea un fattore primo di un numero naturale, formato da un numero primo e
     * dalla sua molteplicità.
     * 
     * @param primeValue,
     *                          numero primo
     * @param multiplicity,
     *                          valore della molteplicità, deve essere almeno 1
     * @throws IllegalArgumentException
     *                                      se la molteplicità è minore di 1
     *                                      oppure se primeValue è minore o
     *                                      uguale di 0.
     */
    public Factor(int primeValue, int multiplicity) {
        if (primeValue <= 0 || multiplicity < 1)
            throw new IllegalArgumentException();
        this.primeValue = primeValue;
        this.multiplicity = multiplicity;
    }

    /**
     * @return the primeValue
     */
    public int getPrimeValue() {
        return primeValue;
    }

    /**
     * @return the multiplicity
     */
    public int getMultiplicity() {
        return multiplicity;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Factor)) return false;
        Factor factor = (Factor) o;
        return primeValue == factor.primeValue && multiplicity == factor.multiplicity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeValue, multiplicity);
    }

    /*
     * Un Factor è minore di un altro se contiene il numero primo minore. Se due
     * Factor hanno lo stesso numero primo allora il più piccolo dei due è
     * quello ce ha minore molteplicità.
     */
    @Override
    public int compareTo(Factor o) {
        int compare = Integer.compare(this.primeValue, o.primeValue);
        if (compare == 0) return Integer.compare(this.multiplicity, o.multiplicity);
        return compare;
    }

    /*
     * Il fattore viene reso con la stringa primeValue^multiplicity
     */
    @Override
    public String toString() {
        return this.primeValue + "^" + this.multiplicity;
    }

}
