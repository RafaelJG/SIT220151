/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author maycowmeira
 */
public class Darwin {    
    public static ArrayList<Mochila> atualizaPopulacao(ArrayList<Mochila> populacao, int tamanho){
        
        Collections.sort(populacao, new ComparadorFitness());
        
        ArrayList<Mochila> populacaoAtualizada = new ArrayList<>();
        
        //tentando usar método do Java para realizar o corte na populacao, se nao der certo usar o for comentado
       // populacaoAtualizada = new ArrayList<Mochila>(populacao.subList(0, tamanho-1));
        
        for (int i = 0; i < tamanho; i++) {
            populacaoAtualizada.add(populacao.get(i));
//            System.out.println("VALOR:"+populacao.get(i).getValor());
        }
        
        return populacaoAtualizada;
    }
}
