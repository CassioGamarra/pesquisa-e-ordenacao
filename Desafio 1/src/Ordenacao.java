
import java.util.ArrayList;

/**
 * Métodos para ordenação
 * @author Cássio Gamarra & Frederico Hartmann
 */
public class Ordenacao {
    public Ordenacao(){}
    public static void exibir(ArrayList<Pessoa> vetor){   
        for(int i = 0; i < vetor.size(); i++){
            System.out.println(vetor.get(i).getNome()+" "+vetor.get(i).getIdade());
        }
    }
    //Método para clonar o ArrayList
    public static void clonar(ArrayList vetorOrigem, ArrayList vetorDestino){
        for(int i = 0; i < vetorOrigem.size();i++){
            vetorDestino.add(vetorOrigem.get(i));
        }
    }
    
    //Métodos de ordenação
    public static void bolha(ArrayList<Pessoa> vetor){
        int i;
        long numTrocas = 0, numComparacoes = 0;
        boolean troca;
        Pessoa aux = new Pessoa("", 0);
        do{
             troca = false;
             for(i = 0; i < vetor.size() - 1; i++){
                 numComparacoes++;
                 if(vetor.get(i).getNome().compareTo(vetor.get(i+1).getNome())>0){
                     aux = vetor.get(i);
                     vetor.set(i, vetor.get(i+1));
                     vetor.set(i+1, aux);
                     troca = true;
                     numTrocas++;
                 }
                 
                 else if(vetor.get(i).getNome().compareTo(vetor.get(i+1).getNome()) == 0 && vetor.get(i).getIdade() > vetor.get(i+1).getIdade()){
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
    
    public static void selecao(ArrayList<Pessoa> vetor){
         int i, j, posMenor;
         Pessoa aux = new Pessoa("",0);
         long numTrocas = 0, numComparacoes = 0;
         
         for(i = 0; i < vetor.size() - 1; i++){
             posMenor = i;
             
             for(j = i+1; j < vetor.size(); j++){
                 numComparacoes++;
                 if(vetor.get(j).getNome().compareTo(vetor.get(posMenor).getNome()) < 0){
                     posMenor = j;
                 }
                 else if(vetor.get(j).getNome().compareTo(vetor.get(posMenor).getNome()) == 0
                         && vetor.get(j).getIdade() < vetor.get(posMenor).getIdade()){
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
    
    public static void pente(ArrayList<Pessoa> vetor){
        int i, distancia;
        Pessoa aux = new Pessoa("", 0);
        long numTrocas = 0, numComparacoes = 0;
        boolean houveTroca;
        
        distancia = vetor.size();
        
        do{
            distancia = (int) (distancia / 1.3);
            if(distancia < 1) distancia = 1; //Vira bolha
            houveTroca = false;
            for(i = 0; i + distancia < vetor.size(); i++){
                numComparacoes++;
                if(vetor.get(i).getNome().compareTo(vetor.get(i+distancia).getNome()) > 0){
                    aux = vetor.get(i);
                    vetor.set(i, vetor.get(i + distancia));
                    vetor.set(i+distancia, aux);
                    houveTroca = true;
                    numTrocas++;
                }
                else if(vetor.get(i).getNome().compareTo(vetor.get(i+distancia).getNome()) == 0 
                        && vetor.get(i).getIdade() > vetor.get(i+distancia).getIdade()){
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
