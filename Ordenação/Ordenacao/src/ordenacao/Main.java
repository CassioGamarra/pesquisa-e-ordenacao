/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao;

import java.util.ArrayList;

/**
 *
 * @author cassio
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> vetor = new ArrayList();
        ArrayList<Integer> vetorA = new ArrayList();
        ArrayList<Integer> vetorB = new ArrayList();
        ArrayList<Integer> vetorC = new ArrayList();
        ArrayList<Integer> vetorD = new ArrayList();
        ArrayList<Integer> vetorE = new ArrayList();
        Ordenacao.popula(100, vetor);
        for(int i = 0; i < vetor.size();i++){
            vetorA.add(vetor.get(i));
            vetorB.add(vetor.get(i));
            vetorC.add(vetor.get(i));
            vetorD.add(vetor.get(i));
            vetorE.add(vetor.get(i));
        }
        
        long tempoInicial, tempoFinal;
        
        System.out.println("Vetor com Selection Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.selecao(vetorA);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+" ms");
        
        System.out.println("Vetor com Insertion Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.insercao(vetorB);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+ " ms");
        
        System.out.println("Vetor com Bubble Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.bolha(vetorC);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+ " ms");
        
        System.out.println("Vetor com Shake Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.shakeSort(vetorD);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+ " ms");
        
        System.out.println("Vetor com Comb Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.pente(vetorE);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+ " ms");
    }
}
