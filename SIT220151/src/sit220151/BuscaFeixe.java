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
    
    
    public ArrayList<Mochila> Vizinhos(Mochila mochila){
        Algoritmo alg = new Algoritmo();
        ArrayList <Mochila> vizinhos  = new ArrayList<Mochila>();
        vizinhos.add(alg.clonaMochila(mochila));
        vizinhos.add(alg.clonaMochila(mochila));
        
        //vizinho superior (x+1) -> O ultimo elemento da solução recebe o proximo da estante
        vizinhos.get(1).getSolucao().set(vizinhos.get(1).getMochilaCheia(), 
                vizinhos.get(1).getSolucao().get(vizinhos.get(1).getMochilaCheia() +1));
        //vizinho inferior (x-1) -> O primeiro elemento da solução recebe o ultimo da estante
        vizinhos.get(0).getSolucao().set(0, vizinhos.get(1).getSolucao().get(vizinhos.get(0).getSolucao().size() -1) );
        System.out.println("Mochila original: ");
        mochila.imprimeMochila();
        System.out.println("Vizinho superior: ");
        vizinhos.get(1).atualizaMochila();
        vizinhos.get(1).imprimeMochila();
        System.out.println("Vizinho Inferior: ");
        vizinhos.get(0).atualizaMochila();
        vizinhos.get(0).imprimeMochila();
        
        
        
        return vizinhos;
    
    }
    
}
