
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe principal que chama os métodos de ordenação e pesquisa
 * @author cassio
 */
public class Principal {
    public static void main(String[] args) {
        //Valores de tempo inicial e final
        long tempoInicial, tempoFinal, tempoSequencial, tempoBinaria;
        String resultSequencial, resultBinaria;
        long posicaoSeq, posicaoBin;
        
        ArrayList<Integer> vetor = new ArrayList<>();
        Metodos.popular(1000000, vetor);        
        
        //Busca sequencial
        int valor;
        valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor para pesquisa sequencial: "));
        tempoInicial = System.currentTimeMillis();
        posicaoSeq = Metodos.buscaSequencial(valor, vetor);
        tempoFinal = System.currentTimeMillis();
        tempoSequencial = tempoFinal-tempoInicial;
        resultSequencial = "Posição: "+posicaoSeq+"\nTempo: "+tempoSequencial+"ms";
        JOptionPane.showMessageDialog(null, resultSequencial);
        
        //Busca binaria
        
        
        valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor para pesquisa binaria: "));
        Metodos.pente(vetor);
        tempoInicial = System.currentTimeMillis();
        
        //
        posicaoBin = Metodos.buscaBinaria(valor, vetor);
        tempoFinal = System.currentTimeMillis();
        tempoBinaria = tempoFinal-tempoInicial;
        resultBinaria = "Posição: "+posicaoBin+"\nTempo: "+tempoBinaria+"ms";
        JOptionPane.showMessageDialog(null, resultBinaria);
        
    }
}
