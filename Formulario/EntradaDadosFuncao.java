import java.util.Scanner;

public class EntradaDadosFuncao {
    public static String sc() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        scanner.close();
        return scan;
    }
    public static void main(String[] args) {
        System.out.println("inp");
        String x = sc();
        System.out.println("Seu input: " + x);
    }
}