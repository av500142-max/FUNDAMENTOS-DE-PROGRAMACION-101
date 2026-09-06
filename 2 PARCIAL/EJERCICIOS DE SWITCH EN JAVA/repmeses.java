import java.util.Scanner;

public class repmeses {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int repetir = 1;

        for (; repetir == 1;) {

            System.out.print("Ingresa el número del mes (1-12): ");
            int mes = sc.nextInt();

            switch (mes) {
                case 1:
                    System.out.println("Enero, 31 dias");
                    break;
                case 2:
                    System.out.println("Febrero, 28 dias");
                    break;
                case 3:
                    System.out.println("Marzo, 31 dias");
                    break;
                case 4:
                    System.out.println("Abril, 30 dias");
                    break;
                case 5:
                    System.out.println("Mayo, 31 dias");
                    break;
                case 6:
                    System.out.println("Junio,30 dias");
                    break;
                case 7:
                    System.out.println("Julio, 31 dias");
                    break;
                case 8:
                    System.out.println("Agosto, 31 dias");
                    break;
                case 9:
                    System.out.println("Septiembre, 30 dias");
                    break;
                case 10:
                    System.out.println("Octubre, 31 dias");
                    break;
                case 11:
                    System.out.println("Noviembre, 30 dias");
                    break;
                case 12:
                    System.out.println("Diciembre, 31 dias");
                    break;
                default:
                    System.out.println("Mes no válido.");
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