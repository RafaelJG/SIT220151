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
public class Algoritmo {
    
    
//    
//    ArrayList<Mochila> CrossOverSimples (Mochila pai, Mochila mae){
//        ArrayList<Mochila> filhos = new ArrayList<>();
//        int PontoCross = (Maior(pai.getMochilaCheia(), mae.getMochilaCheia()))/2;
//        //filho1 recebe: mae de 0 até ponto cross + pai de ponto cross até maior(pai,mae)
//        //filho2 recebe o inverso
//        return filhos;
//    }
    
    ArrayList<Mochila> PMX (Mochila pai, Mochila mae){
        ArrayList<Mochila> filhos = new ArrayList<>();
        int pontoTroca = 0;
        int tamPMX = 0;
        filhos.add(new Mochila(pai.getSolucao()));
        filhos.add(new Mochila(mae.getSolucao()));

        if(Maior(pai.getMochilaCheia(),mae.getMochilaCheia())){
            tamPMX = mae.getMochilaCheia()/2;
            pontoTroca = mae.getMochilaCheia() - tamPMX - 2;
        }
        else{
            tamPMX = pai.getMochilaCheia()/2;
            pontoTroca = mae.getMochilaCheia() - tamPMX - 2;
        }
        System.out.println("PMX");
        
        for(int i = pontoTroca; i<=pontoTroca + tamPMX; i++){
            filhos.get(0).getSolucao().set(i, mae.getSolucao().get(i));
            filhos.get(1).getSolucao().set(i, pai.getSolucao().get(i));  
        }
        System.out.println("Pai:");
        pai.imprimeMochila();
        System.out.println("Mãe");
        mae.imprimeMochila();
        System.out.println("Filho 1:");
        filhos.get(0).imprimeMochila();
        System.out.println("Filho 2:");
        filhos.get(1).imprimeMochila();
        
        
        
        return filhos;
    
    
    }
    boolean Maior(int num1, int num2){
        if(num1>num2) return true;
        else return false;
        
    }
    
}
