package sit220151;

import java.util.ArrayList;

/**
 *
 * @author maycowmeira
 */
public class AlgGenetico {
    
    public ArrayList<Mochila> algoritmoGenetico(ArrayList<Mochila> populacaoInicial, int tamanhoPopulacao){
        
        ArrayList<Mochila> populacaoAlgGen = new ArrayList<Mochila>();
        
        //Calcular probabilidades
        
        //Girar a roleta para montar os casais || Definir quantos casais?!?!?!
        
        //Mandar as mochilas cruzarem aumentando a população
        
        //Recalcular as probabilidades
        
        //Girar a roleta pra ver quem sobrevive à essa geração
        
        return populacaoAlgGen;
        
    }
    
    public void calculaProbabilidadesPopulacao(ArrayList<Mochila> populacao){
        double fitnessTotal = 0;
        for(Mochila mochila : populacao){
           fitnessTotal += mochila.getValor();
        }
        
//        double probabilidade = 0;
        for(Mochila mochila : populacao){
            mochila.setProbabilidade(mochila.getValor()/fitnessTotal);
        }
    }
    
    public ArrayList<Mochila> roleta(ArrayList<Mochila> populacao){
        ArrayList<Mochila> casal = new ArrayList<Mochila>();
        
        int random = 
        
        return casal;
    }
    
}
