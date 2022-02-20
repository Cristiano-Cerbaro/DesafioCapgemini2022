
/**
Desafio Capgemini - Quest�o 2
D�bora se inscreveu em uma rede social para se manter em contato com seus amigos. A p�gina de cadastro exigia o preenchimento dos campos de nome e senha, por�m a senha precisa ser forte. O site considera uma senha forte quando ela satisfaz os seguintes crit�rios:
Possui no m�nimo 6 caracteres.
Cont�m no m�nimo 1 digito.
Cont�m no m�nimo 1 letra em min�sculo.
Cont�m no m�nimo 1 letra em mai�sculo.
Cont�m no m�nimo 1 caractere especial. Os caracteres especiais s�o: !@#$%^&*()-+
D�bora digitou uma string aleat�ria no campo de senha, por�m ela n�o tem certeza se � uma senha forte. Para ajudar D�bora, construa um algoritmo que informe qual � o n�mero m�nimo de caracteres que devem ser adicionados para uma string qualquer ser considerada segura.
**/

//realiza a importacao do Scanner para Leitura, e Matcher e Pattern da biblioteca Regex para validacao da senha
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Questao2 {

    // Fun��o para validar a Senha
    public static boolean senhaForte(String senha) {

	/**
	 * string do regex para validar parametros, sendo: ^ inicio da string (?=.*[0-9]) tem que ter pelo menos um digito (?=.*[a-z]) tem que ter pelo menos um caractere alfabetico em minusculo (?=.*[A-Z])
	 * tem que ter pelo menos um caractere alfabetico em maiusculo (?=.*[@#$%^&-+=()] tem que ter pelo menos um caracter especial (?=\\S+$) n�o permite espacos na senha .{6,} tem que ter pelo menos 6
	 * digitos $ final da string
	 **/
	String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{6,}$";

	// Compila a string na Classe Pattern
	Pattern p = Pattern.compile(regex);

	// se a senha n�o tiver conteudo retorna falso
	if (senha == null) {
	    return false;
	}

	// Pattern class contains matcher() method
	// Classe Patter contem metodo matcher () para achar similaridades entre a senha e as expressoes definidas
	Matcher m = p.matcher(senha);

	// retorna a senha comparada com as expressoes definidas
	return m.matches();
    }

    // Funcao Principal
    public static void main(String args[]) {

	// variavel que recebera a senha digitada
	String senha;

	// inicializacao da variavel scanner para leitura
	Scanner sc = new Scanner(System.in);

	// prompt de comando para leitura
	System.out.println("Favor digitar uma Senha: ");

	// alocada senha lida
	senha = sc.next();

	// executa a funcao de validacao da senha
	if (senhaForte(senha)) {
	    System.out.println("Senha Forte! Validada corretamente");
	} else {
	    System.out.println("SENHA INVALIDA! ");

	    // verifica e informa se possui menos que o minimo de caracteres definidos
	    if (senha.length() < 6) {
		System.out.println("Senha necessita ter mais " + (6 - senha.length()) + " caracteres!");
	    }

	    System.out.println("-----------------------------------\r\n"
		    + "Para a senha ser considerada forte, necessita:\r\n" + "Possui no m�nimo 6 caracteres.\r\n"
		    + "Cont�m no m�nimo 1 digito.\r\n" + "Cont�m no m�nimo 1 letra em min�sculo.\r\n"
		    + "Cont�m no m�nimo 1 letra em mai�sculo.\r\n"
		    + "Cont�m no m�nimo 1 caractere especial. Os caracteres especiais s�o: !@#$%^&*()-+");
	}

	// fecha o scanner de leitura de dados
	sc.close();
    }
}