import java.util.Scanner;

public class TiendaLinea {

    // Método para calcular el subtotal de un producto
    public static double calcularSubtotalProducto(double precio, int cantidad) {
        return precio * cantidad;
    }

    // Método para calcular el subtotal general
    public static double calcularSubtotalGeneral(
            double subtotal1,
            double subtotal2,
            double subtotal3) {

        return subtotal1 + subtotal2 + subtotal3;
    }

    // Método para calcular el descuento
    public static double calcularDescuento(double subtotal, int tipoCliente) {
        if (tipoCliente == 2) {
            return subtotal * 0.10;
        } else {
            return 0;
        }
    }

    // Método para calcular el costo de envío
    public static double calcularEnvio(double subtotal, String codigoPostal) {
        // El código postal se recibe porque lo solicita el método.
        // El costo depende del subtotal antes del descuento.

        if (subtotal < 1000) {
            return 150;
        } else if (subtotal < 3000) {
            return 80;
        } else {
            return 0;
        }
    }

    // Método para calcular el impuesto
    public static double calcularImpuesto(double subtotalConDescuento) {
        return subtotalConDescuento * 0.16;
    }

    // Método para calcular el total
    public static double calcularTotal(
            double subtotal,
            double descuento,
            double impuesto,
            double envio) {

        return subtotal - descuento + impuesto + envio;
    }

    // Método para validar que el código postal tenga exactamente
    // cinco dígitos numéricos
    public static boolean validarCodigoPostal(String codigoPostal) {
        if (codigoPostal.length() != 5) {
            return false;
        }

        for (int i = 0; i < codigoPostal.length(); i++) {
            if (!Character.isDigit(codigoPostal.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double precio1, precio2, precio3;
        double subtotal1, subtotal2, subtotal3;
        double subtotalGeneral, descuento;
        double subtotalConDescuento, impuesto;
        double envio, total;

        int cantidad1, cantidad2, cantidad3;
        int tipoCliente;
        String codigoPostal;

        // ---------- PRODUCTO 1 ----------
        do {
            System.out.print("Ingresa el precio del producto 1: $");
            precio1 = entrada.nextDouble();

            if (precio1 <= 0) {
                System.out.println("Error: el precio debe ser mayor que cero.");
            }
        } while (precio1 <= 0);

        do {
            System.out.print("Ingresa la cantidad del producto 1: ");
            cantidad1 = entrada.nextInt();

            if (cantidad1 <= 0) {
                System.out.println("Error: la cantidad debe ser mayor que cero.");
            }
        } while (cantidad1 <= 0);

        // ---------- PRODUCTO 2 ----------
        do {
            System.out.print("Ingresa el precio del producto 2: $");
            precio2 = entrada.nextDouble();

            if (precio2 <= 0) {
                System.out.println("Error: el precio debe ser mayor que cero.");
            }
        } while (precio2 <= 0);

        do {
            System.out.print("Ingresa la cantidad del producto 2: ");
            cantidad2 = entrada.nextInt();

            if (cantidad2 <= 0) {
                System.out.println("Error: la cantidad debe ser mayor que cero.");
            }
        } while (cantidad2 <= 0);

        // ---------- PRODUCTO 3 ----------
        do {
            System.out.print("Ingresa el precio del producto 3: $");
            precio3 = entrada.nextDouble();

            if (precio3 <= 0) {
                System.out.println("Error: el precio debe ser mayor que cero.");
            }
        } while (precio3 <= 0);

        do {
            System.out.print("Ingresa la cantidad del producto 3: ");
            cantidad3 = entrada.nextInt();

            if (cantidad3 <= 0) {
                System.out.println("Error: la cantidad debe ser mayor que cero.");
            }
        } while (cantidad3 <= 0);

        // ---------- CÁLCULOS DE SUBTOTALES ----------
        subtotal1 = calcularSubtotalProducto(precio1, cantidad1);
        subtotal2 = calcularSubtotalProducto(precio2, cantidad2);
        subtotal3 = calcularSubtotalProducto(precio3, cantidad3);

        subtotalGeneral = calcularSubtotalGeneral(
                subtotal1,
                subtotal2,
                subtotal3
        );

        // ---------- TIPO DE CLIENTE ----------
        do {
            System.out.println("\nSelecciona el tipo de cliente:");
            System.out.println("1. Cliente regular");
            System.out.println("2. Cliente frecuente");
            System.out.print("Opción: ");
            tipoCliente = entrada.nextInt();

            if (tipoCliente != 1 && tipoCliente != 2) {
                System.out.println("Error: el tipo de cliente debe ser 1 o 2.");
            }
        } while (tipoCliente != 1 && tipoCliente != 2);

        descuento = calcularDescuento(subtotalGeneral, tipoCliente);

        subtotalConDescuento = subtotalGeneral - descuento;

        // ---------- CÓDIGO POSTAL ----------
        entrada.nextLine(); // Limpiar el salto de línea pendiente

        do {
            System.out.print("\nIngresa el código postal (5 dígitos): ");
            codigoPostal = entrada.nextLine();

            if (!validarCodigoPostal(codigoPostal)) {
                System.out.println("Error: el código postal debe contener exactamente 5 dígitos numéricos.");
            }
        } while (!validarCodigoPostal(codigoPostal));

        // ---------- ENVÍO, IMPUESTO Y TOTAL ----------
        envio = calcularEnvio(subtotalGeneral, codigoPostal);
        impuesto = calcularImpuesto(subtotalConDescuento);

        total = calcularTotal(
                subtotalGeneral,
                descuento,
                impuesto,
                envio
        );

        // ---------- MOSTRAR RESULTADOS ----------
        System.out.println("\n---------- RESUMEN DE COMPRA ----------");
        System.out.printf("Subtotal producto 1:  $%.2f%n", subtotal1);
        System.out.printf("Subtotal producto 2:  $%.2f%n", subtotal2);
        System.out.printf("Subtotal producto 3:  $%.2f%n", subtotal3);
        System.out.printf("Subtotal general:     $%.2f%n", subtotalGeneral);
        System.out.printf("Descuento:            $%.2f%n", descuento);
        System.out.printf("Subtotal con descuento: $%.2f%n", subtotalConDescuento);
        System.out.printf("Impuesto (16%%):       $%.2f%n", impuesto);
        System.out.printf("Envío:                $%.2f%n", envio);
        System.out.printf("Total a pagar:        $%.2f%n", total);

        entrada.close();
    }
}