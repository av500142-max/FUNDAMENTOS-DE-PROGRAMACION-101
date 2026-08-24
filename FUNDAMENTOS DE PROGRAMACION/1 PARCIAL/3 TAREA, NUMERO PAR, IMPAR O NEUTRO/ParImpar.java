import java.util.Scanner;

public class ParImpar {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int numero;

        System.out.print("Ingresa un numero: ");
        numero = entrada.nextInt();

        if (numero == 0) {
            System.out.println("El numero es neutro.");
        } else if (numero % 2 == 0) {
            System.out.println("El numero es par.");
        } else {
            System.out.println("El numero es impar.");
        }

        entrada.close();
    }
}