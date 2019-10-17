
import javax.swing.JOptionPane;

/**
 * Exemplo Pesquisa Digital
 * @author cassio
 */
public class Principal {
    
    public static void main(String[] args) {        
        String mensagem, palavra;
        mensagem = JOptionPane.showInputDialog("Digite uma frase: ");
        
        palavra = JOptionPane.showInputDialog(mensagem+"\nDigite uma palavra para buscar: ");
        
        if(estaNaFrase(palavra, mensagem)){    
            JOptionPane.showMessageDialog(null, "SIM!", "Está na frase?", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "NÃO!", "Está na frase?", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static boolean estaNaFrase(String palavra, String frase){
        if(frase.contains(palavra)){
            return true;
        }
        return false;
    }
}
