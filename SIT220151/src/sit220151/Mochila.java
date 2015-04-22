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
    private int capacidade;
    private int peso; //peso atual da mochila
    private ArrayList<Item> solucao = new ArrayList<>();
    private int valor;

    public Mochila() {
        
        this.peso = 0;
        this.capacidade = 28;
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void imprimeMochila(){
        for(Item item: solucao){
            System.out.println(item.getId()+" - "+ item.getPeso()+"kg");
        }
        
        System.out.println("Peso total: "+this.getPeso()+", valor: "+ this.getValor());
    
        
    }
    public void addItem(Item item){
        this.solucao.add(item);
        this.peso+= item.getPeso();
        this.valor+= item.getValor();
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Item> getSolucao() {
        return solucao;
    }

    public void setSolucao(ArrayList<Item> solucao) {
        this.solucao = solucao;
    }


    
    
    
}
