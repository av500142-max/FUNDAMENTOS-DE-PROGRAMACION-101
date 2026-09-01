import java.util.Scanner;

public class tartas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcionTarta;
        int opcionChocolate;
        int opcionSnack;
        int personalizada;

        double precio = 0;

        String nombre = "";

        // ----- TARTA -----

        System.out.println("===== PASTELERIA =====");
        System.out.println("1. Tarta de manzana - $200");
        System.out.println("2. Tarta de fresa - $250");
        System.out.println("3. Tarta de chocolate");

        System.out.print("Elige una tarta: ");
        opcionTarta = sc.nextInt();

        switch (opcionTarta) {

            case 1:
                precio = 200;
                System.out.println("Elegiste tarta de manzana.");
                break;

            case 2:
                precio = 250;
                System.out.println("Elegiste tarta de fresa.");
                break;

            case 3:

                System.out.println("\nTipo de chocolate:");
                System.out.println("1. Chocolate negro - $280");
                System.out.println("2. Chocolate blanco - $300");

                System.out.print("Elige una opción: ");
                opcionChocolate = sc.nextInt();

                switch (opcionChocolate) {

                    case 1:
                        precio = 280;
                        System.out.println("Elegiste chocolate negro.");
                        break;

                    case 2:
                        precio = 300;
                        System.out.println("Elegiste chocolate blanco.");
                        break;

                    default:
                        System.out.println("Opción de chocolate no válida.");
                        return;
                }

                break;

            default:
                System.out.println("Opción de tarta no válida.");
                return;
        }

        // ----- SNACK -----

        System.out.println("\n===== SNACK =====");
        System.out.println("1. Fresa");
        System.out.println("2. Galleta");
        System.out.println("3. Durazno");
        System.out.println("4. No quiero snack");

        System.out.print("Elige una opción: ");
        opcionSnack = sc.nextInt();

        switch (opcionSnack) {

            case 1:
                System.out.println("Agregaste snack de fresa.");
                precio = precio + 25;
                break;

            case 2:
                System.out.println("Agregaste snack de galleta.");
                precio = precio + 25;
                break;

            case 3:
                System.out.println("Agregaste snack de durazno.");
                precio = precio + 25;
                break;

            case 4:
                System.out.println("No agregaste snack.");
                break;

            default:
                System.out.println("Opción de snack no válida.");
                return;
        }

        // ----- PERSONALIZACIÓN -----

        System.out.println("\n===== PERSONALIZACION =====");
        System.out.println("1. Si - $30");
        System.out.println("2. No");

        System.out.print("¿Quieres personalizar la tarta?: ");
        personalizada = sc.nextInt();

        switch (personalizada) {

            case 1:
                sc.nextLine(); // Limpiar el salto de línea

                System.out.print("Escribe el nombre para la tarta: ");
                nombre = sc.nextLine();

                precio = precio + 30;

                System.out.println("Se agrego el nombre: " + nombre);
                break;

            case 2:
                System.out.println("La tarta no sera personalizada.");
                break;

            default:
                System.out.println("Opción no válida.");
                return;
        }

        // ----- TOTAL -----

        System.out.println("\n==============================");
        System.out.println("        RESUMEN DE COMPRA");
        System.out.println("==============================");

        System.out.println("Precio total: $" + precio);

        System.out.println("==============================");

        sc.close();
    }
}