import java.util.Scanner;

public class CompaniaTelefonica {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int minutos;
        double costo;

        System.out.print("Ingresa la cantidad de minutos utilizados: ");
        minutos = entrada.nextInt();

        if (minutos <= 5) {
            costo = 10.00;
        } else if (minutos <= 10) {
            costo = 10.00 + (minutos - 5) * 2.00;
        } else {
            costo = 10.00 + 5 * 2.00 + (minutos - 10) * 1.50;
        }

        System.out.println("El costo de la llamada es: $" + costo);

        entrada.close();
    }
}