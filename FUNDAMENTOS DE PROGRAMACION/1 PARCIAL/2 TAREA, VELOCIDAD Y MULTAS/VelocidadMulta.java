import java.util.Scanner;

public class VelocidadMulta {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int velocidad;
        boolean cumpleaños;
        int resultado;

        System.out.print("Ingresa la velocidad: ");
        velocidad = entrada.nextInt();

        System.out.print("¿Es tu cumpleaños? (true/false): ");
        cumpleaños = entrada.nextBoolean();

        if (cumpleaños) {
            velocidad = velocidad - 5;
        }

        if (velocidad <= 60) {
            resultado = 0;
        } else if (velocidad <= 80) {
            resultado = 1;
        } else {
            resultado = 2;
        }

        System.out.println("Resultado: " + resultado);

        entrada.close();
    }
}