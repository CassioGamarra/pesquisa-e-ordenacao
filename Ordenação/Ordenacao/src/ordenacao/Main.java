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
        Ordenacao.popula(50, vetor);
        Ordenacao.exibir(vetor);
    }
}
