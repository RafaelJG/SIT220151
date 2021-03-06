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
        ArrayList<Mochila> jonathan = (ArrayList<Mochila>)populacaoInicial.clone();
        Mochila solucao = new Mochila();

        //Calcular probabilidades
        calculaProbabilidadesPopulacao(populacaoAlgGen);        
        
        //Girar a roleta para montar os casais || Definir quantos casais?!?!?!
        ArrayList<Mochila> casal;
        
        for (int i = 0; i < geracoes; i++) { //FOR gerações
             populacaoAlgGen = new ArrayList<Mochila>();
            populacaoAlgGen = (ArrayList<Mochila>)jonathan.clone();
            
            
            for (int j = 0; j < tamanhoPopulacao; j++) {//FOR percorre populacao
                
//                System.out.println("Casal "+(j+1)+" :");
                casal = new ArrayList<>();
                
                casal.add((Mochila)roleta(populacaoAlgGen).clone()); //Pai 
                casal.add((Mochila)roleta(populacaoAlgGen).clone()); // Mae
                
                ArrayList<Mochila> filhos = PMX(casal);
                
                for(Mochila mochila : filhos){
                    
                    populacaoAlgGen.add((Mochila) mochila.clone());
                }
                
            }
            
            calculaProbabilidadesPopulacao(populacaoAlgGen);
            //No final da Geração a populacao esta com o dobro de individuos

            for (int j = 0; j < tamanhoPopulacao; j++) {
                jonathan.add((Mochila)roleta(populacaoAlgGen).clone());
            }
           
            calculaProbabilidadesPopulacao(jonathan);            
        }
        
        Darwin.atualizaPopulacao(jonathan, tamanhoPopulacao);
        
        return (Mochila)populacaoAlgGen.get(0).clone();
    }
    
    public void calculaProbabilidadesPopulacao(ArrayList<Mochila> populacao){
        double fitnessTotal = 0;
        
        for(Mochila mochila : populacao){
           fitnessTotal += mochila.getValor();
        }

        for(Mochila mochila : populacao){
            mochila.setProbabilidade((mochila.getValor()/fitnessTotal));
        }
    }
    
    public Mochila roleta(ArrayList<Mochila> populacao){
//        Mochila chosenOne = new Mochila();        
        double random;        
        Random gerador = new Random();        
        
        random = gerador.nextDouble(); //Número ramdom entre 0 e 1
        
        //Organiza a populacao da maior probabilidade para a menor.
        Collections.sort(populacao, new ComparadorRoleta());
        
        for (int i = 0; i < populacao.size(); i++) {
            
            //Checar o primeiro
            
            if(i == 0){
                if(random > populacao.get(i).getProbabilidade() &&
                   random <= 1){
                    return (Mochila) populacao.get(i).clone();
                }
            }            
            if(i == populacao.size()-1){//Ultimo individuo da populacao e com menor probabilidade
                if(random < populacao.get(i).getProbabilidade() &&
                   random >= 0){
                    return (Mochila)populacao.get(i).clone();
                }
            }
            else{
                if(populacao.get(i).getProbabilidade() > random && 
                   populacao.get(i+1).getProbabilidade() < random){
                    return (Mochila) populacao.get(i).clone();
                }
            }
        }
        
        return null;
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
//            System.out.println("FILHO:");
            filho.mutacao();
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
