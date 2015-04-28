package sit220151;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author maycowmeira
 */
public class AlgGenetico {
    
    public Algoritmo algoritmo = new Algoritmo();
    
    public ArrayList<Mochila> algoritmoGenetico(ArrayList<Mochila> populacaoInicial, int tamanhoPopulacao){
        
        ArrayList<Mochila> populacaoAlgGen = new ArrayList<Mochila>();
        
        //Adicionando a população inicial a final
        for(Mochila mochila : populacaoInicial){
            populacaoAlgGen.add(algoritmo.clonaMochila(mochila));
        }
        
        //Calcular probabilidades
        
        calculaProbabilidadesPopulacao(populacaoInicial);
        
        
        //Girar a roleta para montar os casais || Definir quantos casais?!?!?!
        ArrayList<Mochila> casal = new ArrayList<>();
        for (int i = 0; i < tamanhoPopulacao/2; i++) {
            System.out.println("Casal "+(i+1)+" :");
            casal = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                casal.add(algoritmo.clonaMochila(roleta(populacaoInicial)));
                System.out.println("Membro "+(j+1)+" do casal: ");
                System.out.println(casal.get(j).getProbabilidade() + " - " + casal.get(j).getRoleta());
                
            }
            //Mandar as mochilas cruzarem aumentando a população
            //Funcao PMX que retona dois filhos a partir do casal
            PMX(casal);
            
        }
        
        
        
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
            mochila.setProbabilidade((mochila.getValor()/fitnessTotal));
        }
    }
    
    public Mochila roleta(ArrayList<Mochila> populacao){
        Mochila chosenOne = new Mochila();
        //esse valor "final" é como se fosse o valor de "sovrevivencia" da mochila
        //ja está com o fator aleatório incluído, então os casais escolhidos serão exatamente os com maior valor
        double random;
        Random gerador = new Random();        
        
        for(Mochila mochila : populacao){
            random = gerador.nextDouble()*100;
//            System.out.println("Random: " + random);
            mochila.setRoleta(random * mochila.getProbabilidade());
//            System.out.println("Roleta: " + mochila.getRoleta());
        }
//        System.out.println("Populacao sem ordenar:");
//        for (Mochila mochila : populacao) {
//            System.out.println(mochila.getValor() + " - " + mochila.getRoleta());
//        }
//        
        Collections.sort(populacao, new ComparadorRoleta());
        
//        System.out.println("Populacao ordenada:");
//        for (Mochila mochila : populacao) {
//            System.out.println(mochila.getValor() + " - " + mochila.getRoleta());
//        }
//        
        chosenOne = algoritmo.clonaMochila(populacao.get(0));
        
        return chosenOne;
    }
    ArrayList<Mochila> PMX (ArrayList<Mochila> casal){
        
        
        ArrayList<Mochila> filhos = new ArrayList<>();
        int pontoCross = 0;
        int tamPMX = 0;
        int aux1[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int aux2[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        
        filhos.add(algoritmo.clonaMochila(casal.get(0))); //pai
        filhos.add(algoritmo.clonaMochila(casal.get(1))); //mae
        if(algoritmo.maior(casal.get(0).getMochilaCheia(), casal.get(1).getMochilaCheia())){
            
            tamPMX = casal.get(0).getMochilaCheia()/3;

        }else{
            tamPMX = casal.get(1).getMochilaCheia()/3;
        }
        pontoCross = tamPMX;
        
        for (int i = pontoCross; i < pontoCross+tamPMX; i++) {
            //preenchendo as equivalencias iniciais
            aux1[casal.get(0).getSolucao().get(i).getId()] = casal.get(1).getSolucao().get(i).getId(); 
            aux2[casal.get(1).getSolucao().get(i).getId()] = casal.get(0).getSolucao().get(i).getId(); 
            
        }
//        System.out.println("Aux1:");
//        for (int i = 0; i < aux1.length; i++) {
//            System.out.print("["+i+"]\t"+aux1[i]+" ");
//        }
//        System.out.println("");
//        System.out.println("Aux2:");
//        for (int i = 0; i < aux2.length; i++) {
//            System.out.print("["+i+"]\t"+aux2[i]+" ");           
//        }
 
        
        
        for(Mochila filho : filhos){
            filho.atualizaMochila();
        }

        
        return filhos;
    }
}
