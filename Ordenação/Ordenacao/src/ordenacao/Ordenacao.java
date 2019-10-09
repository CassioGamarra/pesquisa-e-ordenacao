package ordenacao;

import java.util.ArrayList;
import java.util.Random;
import view.ViewPrincipal;

/**
 * ID's: Tempo = 0 // Comparações = 1 // Trocas = 2
 * @author cassio
 */
public class Ordenacao {
    
    public Ordenacao(){}
    
    //Arrays com os comparativos
    public final static ArrayList<String> trocas = new ArrayList<>();
    public final static ArrayList<String> comparacoes = new ArrayList<>();  
    public final static ArrayList<String> tempos = new ArrayList<>();
    
    public void compararMetodos(ViewPrincipal view){
        int quantidade = Integer.parseInt(view.getFieldQtd().getText());
        ArrayList<Integer> vetor = new ArrayList<>();
        
        tempos.clear();
        trocas.clear();
        comparacoes.clear();
        
        popular(quantidade, vetor);
        //Valores de tempo inicial e final
        long tempoInicial, tempoFinal;
        //Valores de tempo dos métodos
        long tempoSelection, tempoInsertion, tempoBubble, tempoShake, tempoComb, tempoShell;
        
        if(view.getCheckSelection().isSelected()){
            ArrayList<Integer> selection = new ArrayList<>();
            clonar(vetor, selection);
            
            //Exibindo resultado
            System.out.println("Vetor com Selection Sort: ");
            tempoInicial = System.currentTimeMillis();
            selecao(selection);
            tempoFinal = System.currentTimeMillis();
            tempoSelection = tempoFinal-tempoInicial;
            
            tempos.add(String.valueOf(tempoSelection));
            System.out.println("Tempo = "+tempoSelection+" ms");
        }
        else{
            tempos.add("X");
            trocas.add("X");
            comparacoes.add("X");
        }
        if(view.getCheckInsertion().isSelected()){
            ArrayList<Integer> insertion = new ArrayList<>();
            clonar(vetor, insertion);
            
            //Exibindo resultado
            System.out.println("Vetor com Insertion Sort: ");
            tempoInicial = System.currentTimeMillis();
            Ordenacao.insercao(insertion);
            tempoFinal = System.currentTimeMillis();
            tempoInsertion = tempoFinal-tempoInicial;
            
            tempos.add(String.valueOf(tempoInsertion));
            System.out.println("Tempo = "+tempoInsertion+ " ms");
        }
        else{
            tempos.add("X");
            trocas.add("X");
            comparacoes.add("X");
        }
        if(view.getCheckBubble().isSelected()){
            ArrayList<Integer> bubble = new ArrayList<>();
            clonar(vetor, bubble);
            
            //Exibindo resultado
            System.out.println("Vetor com Bubble Sort: ");
            tempoInicial = System.currentTimeMillis();
            Ordenacao.bolha(bubble);
            tempoFinal = System.currentTimeMillis();
            tempoBubble = tempoFinal-tempoInicial;
            
            tempos.add(String.valueOf(tempoBubble));
            System.out.println("Tempo = "+tempoBubble+ " ms");
        }
        else{
            tempos.add("X");
            trocas.add("X");
            comparacoes.add("X");
        }
        if(view.getCheckShake().isSelected()){
            ArrayList<Integer> shake = new ArrayList<>();
            clonar(vetor, shake);
            
            //Exibindo resultado
            System.out.println("Vetor com Shake Sort: ");
            tempoInicial = System.currentTimeMillis();
            Ordenacao.agitacao(shake);
            tempoFinal = System.currentTimeMillis();
            tempoShake = tempoFinal-tempoInicial;
            
            tempos.add(String.valueOf(tempoShake)); 
            System.out.println("Tempo = "+tempoShake+ " ms");
        } 
        else{
            tempos.add("X");
            trocas.add("X");
            comparacoes.add("X");
        }
        if(view.getCheckComb().isSelected()){
            ArrayList<Integer> comb = new ArrayList<>();
            clonar(vetor, comb);
            
            //Exibindo resultado
            System.out.println("Vetor com Comb Sort: ");
            tempoInicial = System.currentTimeMillis();
            Ordenacao.pente(comb);
            tempoFinal = System.currentTimeMillis();
            tempoComb = tempoFinal-tempoInicial;
            
            tempos.add(String.valueOf(tempoComb));
            System.out.println("Tempo = "+tempoComb+ " ms");
        }
        else{
            tempos.add("X");
            trocas.add("X");
            comparacoes.add("X");
        }
        if(view.getCheckShell().isSelected()){
            ArrayList<Integer> shell = new ArrayList<>();
            clonar(vetor, shell);
            
            //Exibindo resultado
            System.out.println("Vetor com Shell Sort: ");
            tempoInicial = System.currentTimeMillis();
            Ordenacao.shellSort(shell);
            tempoFinal = System.currentTimeMillis();
            tempoShell = tempoFinal-tempoInicial;
            
            tempos.add(String.valueOf(tempoShell));
            System.out.println("Tempo = "+tempoShell+ " ms");
        }
        else{
            tempos.add("X");
            trocas.add("X");
            comparacoes.add("X");
        }
        System.out.println(tempos);
        System.out.println(comparacoes);
        System.out.println(trocas);
        
    }
    
    //Método para popular o ArrayList
    public static void popular(int quantidade, ArrayList vetor){
        Random gerador = new Random();
        for(int i = 0; i < quantidade; i++){
            vetor.add(gerador.nextInt(1000));
        }
    }
    
    //Método para clonar o ArrayList
    public static void clonar(ArrayList vetorOrigem, ArrayList vetorDestino){
        for(int i = 0; i < vetorOrigem.size();i++){
            vetorDestino.add(vetorOrigem.get(i));
        }
    }
    
    public static void exibir(ArrayList vetor){
        
        for(int i = 0; i < vetor.size(); i++){
            System.out.println(vetor.get(i));
        }
    }
    
    //Métodos de ordenação
    
    //Seleção
    public static void selecao(ArrayList<Integer> vetor){
         int i, j, posMenor, aux;
         long numTrocas = 0, numComparacoes = 0;
         
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
         trocas.add(String.valueOf(numTrocas));
         comparacoes.add(String.valueOf(numComparacoes));
    }
    
    //Inserção
    public static void insercao(ArrayList<Integer> vetor){
        int i, j, aux;
        long numTrocas = 0, numComparacoes = 0;
        
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
        trocas.add(String.valueOf(numTrocas));
        comparacoes.add(String.valueOf(numComparacoes));
    }
    
    //Bolha
    public static void bolha(ArrayList<Integer> vetor){
        int i, aux;
        long numTrocas = 0, numComparacoes = 0;
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
        trocas.add(String.valueOf(numTrocas));
        comparacoes.add(String.valueOf(numComparacoes));
    }
    
    //Agitação
    public static void agitacao(ArrayList<Integer> vetor){
        int i, aux, ini, fim;
        long numTrocas = 0, numComparacoes = 0;
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
        trocas.add(String.valueOf(numTrocas));
        comparacoes.add(String.valueOf(numComparacoes));
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
        
        System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
        trocas.add(String.valueOf(numTrocas));
        comparacoes.add(String.valueOf(numComparacoes));
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
        System.out.println("Número de comparações: "+numComparacoes+" Número de trocas: "+numTrocas);
        trocas.add(String.valueOf(numTrocas));
        comparacoes.add(String.valueOf(numComparacoes));
    }
    
    //Necessário implementar
    public static void mergeSort(ArrayList<Integer> vetor){
    
    }
    
    //Métodos auxiliares
    
    //Método auxiliar do Merge Sort
    public static void intercala(ArrayList<Integer> vetor){
        int meio;
        int i, j, k;
        long numTrocas = 0, numComparacoes = 0;
        
        ArrayList<Integer> vetorTmp = new ArrayList<>();
        
        meio = vetor.size() / 2;
        
        i = 0; //Indice porção esquerda
        j =  meio; //Indice da porção da direita
        k = 0; //Indice do vetor temporario
        
        while(i < meio  && j < vetor.size()){
            numComparacoes++;
            //Elemento da porção esquerda
            if(vetor.get(i) < vetor.get(j)){
                vetorTmp.set(j, vetor.get(i));
            }
            //Elemento da porção direita
            else{
                vetorTmp.set(k, vetor.get(j));
            }
            k++;
            numTrocas++;
        }
        
        if(i == meio){
            while(j < vetor.size()){
                vetorTmp.set(k, vetor.get(j));
                j++;
                k++;
                numTrocas++;
            }
        }
        else{
            while(i < meio){
                vetorTmp.set(k, vetor.get(i));
                i++;
                k++;
                numTrocas++;
            }
        }
        
        for(i = 0; i < vetor.size(); i++){
            vetor.set(i, vetorTmp.get(i));
        }
        
        vetorTmp.clear();
    }
}
