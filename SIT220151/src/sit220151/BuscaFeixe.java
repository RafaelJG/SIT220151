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
public class BuscaFeixe {

    public BuscaFeixe() {
    }
    
    public ArrayList<Mochila> buscaEmFeixe(ArrayList<Mochila> populacaoInicial, int geracoes, int tamanhoPopulacao){
        
        ArrayList<Mochila> populacaoFeixe = new ArrayList<Mochila>();
        
        populacaoFeixe = (ArrayList<Mochila>)populacaoInicial.clone();
        
        for (int i = 0; i < geracoes; i++) {//Gerações
            
            for (int j = 0; j < tamanhoPopulacao; j++) {//Gerando Vizinhos
                
                ArrayList<Mochila> vizinhos = vizinhos(populacaoFeixe.get(j));
                for(Mochila mochila : vizinhos){
                    populacaoFeixe.add(mochila);                    
                }
                vizinhos = new ArrayList<Mochila>();
            }
            //CHAMA O DARVI
           populacaoFeixe = Darwin.atualizaPopulacao(populacaoFeixe, tamanhoPopulacao);
           
           //Quando só tiver soluções iguais ele para
           
           
        }
        
        return populacaoFeixe;
    }
    
    public ArrayList<Mochila> vizinhos(Mochila mochilaA){
        Algoritmo alg = new Algoritmo();
        ArrayList <Mochila> vizinhos  = new ArrayList<Mochila>();
        
        Mochila mochila = (Mochila) mochilaA.clone();

//        mochila.imprimeMochila();

        Mochila mochilaAux = new Mochila();
        
        //vizinho superior (x+1) -> O ultimo elemento da solução recebe o proximo da estante
        for (int i = 0; i < mochila.getSolucao().size() -1 ; i++) {
            mochilaAux.getSolucao().add(mochila.getSolucao().get(i+1));                       
        }
        mochilaAux.getSolucao().add(mochila.getSolucao().get(0));
        
        //vizinho inferior (x-1) -> O primeiro elemento da solução recebe o ultimo da estante
        mochilaAux.atualizaMochila();
//        vizinhos.add(alg.clonaMochila(mochilaAux));
        vizinhos.add((Mochila)mochilaAux.clone());
        
        
        mochilaAux = new Mochila();
        mochilaAux.getSolucao().add(mochila.getSolucao().get(27));
        
        for (int i = 0; i < mochila.getSolucao().size()-1 ; i++) {
            mochilaAux.getSolucao().add(mochila.getSolucao().get(i));
        }
//        vizinhos.add(alg.clonaMochila(mochilaAux));
         mochilaAux.atualizaMochila();
         vizinhos.add((Mochila)mochilaAux.clone());
        
        
//        System.out.println("Mochila original: ");
//        mochila.imprimeMochila();
//        System.out.println("Vizinho superior: ");
//       
//        vizinhos.get(1).imprimeMochila();
//        System.out.println("Vizinho Inferior: ");
//        
//        vizinhos.get(0).imprimeMochila();
       
        
        
        return vizinhos;
    
    }
    
    public boolean soTemNegoIgual(ArrayList<Mochila> populacao){
        
        
        
        return false;
    }
}
