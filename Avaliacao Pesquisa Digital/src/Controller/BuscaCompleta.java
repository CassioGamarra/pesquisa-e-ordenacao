package Controller;

import View.ViewCompleta;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * Classe com métodos para busca em 
 * @author cassio
 */
public class BuscaCompleta {
    public BuscaCompleta(){}
   
    public void buscar(ViewCompleta view){
        
        //Recebe as variaveis
        String texto = view.getFieldTextoEntrada().getText();
        String palavra = view.getFieldBusca().getText();
        int tamPalavra = palavra.length();
        int i = 0;
        int index;
        
        //Adiciona os valores para o resultado
        view.getFieldResultado().setText(texto);
        //Aqui busca as ocorrências da palavra
        ArrayList<Integer> posicoes = new ArrayList<>();
        //Remove o case sensitive
        texto = texto.toUpperCase();
        palavra =  palavra.toUpperCase();
        do{
            index = texto.indexOf(palavra, i);
            if(index >= 0){
                posicoes.add(index);
            }
            i = texto.indexOf(palavra, i) + tamPalavra;
        }while(index >= 0);
        
        for(i = 0; i < posicoes.size(); i++){
            destacarTexto(posicoes.get(i), tamPalavra, view.documento, Color.RED);
        }
    }
    
    private static void destacarTexto(int ini, int tam, StyledDocument documento, Color cor) {  
        try {
            StyleContext contexto = StyleContext.getDefaultStyleContext();  
            AttributeSet estilo = contexto.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, cor);  
            /*Pinta o texto com os parâmetros:
            * posição do texto, tamanho do texto e o estilo criado 
            */
            documento.setCharacterAttributes(ini, tam, estilo, true);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    } 
}
