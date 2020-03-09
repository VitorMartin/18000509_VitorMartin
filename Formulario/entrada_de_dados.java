import java.util.Scanner;

public class EntradaDeDados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String nome;
		
		// Input String
		System.out.println("Informe seu nome:");
		nome = scanner.nextLine();

		// Input int
		int n1, n2;
		System.out.println("Informe dois numeros:");
		n1 = scanner.nextInt();
		n2 = scanner.nextInt();
	}

}
