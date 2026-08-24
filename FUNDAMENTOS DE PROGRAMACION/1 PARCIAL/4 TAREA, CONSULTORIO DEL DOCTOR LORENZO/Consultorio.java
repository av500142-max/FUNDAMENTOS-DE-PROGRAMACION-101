import java.util.Scanner;

public class Consultorio {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int numeroCita;
        double costoCita;
        double totalTratamiento;

        System.out.print("Ingresa el numero de cita: ");
        numeroCita = entrada.nextInt();

        if (numeroCita <= 3) {
            costoCita = 900;
        } else if (numeroCita <= 5) {
            costoCita = 800;
        } else if (numeroCita <= 8) {
            costoCita = 600;
        } else {
            costoCita = 500;
        }

        totalTratamiento = 0;

        for (int i = 1; i <= numeroCita; i++) {

            if (i <= 3) {
                totalTratamiento += 900;
            } else if (i <= 5) {
                totalTratamiento += 800;
            } else if (i <= 8) {
                totalTratamiento += 600;
            } else {
                totalTratamiento += 500;
            }
        }

        System.out.println("Costo de la cita: $" + costoCita);
        System.out.println("Total pagado por el tratamiento: $" + totalTratamiento);

        entrada.close();
    }
}