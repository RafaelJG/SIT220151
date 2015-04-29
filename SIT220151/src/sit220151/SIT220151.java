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
        
        
        
//        System.out.println("População Inicial:");
//        for(Mochila mochila : populacaoInicial){
//            mochila.imprimeMochila();
//        }
        
        long tempoAux = 0;
        int valorMedio = 0;
        int pesoMedio = 0;
        
        //BUSCA EM FEIXE
        
        Mochila melhorMochilaFeixe = new Mochila();
        for (int i = 0; i < 10; i++) {
            
            populacaoInicial = solucionador.gerarSolucao(tamanhoPopulacaoInicial);
            long tempoInicialFeixe = System.currentTimeMillis();
            Mochila solucaoFeixe = feixe.buscaEmFeixe(populacaoInicial, geracoes, tamanhoPopulacaoInicial);
            long tempoFinalFeixe = System.currentTimeMillis();
            tempoAux += tempoFinalFeixe-tempoInicialFeixe;
            System.out.println("Tempo solução "+i+" :"+(tempoFinalFeixe-tempoInicialFeixe));
            if(i==0){
                melhorMochilaFeixe = (Mochila) solucaoFeixe.clone();
            }
            else{
                if(solucaoFeixe.getValor()>melhorMochilaFeixe.getValor()){
                    melhorMochilaFeixe = (Mochila) solucaoFeixe.clone();
                }
            }           
            
            
            pesoMedio += solucaoFeixe.getPeso();
            valorMedio += solucaoFeixe.getValor();
        }
        
        tempoAux = tempoAux/10;
        pesoMedio = pesoMedio/10;
        valorMedio = valorMedio/10;
        
        
        System.out.println("____________________________________________________");
        
        System.out.println("Melhor Solução Busca em Feixe: ");
        melhorMochilaFeixe.imprimeMochila();
        
        System.out.println("Tempo médio: " + tempoAux + "ms.");
        System.out.println("Valor médio: " + valorMedio + " dinheiros.");
        System.out.println("Peso médio: " + pesoMedio + "Kg");
//        
//        
//        
//        
//        System.out.println("");
//        System.out.println("Após " + geracoes + " com população inicial de " + tamanhoPopulacaoInicial + " mochilas.");
//        
//        System.out.println("Solução Busca em Feixe:");
//        solucaoFeixe.imprimeMochila();
//        System.out.println("Algoritmo de Busca em Feixe levou: " + (tempoFinalFeixe-tempoInicialFeixe) + " milisegundos.");
//        System.out.println("");
        
        tempoAux = 0;
        valorMedio = 0;
        pesoMedio = 0;
        
        Mochila melhorMochilaAG = new Mochila();
        for (int i = 0; i < 10; i++) {
            populacaoInicial = solucionador.gerarSolucao(tamanhoPopulacaoInicial);
            
            long tempoInicialAG = System.currentTimeMillis();
            Mochila solucaoAG = ag.algoritmoGenetico(populacaoInicial, geracoes, tamanhoPopulacaoInicial);
            long tempoFinalAG = System.currentTimeMillis();
            
            if(i==0){
                melhorMochilaAG = (Mochila) solucaoAG.clone();
            }
            else{
                if(solucaoAG.getValor()>melhorMochilaAG.getValor()){
                    melhorMochilaAG = (Mochila) solucaoAG.clone();
                }
            }
            
            
            tempoAux += tempoFinalAG-tempoInicialAG;
            pesoMedio += solucaoAG.getPeso();
            valorMedio += solucaoAG.getValor();
        }
        
        tempoAux = tempoAux/10;
        pesoMedio = pesoMedio/10;
        valorMedio = valorMedio/10;
        
        
        System.out.println("____________________________________________________");
        
        System.out.println("Melhor Solução AG: ");
        melhorMochilaAG.imprimeMochila();
        
        System.out.println("Tempo médio: " + tempoAux + "ms.");
        System.out.println("Valor médio: " + valorMedio + " dinheiros.");
        System.out.println("Peso médio: " + pesoMedio + "Kg");
        
        
        
        //ALG. GENETICO        
//        System.out.println("____________________________________________________");
//        long tempoInicialAG = System.currentTimeMillis();
//        Mochila solucaoAG = ag.algoritmoGenetico(populacaoInicial, geracoes, tamanhoPopulacaoInicial);
//        long tempoFinalAG = System.currentTimeMillis();
//        
//        System.out.println("");
//        System.out.println("Solução Algoritmo Genético:");
//        solucaoAG.imprimeMochila();
//        System.out.println("Algoritmo Genético levou: " + (tempoFinalAG-tempoInicialAG) + " milisegundos.");
    }
        
}
