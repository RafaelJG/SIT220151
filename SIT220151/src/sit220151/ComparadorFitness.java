/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

import java.util.Comparator;

/**
 *
 * @author maycowmeira
 */
public class ComparadorFitness implements Comparator<Mochila> {

    /* Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     */
    @Override
    public int compare(Mochila o1, Mochila o2) {
        if(o1.getValor() < o2.getValor())
            return 1;        
        if(o1.getValor() > o2.getValor())
            return -1;
        else
            return 0;
    }    
}
