import java.util.Scanner;

public class SegurodeAutomovil {

    // Método para calcular la tarifa base
    public static double calcularTarifaBase(double valorVehiculo) {
        return valorVehiculo * 0.04;
    }

    // Método para calcular el recargo por edad
    public static double calcularRecargoPorEdad(double tarifaBase, int edad) {
        if (edad < 25) {
            return tarifaBase * 0.20;
        } else if (edad > 60) {
            return tarifaBase * 0.10;
        } else {
            return 0;
        }
    }

    // Método para calcular el recargo por accidentes
    public static double calcularRecargoPorAccidentes(double tarifaBase, int accidentes) {
        return tarifaBase * 0.08 * accidentes;
    }

    // Método para calcular el descuento por seguridad
    public static double calcularDescuentoSeguridad(double subtotal, boolean tieneSeguridad) {
        if (tieneSeguridad) {
            return subtotal * 0.05;
        } else {
            return 0;
        }
    }

    // Método para calcular el costo final
    public static double calcularCostoFinal(
            double tarifaBase,
            double recargoEdad,
            double recargoAccidentes,
            double descuento) {

        return tarifaBase + recargoEdad + recargoAccidentes - descuento;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double valorVehiculo;
        double tarifaBase;
        double recargoEdad;
        double recargoAccidentes;
        double subtotal;
        double descuento;
        double costoFinal;

        int edad;
        int accidentes;
        int opcionSeguridad;
        boolean tieneSeguridad;

        // Validar valor del vehículo
        do {
            System.out.print("Ingresa el valor del vehículo: $");
            valorVehiculo = entrada.nextDouble();

            if (valorVehiculo <= 0) {
                System.out.println("Error: el valor debe ser mayor que cero.");
            }
        } while (valorVehiculo <= 0);

        // Validar edad
        do {
            System.out.print("Ingresa la edad del conductor: ");
            edad = entrada.nextInt();

            if (edad < 18 || edad > 100) {
                System.out.println("Error: la edad debe estar entre 18 y 100 años.");
            }
        } while (edad < 18 || edad > 100);

        // Validar accidentes
        do {
            System.out.print("Ingresa la cantidad de accidentes del último año: ");
            accidentes = entrada.nextInt();

            if (accidentes < 0) {
                System.out.println("Error: los accidentes no pueden ser negativos.");
            }
        } while (accidentes < 0);

        // Seleccionar sistema de seguridad
        do {
            System.out.println("¿El vehículo cuenta con sistema de seguridad adicional?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            System.out.print("Selecciona una opción: ");
            opcionSeguridad = entrada.nextInt();

            if (opcionSeguridad != 1 && opcionSeguridad != 2) {
                System.out.println("Error: selecciona 1 o 2.");
            }
        } while (opcionSeguridad != 1 && opcionSeguridad != 2);

        tieneSeguridad = opcionSeguridad == 1;

        // Calcular usando los métodos
        tarifaBase = calcularTarifaBase(valorVehiculo);
        recargoEdad = calcularRecargoPorEdad(tarifaBase, edad);
        recargoAccidentes = calcularRecargoPorAccidentes(tarifaBase, accidentes);

        subtotal = tarifaBase + recargoEdad + recargoAccidentes;

        descuento = calcularDescuentoSeguridad(subtotal, tieneSeguridad);

        costoFinal = calcularCostoFinal(
                tarifaBase,
                recargoEdad,
                recargoAccidentes,
                descuento
        );

        // Mostrar resultados
        System.out.println("\n---------- COTIZACIÓN DEL SEGURO ----------");
        System.out.printf("Tarifa base:              $%.2f%n", tarifaBase);
        System.out.printf("Recargo por edad:         $%.2f%n", recargoEdad);
        System.out.printf("Recargo por accidentes:   $%.2f%n", recargoAccidentes);
        System.out.printf("Descuento por seguridad:  $%.2f%n", descuento);
        System.out.printf("Costo anual final:        $%.2f%n", costoFinal);

        entrada.close();
    }
}