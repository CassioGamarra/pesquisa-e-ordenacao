import java.util.ArrayList;

/**
 * 
 * @author Cássio Gamarra & Frederico Hartmann
 */

public class Main {
    public static void main(String[] args) {
        //Valores de tempo inicial e final
        long tempoInicial, tempoFinal;
        
        ArrayList<Pessoa> vetorPessoa = new ArrayList<>();
        ArrayList<Pessoa> vetorSelecao = new ArrayList<>();
        ArrayList<Pessoa> vetorBolha = new ArrayList<>();
        ArrayList<Pessoa> vetorPente = new ArrayList<>();
        
        //Adicionando pessoas do exemplo
        vetorPessoa.add(new Pessoa("alex", 45));
        vetorPessoa.add(new Pessoa("ana", 46));
        vetorPessoa.add(new Pessoa("sylvio", 49));
        vetorPessoa.add(new Pessoa("alex", 54));
        vetorPessoa.add(new Pessoa("ana", 16));
        vetorPessoa.add(new Pessoa("alex", 10));
        vetorPessoa.add(new Pessoa("ana", 10));
        vetorPessoa.add(new Pessoa("sylvio", 12));
       
        //Exibindo sem ordenação
        System.out.println("Sem ordenação:");
        Ordenacao.exibir(vetorPessoa);
        
        //Clonando os vetores
        Ordenacao.clonar(vetorPessoa, vetorSelecao);
        Ordenacao.clonar(vetorPessoa, vetorBolha);
        Ordenacao.clonar(vetorPessoa, vetorPente);
        
        //Método que ordena o vetor
        System.out.println("Seleção: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.selecao(vetorSelecao);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+" ms");
        System.out.println("Bolha: ");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.bolha(vetorBolha);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+" ms");
        System.out.println("Pente:");
        tempoInicial = System.currentTimeMillis();
        Ordenacao.pente(vetorPente);
        tempoFinal = System.currentTimeMillis();
        System.out.println("Tempo = "+(tempoFinal-tempoInicial)+" ms");
        //Exibindo ordenado
        System.out.println("Com ordenação:");
        System.out.println("Seleção: ");
        Ordenacao.exibir(vetorSelecao);
        System.out.println("Bolha: ");
        Ordenacao.exibir(vetorBolha);
        System.out.println("Pente: ");
        Ordenacao.exibir(vetorPente);
    }
}
