/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit220151;

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
        System.out.println("Gerador:");
        Solucionador solucionador = new Solucionador();
        Algoritmo algoritmo = new Algoritmo();
        
        
        for (int i = 0; i <= 0; i++) {
            //System.out.println("Mochila"+i+":");
            algoritmo.PMX(solucionador.gerarSolucao(),solucionador.gerarSolucao());
            
            
        }
        
        
    }
    
}
