package Controller;

import View.ViewMinima;
import java.util.ArrayList;

/**
 * Classe com métodos para busca em 
 * @author cassio
 */
public class BuscaMinima {
    public BuscaMinima(){}
    
    public static ArrayList<Integer> posicoes = new ArrayList<>();
    
    public void buscar(ViewMinima view){
        estaNoTexto(view.getMinimaFieldBusca().getText(), view.getMinimaAreaTexto().getText());
        System.out.println(posicoes);
    }
    
    public void estaNoTexto(String palavra, String texto){
        int i;

        for(i = 0; texto.indexOf(palavra, i) > 0; ){
            posicoes.add(texto.indexOf(palavra, i));
            i = texto.indexOf(palavra, i+1);
            System.out.println(texto.indexOf(palavra, i));
        }       
    }
}
