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
    
    public Mochila algoritmoGenetico(ArrayList<Mochila> populacaoInicial, int geracoes, int tamanhoPopulacao){
        

        ArrayList<Mochila> populacaoAlgGen = (ArrayList<Mochila>)populacaoInicial.clone();
        Mochila solucao = new Mochila();

        //Calcular probabilidades
        calculaProbabilidadesPopulacao(populacaoInicial);        
        
        //Girar a roleta para montar os casais || Definir quantos casais?!?!?!
        ArrayList<Mochila> casal = new ArrayList<>();
        for (int i = 0; i < geracoes; i++) {         
            
            for (int j = 0; j < tamanhoPopulacao/2; j++) {
                System.out.println("Casal "+(j+1)+" :");
                casal = new ArrayList<>();
                for (int k = 0; k < 2; k++) {
                    casal.add((Mochila) populacaoInicial.get(k).clone());
//                    System.out.println("Membro "+(k+1)+" do casal: ");
//                    System.out.println(casal.get(k).getProbabilidade() + " - " + casal.get(k).getRoleta());

                    for (int l = 0; l < 2; l++) {
                        casal.add((Mochila)roleta(populacaoInicial).clone());
//                        System.out.println("Membro "+(l+1)+" do casal: ");
//                        System.out.println(casal.get(l).getProbabilidade() + " - " + casal.get(l).getRoleta());

                    }
                    //Mandar as mochilas cruzarem aumentando a população
                    //Funcao PMX que retona dois filhos a partir do casal
                    PMX(casal);

                }
            }
        }
        //Recalcular as probabilidades
        
        //Girar a roleta pra ver quem sobrevive à essa geração
        
        return solucao;
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
        chosenOne = (Mochila)populacao.get(0).clone();
        
        return chosenOne;
    }
    ArrayList<Mochila> PMX (ArrayList<Mochila> casal){
        
        
        ArrayList<Mochila> filhos = new ArrayList<>();
        int pontoCross = 0;
        int tamPMX = 0;
        int aux1[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int aux2[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                        -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        
//        filhos.add((Mochila) casal.get(0).clone()); //pai
//        filhos.add((Mochila) casal.get(1).clone()); //mae
        filhos.add(new Mochila());
        filhos.add(new Mochila());
//        casal.get(0).imprimeMochila();
//        casal.get(1).imprimeMochila();
        if(algoritmo.maior(casal.get(0).getMochilaCheia(), casal.get(1).getMochilaCheia())){
            
            tamPMX = casal.get(0).getMochilaCheia()/2;

        }else{
            tamPMX = casal.get(1).getMochilaCheia()/2;
        }
        pontoCross = tamPMX;

        for (int i = 0; i < tamPMX; i++) {
            //preenchendo as equivalencias iniciais

            aux1[casal.get(0).getSolucao().get(i).getId()] = casal.get(1).getSolucao().get(i).getId(); 
//            System.out.println("Aux["+casal.get(0).getSolucao().get(i).getId()+"] = "+aux1[casal.get(0).getSolucao().get(i).getId()]);
            aux2[casal.get(1).getSolucao().get(i).getId()] = casal.get(0).getSolucao().get(i).getId(); 
//            System.out.println("Aux2["+casal.get(1).getSolucao().get(i).getId()+"] = "+aux2[casal.get(1).getSolucao().get(i).getId()]);
            
        }
//        System.out.println("Aux1:");
//        for (int i = 0; i < aux1.length; i++) {
//            System.out.print("\t"+aux1[i]+" ");
//        }
//        System.out.println("");
//        System.out.println("Aux2:");
//        for (int i = 0; i < aux2.length; i++) {
//            System.out.print("\t"+aux2[i]+" ");           
//        }
        for (int i = 0; i <tamPMX ; i++) {

            filhos.get(1).getSolucao().add(casal.get(1).getSolucao().get(i));
            filhos.get(0).getSolucao().add(casal.get(0).getSolucao().get(i));      
        }

//        for (int i = 0; i <pontoCross ; i++) {
//
//            filhos.get(0).getSolucao().add(casal.get(0).getSolucao().get(podeTrocar(i, aux1)));
//            filhos.get(1).getSolucao().add(casal.get(1).getSolucao().get(podeTrocar(i, aux2)));  
//        }

        for (int i =tamPMX; i <casal.get(0).getSolucao().size() ; i++) {
                filhos.get(0).getSolucao().add(casal.get(1).
                        getItemSolucaoById(podeTrocar(casal.get(1).getSolucao().get(i).getId(), aux1)));
                filhos.get(1).getSolucao().add(casal.get(0).
                        getItemSolucaoById(podeTrocar(casal.get(0).getSolucao().get(i).getId(), aux2)));
  
     
                
        }
        
        for(Mochila filho : filhos){
            System.out.println("FILHO:");
            filho.atualizaMochila();
         //   filho.imprimeMochila();
            filho.temGenteIgual(filho);
        }

        
        return filhos;
    }
    
    int podeTrocar(int id, int[]aux){
        if(aux[id]== -1){
            return id;
        }
        else{
            return podeTrocar(aux[id], aux);
            
        }
    
        
    }
}
