package exemploheap;

import java.util.ArrayList;
import java.util.Random;
/**
 * Dois métodos solicitados em aula
 * Esta em Heap
 * Colocar em Heap
 * @author cassio
 */
public class Metodos {
    
    //Método para popular o ArrayList
    public static void popular(int quantidade, ArrayList vetor){
        Random gerador = new Random();
        for(int i = 0; i < quantidade; i++){
            vetor.add(gerador.nextInt(1000));
        }
    }
    //Método para exibir o arraylist
    public static void exibir(ArrayList vetor){
        
        for(int i = 0; i < vetor.size(); i++){
            System.out.println(vetor.get(i));
        }
    }
    
    public static boolean estaEmHeap(ArrayList<Integer> vetor){
        int i;
        for(i = 1; (i*2) <= vetor.size(); i++){
            if((vetor.get(i) < vetor.get(i*2))||
                    (((i*2)+1 <= vetor.size())&&(vetor.get(i) < vetor.get((i*2)+1)))){
            
            }
            return false;
        }
        return true;
    }
    
    public static void colocarEmHeap(ArrayList<Integer> vetor){
        int i;
        boolean houveTroca;
        
        do{
            houveTroca = false;
            for(i = 1; (i*2) <= vetor.size();i++){
                //Filho da esquerda
                if(vetor.get(i) <= vetor.get(i*2)){
                    houveTroca = true;
                    //Método troca
                    troca(vetor, i, i*2);
                }
                //Filho da direita
                if(((i*2)+1 < vetor.size())&&(vetor.get(i) < vetor.get((i*2)+1))){
                    houveTroca = true;
                    //Método troca
                    troca(vetor, i, i*2);
                }
            }
        }while(houveTroca);
    }
    
    public static void troca(ArrayList<Integer> vetor, int posA, int posB){
        int aux;
        aux = vetor.get(posA);
        vetor.set(posA, vetor.get(posB));
        vetor.set(posB, aux);
    }
}
