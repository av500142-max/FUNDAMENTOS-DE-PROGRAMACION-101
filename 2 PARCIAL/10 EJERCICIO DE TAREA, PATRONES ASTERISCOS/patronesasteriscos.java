import java.util.Scanner;

public class patronesasteriscos {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int n;

        System.out.println("PATRONES CON ASTERISCOS");
        System.out.print("Ingresa el número de líneas: ");
        n = entrada.nextInt();

        // FIGURA 1
        System.out.println("FIGURA 1");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // FIGURA 2
        System.out.println("FIGURA 2");

        for (int i = n; i >= 1; i--) {

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // FIGURA 3
        System.out.println("FIGURA 3");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        entrada.close();
    }
}