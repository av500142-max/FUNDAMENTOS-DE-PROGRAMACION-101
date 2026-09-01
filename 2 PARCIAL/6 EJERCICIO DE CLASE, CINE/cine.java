import java.util.Scanner;

public class cine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Número de personas: ");
        int personas = sc.nextInt();

        System.out.print("Día de la semana (1=Lunes, 2=Martes, 3=Miércoles, 4=Jueves, 5=Viernes, 6=Sábado, 7=Domingo): ");
        int dia = sc.nextInt();

        System.out.print("¿Tiene membresía? (1=Sí, 2=No): ");
        int membresia = sc.nextInt();

        double total;

        switch (dia) {

            case 3:
                // Miércoles
                total = personas * 30;
                break;

            case 4:
                // Jueves
                int parejas = personas / 2;
                int individual = personas % 2;

                total = (parejas * 75) + (individual * 50);
                break;

            default:
                // Precio normal
                total = personas * 50;
                break;
        }

        if (membresia == 1) {
            total = total * 0.90;
        }

        System.out.println("Total a pagar: $" + total);
    }
}