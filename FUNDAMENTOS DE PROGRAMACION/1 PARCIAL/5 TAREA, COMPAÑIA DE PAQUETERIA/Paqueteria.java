import java.util.Scanner;

public class Paqueteria {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double peso;
        double costoGramo = 0;
        double total;
        int zona;

        System.out.print("Ingresa el peso del paquete en gramos: ");
        peso = entrada.nextDouble();

        System.out.print("Ingresa la zona de destino (1-5): ");
        zona = entrada.nextInt();

        if (peso > 5000) {
            System.out.println("El paquete no puede ser transportado porque supera los 5 kg.");
        } else {

            switch (zona) {
                case 1:
                    costoGramo = 11;
                    break;

                case 2:
                    costoGramo = 10;
                    break;

                case 3:
                    costoGramo = 12;
                    break;

                case 4:
                    costoGramo = 25;
                    break;

                case 5:
                    costoGramo = 30;
                    break;

                default:
                    System.out.println("Zona no valida.");
                    entrada.close();
                    return;
            }

            total = peso * costoGramo;

            System.out.println("Costo de envio: $" + total);
        }

        entrada.close();
    }
}