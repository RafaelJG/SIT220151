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
    
    
    
    ArrayList<Mochila> CrossOverSimples (Mochila pai, Mochila mae){
        ArrayList<Mochila> filhos = new ArrayList<>();
        int PontoCross = (Maior(pai.getMochilaCheia(), mae.getMochilaCheia()))/2;
        //filho1 recebe: mae de 0 até ponto cross + pai de ponto cross até maior(pai,mae)
        //filho2 recebe o inverso
        return filhos;
    }
    
    
    
    int Maior(int num1, int num2){
        if(num1<num2) return num1;
        else if(num2<num1) return num2;
        else return 0;
        
        
        
        
    }
}
