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
    private int mochilaCheia;  //index do ultimo elemento da solução**
    private double probabilidade;

    public int getMochilaCheia() {
        return mochilaCheia;
    }

    public void setMochilaCheia(int mochilaCheia) {
        this.mochilaCheia = mochilaCheia;
    }

    public Mochila() {
        
        this.peso = 0;
        this.capacidade = 28;
        this.valor = 0;
    }
    
    public Mochila(ArrayList<Item> solucao){
        this.peso = 0;
        this.capacidade = 28;
        this.valor = 0;
        this.solucao = solucao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void imprimeMochila(){
        System.out.println("ID");
        for(int i = 0; i<=mochilaCheia; i++){
            System.out.print(solucao.get(i).getId()+"\t");
            
        }
        System.out.println("");
        System.out.println("VALOR");
        
        for(int i = 0; i<=mochilaCheia; i++){
            System.out.print(solucao.get(i).getValor()+"\t");
            
        }
        System.out.println("");
        System.out.println("PESO");
        
        for(int i = 0; i<=mochilaCheia; i++){
            System.out.print(solucao.get(i).getPeso()+"\t");
            
        }

        System.out.println("");
        System.out.println("Peso da mochila:"+peso+"Valor da Mochila:"+valor);
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
    

    public void atualizaMochila(){
        this.peso = 0;
        this.valor = 0;
        
        for (int i = 0; i < solucao.size(); i++) {
            if(this.peso + solucao.get(i).getPeso() < 28){
                this.peso += solucao.get(i).getPeso();
                this.valor += solucao.get(i).getValor();
                this.mochilaCheia = i;                
            }
            else{
                i = this.solucao.size(); // força a saída do laço
            }
        }
    }

    public double getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(double probabilidade) {
        this.probabilidade = probabilidade;
    }
    
    
}
