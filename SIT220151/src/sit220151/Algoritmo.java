/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

import java.util.ArrayList;
import org.omg.CORBA.INTERNAL;

/**
 *
 * @author rafael
 */
public class Algoritmo {
    
    
//    
//    ArrayList<Mochila> CrossOverSimples (Mochila pai, Mochila mae){
//        ArrayList<Mochila> filhos = new ArrayList<>();
//        int PontoCross = (Maior(pai.getMochilaCheia(), mae.getMochilaCheia()))/2;
//        //filho1 recebe: mae de 0 até ponto cross + pai de ponto cross até maior(pai,mae)
//        //filho2 recebe o inverso
//        return filhos;
//    }
    
    
   
    
    
    
    boolean maior(int num1, int num2){
        if(num1>num2) return true;
        else return false;
        
    }
    
    Mochila clonaMochila(Mochila mochila){
        
        Mochila mochilaCopiada = new Mochila();
        
        for(Item item : mochila.getSolucao()){
            mochilaCopiada.addItem(item);
        }
        
        mochilaCopiada.setCapacidade(mochila.getCapacidade());
        mochilaCopiada.setMochilaCheia(mochila.getMochilaCheia());
        mochilaCopiada.setPeso(mochila.getPeso());
        mochilaCopiada.setValor(mochila.getValor());
        mochilaCopiada.setProbabilidade(mochila.getProbabilidade());
        mochilaCopiada.setRoleta(mochila.getRoleta());
        
        
        return mochilaCopiada;
    }
    
    public boolean temNaMochila(int idItem, Mochila mochila){
        
        for(int i = 0; i<= mochila.getMochilaCheia(); i++){
            if(mochila.getSolucao().get(i).getId() == idItem){
                return true;
            }
        }
        
        return false;        
    }
    
}
