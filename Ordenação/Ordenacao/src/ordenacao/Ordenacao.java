
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
         int numTrocas = 0, numComparacoes = 0;
         
         for(i = 0; i < vetor.size() - 1; i++){
             posMenor = i;
             
             for(j = i+1; j < vetor.size(); j++){
                 numComparacoes++;
                 if(vetor.get(j) < vetor.get(posMenor)){
                     posMenor = j;
                 }
             }
             if(i != posMenor){
                 aux = vetor.get(i);
                 vetor.set(i, vetor.get(posMenor));
                 vetor.set(posMenor, aux);
                 numTrocas++;
             }
         }
         System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
    }
    
    public static void insercao(ArrayList<Integer> vetor){
        int i, j, aux;
        int numTrocas = 0, numComparacoes = 0;
        
        for (i = 1; i < vetor.size(); i++){
            aux = vetor.get(i);
            numComparacoes++;
            for(j = i-1; j >= 0 && aux < vetor.get(j); j--){ 
                numComparacoes++;
                vetor.set(j+1, vetor.get(j));
                numTrocas++;
            }
            
            vetor.set(j+1, aux);
            numTrocas++;
        }
        
        System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
    }
    
    public static void bolha(ArrayList<Integer> vetor){
        int i, aux;
        int numTrocas = 0, numComparacoes = 0;
        boolean troca;
        do{
             troca = false;
             for(i = 0; i < vetor.size() - 1; i++){
                 numComparacoes++;
                 if(vetor.get(i) > vetor.get(i+1)){
                     aux = vetor.get(i);
                     vetor.set(i, vetor.get(i+1));
                     vetor.set(i+1, aux);
                     troca = true;
                     numTrocas++;
                 }
             }
         } while(troca);
        System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
    }
    
    public static void shakeSort(ArrayList<Integer> vetor){
        int i, aux, ini, fim;
        int numTrocas = 0, numComparacoes = 0;
        ini = 0;
        fim = vetor.size() - 1;
        boolean houveTroca;
        
        do{
            houveTroca = false;
            for(i = ini; i < fim; i++){
                numComparacoes++;
                if(vetor.get(i) > vetor.get(i+1)){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i+1));
                    vetor.set(i+1, aux);
                    houveTroca = true;
                    numTrocas++;
                }
            }
            fim--;
            if(!houveTroca) break;
            
            houveTroca = false;
            
            for(i  = fim; i > ini; i--){
                numComparacoes++;
                if(vetor.get(i) < vetor.get(i-1)){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i-1));
                    vetor.set(i-1, aux);
                    houveTroca = true;
                    numTrocas++;
                }
            }
            ini++;
        }while(houveTroca  && fim > ini);
        System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
    }
    
    public static void pente(ArrayList<Integer> vetor){
        int i, distancia, aux;
        int numTrocas = 0, numComparacoes = 0;
        boolean houveTroca;
        
        distancia = vetor.size();
        
        do{
            distancia = (int) (distancia / 1.3);
            if(distancia < 1) distancia = 1; //Vira bolha
            houveTroca = false;
            for(i = 0; i + distancia < vetor.size(); i++){
                numComparacoes++;
                if(vetor.get(i) > vetor.get(i+distancia)){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i + distancia));
                    vetor.set(i+distancia, aux);
                    houveTroca = true;
                    numTrocas++;
                }
            }
        }while(distancia > 1 || houveTroca);
        
        System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
    }
}
