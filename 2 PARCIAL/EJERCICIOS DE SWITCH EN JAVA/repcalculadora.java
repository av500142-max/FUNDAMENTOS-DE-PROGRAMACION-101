import java.util.Scanner;

public class repcalculadora {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int repetir = 1;

        for (; repetir == 1;) {

            System.out.print("Ingresa el primer número: ");
            double num1 = sc.nextDouble();

            System.out.print("Ingresa el segundo número: ");
            double num2 = sc.nextDouble();

            System.out.print("Ingresa la operación (+, -, *, /): ");
            char operador = sc.next().charAt(0);

            switch (operador) {

                case '+':
                    System.out.println("Resultado: " + (num1 + num2));
                    break;

                case '-':
                    System.out.println("Resultado: " + (num1 - num2));
                    break;

                case '*':
                    System.out.println("Resultado: " + (num1 * num2));
                    break;

                case '/':
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: división entre cero.");
                    }
                    break;

                default:
                    System.out.println("Operador no válido.");
            }

            System.out.println("\n¿Deseas otro intento?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            repetir = sc.nextInt();

            switch (repetir) {
                case 1:
                    break;

                case 2:
                    repetir = 0;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    repetir = 0;
            }
        }

        System.out.println("Programa terminado.");
        sc.close();
    }
}