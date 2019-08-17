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
        ArrayList<Integer> vetorA = new ArrayList();
        ArrayList<Integer> vetorB = new ArrayList();
        ArrayList<Integer> vetorC = new ArrayList();
        Ordenacao.popula(10, vetorA);
        Ordenacao.popula(10, vetorB);
        Ordenacao.popula(10, vetorC);
        long tempoInicial, tempoFinal;

       
        System.out.println("Vetor com Selection Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.selecao(vetorA);
        tempoFinal = System.currentTimeMillis();
        Ordenacao.exibir(vetorA);
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+" ms");
        
        System.out.println("Vetor com Insertion Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.insercao(vetorB);
        tempoFinal = System.currentTimeMillis();
        Ordenacao.exibir(vetorB);
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+ " ms");
        
        System.out.println("Vetor com Bubble Sort: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.bolha(vetorC);
        tempoFinal = System.currentTimeMillis();
        Ordenacao.exibir(vetorC);
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+ " ms");
    }
}
