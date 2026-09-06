import java.util.Scanner;

public class tablasmultiplicar {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int n;

        System.out.println("TABLAS DE MULTIPLICAR");
        System.out.println("Ingresa 0 para terminar.");

        System.out.print("Ingresa un número: ");
        n = entrada.nextInt();

        while (n != 0) {

            System.out.println("\nTabla del " + n);

            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " x " + i + " = " + (n * i));
            }

            System.out.print("\nIngresa otro número (0 para terminar): ");
            n = entrada.nextInt();
        }

        System.out.println("Programa terminado.");

        entrada.close();
    }
}