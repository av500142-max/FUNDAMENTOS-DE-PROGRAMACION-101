import java.util.Scanner;

public class BecasUniversitarias {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int edad;
        double promedio;
        double beca = 0;

        System.out.print("Ingresa la edad del estudiante: ");
        edad = entrada.nextInt();

        System.out.print("Ingresa el promedio del estudiante: ");
        promedio = entrada.nextDouble();

        if (edad > 18) {

            if (promedio >= 9) {
                beca = 10000;
            } else if (promedio >= 7.5) {
                beca = 8000;
            } else if (promedio >= 6) {
                beca = 5000;
            } else {
                System.out.println("Se enviara una carta de invitacion para mejorar el promedio.");
            }

        } else {

            if (promedio >= 9) {
                beca = 8000;
            } else if (promedio >= 8) {
                beca = 6000;
            } else if (promedio >= 6) {
                beca = 4000;
            } else {
                System.out.println("Se enviara una carta de invitacion para mejorar el promedio.");
            }
        }

        if (beca > 0) {
            System.out.println("La beca mensual es de: $" + beca);
        }

        entrada.close();
    }
}