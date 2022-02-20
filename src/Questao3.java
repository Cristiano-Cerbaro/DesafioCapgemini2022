
/**
Desafio Capgemini - Questão 3
Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra podem ser realocadas para formar a outra palavra.
Dada uma string qualquer, desenvolva um algoritmo que encontre o número de pares de substrings que são anagramas.**/

// realiza a importacao do Scanner para leitura e Arrays e Hasmap para manipulacao
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {

	// inicializacao do Scanner para leitura dos dados
	Scanner sc = new Scanner(System.in);

	// Prompt de Comando solicitando digitacao
	System.out.println("Digite o texto para ser analizado:");

	// Aplica funcao para verificacao dos anagramas
	subString(sc.next());

	// fecha o scanner de leitura
	sc.close();

    }

    // subfuncao para verificar os anagramas, recebendo parametro a string
    static void subString(String s) {

	// inicializacao do HasMap usado para manter o Array de dados
	HashMap<String, Integer> map = new HashMap<>();

	// percorre duas vezes a string para verificacao
	for (int i = 0; i < s.length(); i++) {
	    for (int j = i; j < s.length(); j++) {

		// cria um array de caracteres com as substrings recebidas
		char[] valC = s.substring(i, j + 1).toCharArray();

		// realiza a ordenacao do array dos caracteres
		Arrays.sort(valC);

		// gera uma nova string com os caracteres ordenados
		String val = new String(valC);

		// percorre o mapamento para verificar a duplicidade de chaves
		if (map.containsKey(val))
		    map.put(val, map.get(val) + 1);
		else
		    map.put(val, 1);
	    }
	}

	// variavel que ira armazenar o contador de Anagramas
	int anagramPairCount = 0;

	// percorre o mapeamento, buscando a chave de quantidade de anagramas armazenadas
	for (String key : map.keySet()) {
	    int n = map.get(key);

	    // adiciona ao contador a quantidade de anagramaas
	    anagramPairCount += (n * (n - 1)) / 2;
	}

	// mensagem ao usuario demonstrando a quantidade de anagramas encontrados
	System.out.println("O texto digitado possui: " + anagramPairCount + " anagramas!");
    }
}