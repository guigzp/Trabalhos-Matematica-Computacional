/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosmc;

/**
 *
 * @author guiza
 */
public class TrabalhosMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaylorCheby teste = new TaylorCheby();
        Foguete nasa = new Foguete();
        
        for(int i =-8; i < 9; i++){
            //System.out.println("Cheby para: " + i * Math.PI/4 + " = " + teste.reducaoArgumentoCheby(i * Math.PI/4));
            //System.out.println("Taylor para: " + i * Math.PI/4 + " = " + teste.reducaoArgumentoTaylor(i * Math.PI/4));
           // System.out.println("Função seno tradicional para " + i * Math.PI/4 + " = " + Math.sin(i * Math.PI/4));
            //System.out.println("");
            //System.out.println(i * Math.PI/4);
            long tempo = System.nanoTime();
            double calculado = teste.reducaoArgumentoTaylor(i * Math.PI/4);
            System.out.println(System.nanoTime() - tempo);
           
        }
    }
    
}
