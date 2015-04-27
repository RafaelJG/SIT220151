/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author rafael
 */
public class SIT220151 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Solucionador solucionador = new Solucionador();
        Algoritmo algoritmo = new Algoritmo();
        Scanner teclado = new Scanner(System.in);
        ArrayList<Mochila> populacaoInicial = new ArrayList<>();
        BuscaFeixe feixe = new BuscaFeixe();
        
        System.out.println("Entre com o tamanho da população inicial:");
        int tamanhoPopulacaoInicial = teclado.nextInt();
        
        populacaoInicial = solucionador.gerarSolucao(tamanhoPopulacaoInicial);
        
                
//        algoritmo.PMX(solucionador.gerarSolucao(),solucionador.gerarSolucao());
        System.out.println("População Inicial:");
        for(Mochila mochila : populacaoInicial)
            mochila.imprimeMochila();
        
      
        
        
//        System.out.println("População depois do SORT:");
//        
//        for(Mochila mochila : populacaoInicial){
//            mochila.imprimeMochila();
//        }
        System.out.println("População do feixe:");
        for(Mochila nova :feixe.buscaEmFeixe(populacaoInicial, tamanhoPopulacaoInicial)){
            nova.imprimeMochila();
        }
        
        }
        
    
}
