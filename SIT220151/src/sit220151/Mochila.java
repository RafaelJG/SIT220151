/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

import java.util.ArrayList;

/**
 *
 * @author rafael
 */
public class Mochila {
    private int tamanho = 28;
    private ArrayList<Item> solucao = new ArrayList<>();

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public ArrayList<Item> getSolucao() {
        return solucao;
    }

    public void setSolucao(ArrayList<Item> solucao) {
        this.solucao = solucao;
    }


    
    
    
}
