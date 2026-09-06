import java.util.Scanner;

public class piramidenumeros {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int n;

        System.out.println("PIRÁMIDE DE NÚMEROS");
        System.out.print("Ingresa el número de líneas: ");
        n = entrada.nextInt();

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        entrada.close();
    }
}