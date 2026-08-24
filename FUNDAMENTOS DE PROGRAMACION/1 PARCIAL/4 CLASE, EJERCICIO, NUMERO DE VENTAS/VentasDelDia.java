import java.util.Scanner;

public class VentasDelDia {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int numeroVentas;
        double venta;
        double total = 0;

        System.out.print("Ingresa el numero de ventas realizadas durante el dia: ");
        numeroVentas = entrada.nextInt();

        for (int i = 1; i <= numeroVentas; i++) {

            System.out.print("Ingresa el monto de la venta " + i + ": $");
            venta = entrada.nextDouble();

            total = total + venta;
        }

        System.out.println("\nNumero de ventas realizadas: " + numeroVentas);
        System.out.println("Total vendido durante el dia: $" + total);

        entrada.close();
    }
}