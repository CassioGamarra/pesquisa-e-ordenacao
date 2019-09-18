import java.util.ArrayList;

/**
 * 
 * @author Cássio Gamarra & Frederico Hartmann
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> vetorPessoa = new ArrayList<>();
        
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
        
        //Método que ordena o vetor
        Ordenacao.bolha(vetorPessoa);
        //Exibindo ordenado
        System.out.println("Com ordenação:");
        Ordenacao.exibir(vetorPessoa);
    }
    
}
