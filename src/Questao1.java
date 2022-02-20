
/**
 *Desafio Capgemini - Questão 1
 *Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere * e espaços.
 * A base e altura da escada devem ser iguais ao valor de n. A última linha não deve conter nenhum espaço.
 */

//importada a biblioteca Scanner, utilizada para fazer a leitura da entrada dos dados
import java.util.Scanner;

public class Questao1 {

    public static void main(String[] args) {

	// Declarada variavel n, utilizada para armazenar o dado digitado referente a altura/linhas da escada
	int n;

	// Definição da variavel Scanner, que será utilizada para fazer a leitura da entrada dos dados
	Scanner sc = new Scanner(System.in);

	// Mensagem solicitando a entrada do dado referente a altura/numero de linhas da escada
	System.out.print("Digite o numero de linhas desejadas para construir a escada: ");

	// Repete ate o proximo dado inserido ser inteiro
	while (!sc.hasNextInt()) {
	    sc.next(); // Le e descarta a entrada do numero nao inteiro
	    System.out.println("VALOR INCORRETO! Favor digitar um numero inteiro valido"); // Re-prompt
	    System.out.print("Digite o numero de linhas desejadas para construir a escada: "); // Re-prompt
	}

	// Possuindo a confirmacao da leitura do numero inteiro, vincula o mesmo a variavel n
	n = sc.nextInt();

	// Estrutura de repeticao para gerar a escada com alinhamento a direita

	for (int linha = 0; linha < n; linha++) {
	    for (int coluna = 0; coluna < n; coluna++) {

		// insere os espacos em branco
		if (coluna < n - linha - 1)
		    System.out.print(" ");
		else
		    System.out.print("*");
	    }
	    // Mostra a escada em uma nova linha
	    System.out.println();
	}

	// fecha o scanner de leitura de dados
	sc.close();
    }

}