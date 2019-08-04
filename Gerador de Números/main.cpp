#include <iostream>
#include <locale>
#include <random>
#include <fstream>

using namespace std;

/* GERADOR DE NÚMEROS RANDÔMICOS
* Requisitos:
* Solicitar ao usuário a quantidade de números a serem gerados
* Solicitar ao usuário o nome do arquivo para gravar
* Gerar números de forma randômica
* Salvar os valores em um arquivo
* Retornar os valores do arquivo para um vetor
* Temporizar o processamento
*/

int main(){
	setlocale(LC_ALL, "Portuguese");
	
	//Solicitar a quantidade de números para gerar
	cout << "Informe quantos números deseja gerar: ";
	long long int qtdNumeros;
	cin >> qtdNumeros;
	cout << "Quantidade de números gerados: " << qtdNumeros << endl;
	
	//Solicitar o nome do arquivo para salvar
	string nomeArquivo;
	cout << "Informe um nome para o arquivo: ";
	cin >> nomeArquivo;
	nomeArquivo = nomeArquivo + ".txt";
	cout << "Arquivo salvo como: " << nomeArquivo << endl;
	
	//Armazena no arquivo
	ofstream outFile; //Arquivo de saída
	outFile.open(nomeArquivo, ios::out); //Abre o arquivo para gravação
	
	if(!outFile){
		cout << "Erro ao processar o arquivo!" << endl;
		abort();
	}
	
	//Gerando valores randômicos com a biblioteca nativa do C++
	mt19937 mt(12); //Seed
	uniform_int_distribution <int> linear_i(0,3000); //Valores inteiros de 0 até 3000
	
	//Armazenando os valores no arquivo
	int valor;
	
	for( ; qtdNumeros != 0; qtdNumeros--){
		valor = linear_i(mt);
		if(qtdNumeros > 1){
			outFile << valor << "\n";	
		}
		else{//evita um "\n" no final do arquivo
			outFile << valor;
		}
	}
	outFile.close(); //Fecha o arquivo
	
	//Lendo os valores do arquivo
	ifstream inFile; //Arquivo de entrada
	string nomeEntrada; //Nome do arquivo de entrada
	
	cout << "Digite o nome do arquivo com os dados: ";
	cin >> nomeEntrada;
	
	inFile.open(nomeEntrada, ios::in);
	if(!inFile){
		cout << "Arquivo não pode ser aberto" << endl;
		abort();
	}
	string aux; //Variável auxiliar para contar o numero de linhas do arquivo
	int contador;
	while(!inFile.eof()){
		getline(inFile, aux);
		contador++;
	}
	cout << "Total de valores no arquivo: " << contador << endl;
	inFile.close();
	//Abrindo o arquivo novamente para armazenamento no vetor
	inFile.open(nomeEntrada, ios::in);
	//Armazena os arquivos em um vetor;
	long long int vetor[contador]; //Vetor do tamanho do número de elementos no arquivo
	int i = 0;
	while(i < contador){
		inFile >> vetor [i];
		i++;
	}
	cout << "Valores no vetor: " << endl;
	for(i = 0; i < contador; i++){
		cout << i+1 << "° valor: "<< vetor[i] << endl;
	}
	return 0; 
}
