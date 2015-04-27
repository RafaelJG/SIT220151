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
    
    public ArrayList<Mochila> buscaEmFeixe(ArrayList<Mochila> populacaoInicial, int geracoes){
        ArrayList<Mochila> populacaoFeixe = new ArrayList<Mochila>();
        
        
        for (int i = 0; i < geracoes; i++) {//Gerações
            for (int j = 0; j < populacaoInicial.size(); j++) {//Gerando Vizinhos
                populacaoFeixe.add(populacaoInicial.get(j));//Adiciona 
                
                ArrayList<Mochila> vizinhos = vizinhos(populacaoInicial.get(j));
                for(Mochila mochila : vizinhos){
                    populacaoFeixe.add(mochila);
                }
            }
        }
        
        return populacaoFeixe;
    }
    
    public ArrayList<Mochila> vizinhos(Mochila mochila){
        Algoritmo alg = new Algoritmo();
        ArrayList <Mochila> vizinhos  = new ArrayList<Mochila>();
               
        Mochila mochilaAux = new Mochila();
        //vizinho superior (x+1) -> O ultimo elemento da solução recebe o proximo da estante
        for (int i = 0; i < mochila.getSolucao().size() -1 ; i++) {
            mochilaAux.getSolucao().add(mochila.getSolucao().get(i+1));                       
        }
        mochilaAux.getSolucao().add(mochila.getSolucao().get(0));
        
        //vizinho inferior (x-1) -> O primeiro elemento da solução recebe o ultimo da estante
       
        vizinhos.add(alg.clonaMochila(mochilaAux));
        vizinhos.get(0).atualizaMochila();
        
        mochilaAux = new Mochila();
        mochilaAux.getSolucao().add(mochila.getSolucao().get(27));
        for (int i = 0; i < mochila.getSolucao().size() -2 ; i++) {
            mochilaAux.getSolucao().add(mochila.getSolucao().get(i+1));                       
        }
        vizinhos.add(alg.clonaMochila(mochilaAux));
         vizinhos.get(1).atualizaMochila();
        
        
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
    
}
