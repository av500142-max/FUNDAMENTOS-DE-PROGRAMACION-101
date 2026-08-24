import java.util.Scanner;

public class Estacionamiento {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int horas;
        double total;

        System.out.print("Ingresa el numero de horas utilizadas: ");
        horas = entrada.nextInt();

        if (horas <= 2) {
            total = horas * 30;
        } else if (horas <= 5) {
            total = (2 * 30) + ((horas - 2) * 25);
        } else if (horas <= 10) {
            total = (2 * 30) + (3 * 25) + ((horas - 5) * 20);
        } else {
            total = 380;
        }

        System.out.println("El costo del estacionamiento es: $" + total);

        entrada.close();
    }
}