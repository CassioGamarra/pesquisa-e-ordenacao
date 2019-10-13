
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe com os métodos 
 * @author cassio
 */
public class Metodos {
    
    public Metodos(){}
    
    //Método para clonar o ArrayList
    public static void clonar(ArrayList vetorOrigem, ArrayList vetorDestino){
        for(int i = 0; i < vetorOrigem.size();i++){
            vetorDestino.add(vetorOrigem.get(i));
        }
    }
    
    //Método para popular o ArrayList
    public static void popular(int quantidade, ArrayList vetor){
        Random gerador = new Random();
        for(int i = 0; i < quantidade; i++){
            vetor.add(gerador.nextInt(10000));
        }
    }
    
    //Método para exibir o ArrayList
    public static void exibir(ArrayList vetor){
        for(int i = 0; i < vetor.size(); i++){
            System.out.println(vetor.get(i));
        }
    }
    
    //Pente
    public static void pente(ArrayList<Integer> vetor){
        int i, distancia, aux;
        long numTrocas = 0, numComparacoes = 0;
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

    }
    
    //Shell
    public static void shellSort(ArrayList<Integer> vetor){
        int i, j, aux, distancia = 1;
        long numTrocas = 0, numComparacoes = 0;
        
        do{
            distancia = 3 * distancia + 1;
        }while(distancia < vetor.size());
        
        do{
            distancia = (int) distancia/ 3;
            for(i =  distancia; i < vetor.size(); i++){
                aux = vetor.get(i);
                numComparacoes++;
                for(j =  i - distancia; j >= 0 && aux < vetor.get(j); j =  j - distancia){
                    vetor.set(j+distancia, vetor.get(j));
                }
                vetor.set(j+distancia, aux);
                numTrocas++;
            }
        }while(distancia > 1);

    }
    
    
    //MÉTODOS DE BUSCA
    
    //Busca sequencial
    public static long buscaSequencial(int valor, ArrayList<Integer> vetor){
        
        for(int i = 0; i < vetor.size(); i++){
            if(valor == vetor.get(i)){
                return i;
            }
        }
        
        return -1;
    }
    
    //Busca binária
    public static long buscaBinaria(int valor, ArrayList<Integer> vetor){
        int ini = 0, fim = vetor.size() - 1, meio;
        
        while(ini <= fim){
            meio = (int) (ini+fim)/2;
            if(valor == vetor.get(meio)) return meio;
            if(valor < vetor.get(meio)){
                fim = meio - 1;
            }
            else{
                ini = meio + 1;
            }
        }
        
        return -1;
    }
}
