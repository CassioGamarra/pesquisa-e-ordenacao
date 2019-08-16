
package ordenacao;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cassio
 */
public class Ordenacao {
    
    public static void popula(int quantidade, ArrayList vetor){
        Random gerador = new Random();
        for(int i = 0; i < quantidade; i++){
            vetor.add(gerador.nextInt(1000));
        }
    }
    
    public static void exibir(ArrayList vetor){
        
        for(int i = 0; i < vetor.size(); i++){
            System.out.println(vetor.get(i));
        }
    }
    
    public static void selecao(ArrayList<Integer> vetor){
         int i, j, posMenor, aux;
         
         for(i = 0; i < vetor.size() - 1; i++){
             posMenor = i;
             
             for(j = i+1; j < vetor.size(); j++){
                 if(vetor.get(j) < vetor.get(posMenor)){
                     posMenor = j;
                 }
             }
             if(i != posMenor){
                 aux = vetor.get(i);
                 vetor.set(i, vetor.get(posMenor));
                 vetor.set(posMenor, aux);
                 
             }
         }
    }
    
    public static void insercao(ArrayList<Integer> vetor){
        int i, j, aux;
        
        for (i = 1; i < vetor.size(); i++){
            aux = vetor.get(i);
            for(j = i-1; j >= 0 && aux < vetor.get(j); j--){
                vetor.set(j+1, vetor.get(j));
            }
            vetor.set(j+1, aux);
        }
    }
    
    public static void bolha(ArrayList<Integer> vetor){
     
    }
}
