#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
//Define o tamanho da tabela hash
#define TAM 10

//Estrutura do aluno
typedef struct{
    int idade;
    char nome[100];
} Aluno;

//Estrutura da lista
typedef struct no{
    Aluno pessoa;
    struct no *prox;
} Celula;

//Declaração dos métodos
/*CRUD*/
Celula *inserir(Aluno a, Celula *l);
Celula *pesquisar(/*Escolher a forma*/);
Celula *remover(/*Escolher a forma*/);
/*TABELA HASH*/
void inicializarTabelaHash(Celula *tabela[], int n);
int hash(Aluno a);

/*Inicio do progrma*/
int main(){
    return 1;
}

/*Métodos*/