package it.unicam.cs.asdl2526.tutorato.mp1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Un fattorizzatore è un agente che fattorizza un qualsiasi numero naturale nei
 * sui fattori primi.
 * 
 * @author Luca Tesei (template)
 *
 */
public class Factoriser {


    /**
     * Fattorizza un numero restituendo la sequenza crescente dei suoi fattori
     * primi. La molteplicità di ogni fattore primo esprime quante volte il
     * fattore stesso divide il numero fattorizzato. Per convenzione non viene
     * mai restituito il fattore 1. Il minimo numero fattorizzabile è 1. In
     * questo caso viene restituito un array vuoto.
     * 
     * @param n
     *              un numero intero da fattorizzare
     * @return un array contenente i fattori primi di n
     * @throws IllegalArgumentException
     *                                      se si chiede di fattorizzare un
     *                                      numero minore di 1.
     */
    public Factor[] getFactors(int n) {
        List<Factor> factors = new LinkedList<>();
        if (n < 1) {
            throw new IllegalArgumentException("n < 1");
        }

        if (n == 1)
            return new Factor[0];

        int size = n /2 + 1;
        CrivelloDiEratostene c = new CrivelloDiEratostene(size);

        for (int prime = c.nextPrime(); c.hasNextPrime(); prime = c.nextPrime() ) {
            int mult = 0;
            while (n % prime == 0) {
                mult++;
                n /= prime;
            }
            if (mult != 0)
                factors.add(new Factor(prime, mult));
        }

        if (factors.size() == 0) {
            return new Factor[] { new Factor(n, 1)};
        }

        return factors.toArray(new Factor[factors.size()]);
    }

}
