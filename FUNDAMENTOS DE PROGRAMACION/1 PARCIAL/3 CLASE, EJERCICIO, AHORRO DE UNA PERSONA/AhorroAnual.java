import java.util.Scanner;

public class AhorroAnual {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double ahorroMensual;
        double ahorroAnual = 0;

        System.out.print("Ingresa la cantidad que ahorras cada mes: $");
        ahorroMensual = entrada.nextDouble();

        for (int mes = 1; mes <= 12; mes++) {
            ahorroAnual = ahorroAnual + ahorroMensual;
        }

        System.out.println("El ahorro total durante un año es: $" + ahorroAnual);

        entrada.close();
    }
}