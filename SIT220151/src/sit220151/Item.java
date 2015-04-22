/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

/**
 *
 * @author rafael
 */
public class Item {
    
    private int valor;
    private int peso;
    private int id;

    public Item(int id, int peso, int valor) {
        this.valor = valor;
        this.peso = peso;
        this.id = id;
    }
    
    

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
