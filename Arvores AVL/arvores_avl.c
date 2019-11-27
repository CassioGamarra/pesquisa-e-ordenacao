/*TAREFA �RVORES AVL - C�SSIO E FREDERICO*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct nodo {
	int dado;
	int fb; //fator de balanceamento
	struct nodo *esq, *dir;
}Arvore;

/*DECLARA��O DOS M�TODOS*/
//Calcula a altura da �rvore
int altura(Arvore *r);
//M�todos de transforma��o na �rvore
Arvore* rotarEsq(Arvore *r);
Arvore* rotarDir(Arvore *r);
Arvore* inserir(int valor, Arvore *r);
void atualizarFB(Arvore *r);
//M�todo para exibir a �rvore
void exibir(Arvore *r, int nivel);

/*In�cio do programa*/
int main() {
	Arvore *raiz = NULL;
	int i;
	srand(time(NULL));
	for (i = 0; i < 150; i++) {
		raiz = inserir(rand() % 200, raiz);
	}

	exibir(raiz,0);

	return 1;
}

/*M�TODOS*/

/*Calculando a altura da �rvore*/
int altura(Arvore *r) {
	if (r) {
		int altE = altura(r->esq);
		int altD = altura(r->dir);
		if (altE > altD) {
			return altE + 1;
		} else {
			return altD + 1;
		}
	} else {
		return 0;
	}
}

/*Rota��o para a esquerda*/
Arvore* rotarEsq(Arvore *r) {
	Arvore *tmp, *np;

	np = r->dir;
	tmp = np->esq;
	np->esq = r;

	r->dir = tmp;

	return np;
}

/*Rota��o para a direita*/
Arvore* rotarDir(Arvore *r) {
	Arvore *tmp, *np;

	np = r->esq;
	tmp = np->dir;
	np->dir = r;

	r->esq = tmp;

	return np;
}

/*Inserindo de forma ordenada*/
Arvore *inserir(int valor, Arvore *r) {
	if(r){
        /*Inserindo para esquerda ou para direita*/
		if(valor < r->dado){
			r->esq = inserir(valor,r->esq);
		}
        else{
			r->dir = inserir(valor,r->dir);
		}

		//metodo para calcular o fator de balancamento
		r->fb = altura(r->esq) - altura(r->dir);
        /*Rota��o para esquerda*/
		if(r->fb == -2) {
			if(r->dir->fb > 0){
				r->dir = rotarDir(r->dir);
			}
			r = rotarEsq(r);
        }
        /*Rota��o para direita*/
        if(r->fb == 2) {
			if(r->esq->fb < 0){
				r->esq = rotarEsq(r->esq);
			}
			r = rotarDir(r);
		}

		//Atualiza o fator de balanceamento
		atualizarFB(r);
		return r;
	}
    else{
		Arvore *novo = (Arvore *)malloc(sizeof(Arvore));
		novo->dado = valor;
		novo->fb = 0;
		novo->esq = NULL;
		novo->dir = NULL;
		return novo;
	}
}

/*Atualizar o fator de balanceamento*/
void atualizarFB(Arvore *r){
	if(r){
		r->fb = altura(r->esq) - altura(r->dir);
		atualizarFB(r->esq);
		atualizarFB(r->dir);
	}
}

/*M�todo para exibir a �rvore*/
void exibir(Arvore *r, int nivel){
	if(r){
		exibir(r->dir,nivel+1);
		int i;
		for(i=0; i < nivel; i++){
			putchar('\t');
		}
		printf("%d(%d)\n", r->dado, r->fb);
		exibir(r->esq, nivel+1);
	}
}
