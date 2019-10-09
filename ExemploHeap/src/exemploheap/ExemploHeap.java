/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploheap;

import static exemploheap.Metodos.*;
import java.util.ArrayList;

/**
 *
 * @author cassio
 */
public class ExemploHeap {
    public static ArrayList<Integer> heap = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        popular(100, heap);
        exibir(heap);
        if(estaEmHeap(heap)){
            System.out.println("SIM");
        }
        else{
            System.out.println("NAO");
        }
        colocarEmHeap(heap);
        exibir(heap);
        
    }
    
}
