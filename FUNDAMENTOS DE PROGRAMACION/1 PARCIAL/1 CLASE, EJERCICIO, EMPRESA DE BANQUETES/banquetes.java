import java.util.Scanner;
public class banquetes {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int personas;
        double costoPersona;
        double costoTotal;

        System.out.print("Ingrese el total de personas: ");
        personas = entrada.nextInt();

        if (personas <= 200) {
            costoPersona = 95.00;
        } else if (personas <= 300) {
            costoPersona = 85.00;
        } else {
            costoPersona = 75.00;
        }

        costoTotal = personas * costoPersona;
        System.out.println("\n--- RESULTADO ---");
        System.out.println("Número de personas: " + personas);
        System.out.println("Costo por persona: $" + costoPersona);
        System.out.println("Costo total: $" + costoTotal);
        entrada.close();
    }
}