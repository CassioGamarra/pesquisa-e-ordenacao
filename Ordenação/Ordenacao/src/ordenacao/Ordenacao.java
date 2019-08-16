
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
    
    public static void selecao(ArrayList vetor){
         
    }
    
    public static void insercao(ArrayList vetor){
     
    }
    
    public static void bolha(ArrayList vetor){
     
    }
}
