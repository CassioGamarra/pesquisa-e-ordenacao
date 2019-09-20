import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cássio Gamarra & Frederico Hartmann
 */
public class Main {
    
    public static void main(String[] args) {    
        JOptionPane.showMessageDialog(null, "BEM-VINDO!");
        //Vetor principal
        ArrayList<Pessoa> listaAlunos = new ArrayList<>();
        //Vetores dos métodos
        ArrayList<Pessoa> vetorSelecao = new ArrayList<>();
        ArrayList<Pessoa> vetorBolha = new ArrayList<>();
        ArrayList<Pessoa> vetorPente = new ArrayList<>();
        
        String nome;
        int idade, opcao;
        do{
            nome = JOptionPane.showInputDialog(null, "Insira o nome do aluno: ");
            idade = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Insira a idade do aluno: "));
            opcao = JOptionPane.showConfirmDialog(null, 
                    "Deseja continuar cadastrando?");               
            listaAlunos.add(cadastrarAluno(nome, idade));    
        }while(opcao != 1);
        
        //Clonando os vetores                
        Ordenacao.clonar(listaAlunos, vetorSelecao);
        Ordenacao.clonar(listaAlunos, vetorBolha);
        Ordenacao.clonar(listaAlunos, vetorPente);
        
        //Exibindo vetor original sem ordenação
        JOptionPane.showMessageDialog(null, exibir(listaAlunos), "SEM ORDENAÇÃO", 
                JOptionPane.PLAIN_MESSAGE);
        
        //Valores de tempo inicial e final
        long tempoInicial, tempoFinal;

        //Ordenando...            
        JOptionPane.showMessageDialog(null, "Ordenando...");
        //Método que ordena o vetor
        //Seleção
        String selecao = "";
        tempoInicial = System.currentTimeMillis();
        selecao = Ordenacao.selecao(vetorSelecao);
        tempoFinal = System.currentTimeMillis();
        selecao = selecao + "\nTempo = "+(tempoFinal-tempoInicial)+" ms\n";
        
        //Bolha
        String bolha = "";
        tempoInicial = System.currentTimeMillis();
        bolha = Ordenacao.bolha(vetorBolha);
        tempoFinal = System.currentTimeMillis();
        bolha = bolha + "\nTempo = "+(tempoFinal-tempoInicial)+" ms\n";
        
        //Pente
        String pente = "";
        tempoInicial = System.currentTimeMillis();
        pente = Ordenacao.pente(vetorPente);
        tempoFinal = System.currentTimeMillis();
        pente = pente + "\nTempo = "+(tempoFinal-tempoInicial)+" ms\n";
        
        JOptionPane.showMessageDialog(null, "SELEÇÃO:\n"+selecao+exibir(vetorSelecao));
        JOptionPane.showMessageDialog(null, "BOLHA:\n"+bolha+exibir(vetorBolha));
        JOptionPane.showMessageDialog(null, "PENTE:\n"+pente+exibir(vetorPente));
    }
    
    public static Pessoa cadastrarAluno(String nome, int idade){
        Pessoa aluno = new Pessoa("", 0);
        aluno.setNome(nome);
        aluno.setIdade(idade);
        return aluno;
    }
    
    public void ordenar(){
    
    }
    
    public static String exibir(ArrayList<Pessoa> vetor){
        String lista = "";
        for(int i = 0; i < vetor.size(); i++){
            lista = lista + vetor.get(i).getNome()+" "+vetor.get(i).getIdade()+"\n";
        }
        return lista;
    }
}
