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

        Scanner teclado = new Scanner(System.in);
        ArrayList<Mochila> populacaoInicial = new ArrayList<>();
        BuscaFeixe feixe = new BuscaFeixe();
        AlgGenetico ag = new AlgGenetico();
        
        System.out.println("Entre com o tamanho da população inicial:");
        int tamanhoPopulacaoInicial = teclado.nextInt();
        System.out.println("Entre com o número de iterações");
        int geracoes = teclado.nextInt();
        
        populacaoInicial = solucionador.gerarSolucao(tamanhoPopulacaoInicial);
        
                
//        algoritmo.PMX(solucionador.gerarSolucao(),solucionador.gerarSolucao());
//        System.out.println("População Inicial:");
//        for(Mochila mochila : populacaoInicial){
//            mochila.imprimeMochila();
//        }
        System.out.println("____________________________________________________");
        Mochila solucaoFeixe = feixe.buscaEmFeixe(populacaoInicial, geracoes, tamanhoPopulacaoInicial);
        
        System.out.println("Após " + geracoes + " com população inicial de " + tamanhoPopulacaoInicial + " mochilas.");
        
        System.out.println("Solução Busca em Feixe:");
        solucaoFeixe.imprimeMochila();
        
//        System.out.println("____________________________________________________");
//        Mochila solucaoAG = ag.algoritmoGenetico(populacaoInicial, geracoes, tamanhoPopulacaoInicial);
//        

        
//        ag.calculaProbabilidadesPopulacao(populacaoInicial);
        
//        ag.algoritmoGenetico(populacaoInicial, tamanhoPopulacaoInicial);
        
      
        


        
        }
        
    
}
