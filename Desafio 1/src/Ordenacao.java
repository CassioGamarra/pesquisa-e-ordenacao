
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
    //Método bolha
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
}
