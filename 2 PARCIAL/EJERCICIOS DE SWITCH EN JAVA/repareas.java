import java.util.Scanner;

public class repareas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int repetir = 1;

        for (; repetir == 1;) {

            System.out.println("\n===== CALCULO DE AREAS =====");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectángulo");
            System.out.println("3. Triángulo");
            System.out.println("4. Círculo");

            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            double area;

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa el lado: ");
                    double lado = sc.nextDouble();

                    area = lado * lado;

                    System.out.println("Área del cuadrado: " + area);
                    break;

                case 2:
                    System.out.print("Ingresa la base: ");
                    double base = sc.nextDouble();

                    System.out.print("Ingresa la altura: ");
                    double altura = sc.nextDouble();

                    area = base * altura;

                    System.out.println("Área del rectángulo: " + area);
                    break;

                case 3:
                    System.out.print("Ingresa la base: ");
                    base = sc.nextDouble();

                    System.out.print("Ingresa la altura: ");
                    altura = sc.nextDouble();

                    area = (base * altura) / 2;

                    System.out.println("Área del triángulo: " + area);
                    break;

                case 4:
                    System.out.print("Ingresa el radio: ");
                    double radio = sc.nextDouble();

                    area = Math.PI * radio * radio;

                    System.out.println("Área del círculo: " + area);
                    break;

                default:
                    System.out.println("Opción no válida.");
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