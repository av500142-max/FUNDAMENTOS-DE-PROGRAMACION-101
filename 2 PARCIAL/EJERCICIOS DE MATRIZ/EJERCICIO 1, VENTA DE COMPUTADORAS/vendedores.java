import java.util.Scanner;
public class vendedores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;

        int[][] ventas;

        int mayorVendedor = -1;
        int menorVendedor;
        int mayorZona = -1;

        int vendedorMayor = 0;
        int vendedorMenor = 0;
        int zonaMayor = 0;

        int sumaVendedor;
        int sumaZona;

        int totalComputadoras = 0;

        double precioComputadora;
        double ventaMayor;
        double ventaMenor;
        double totalDinero;

        // DATOS INICIALES

        System.out.println("======================================");
        System.out.println(" VENTA DE COMPUTADORAS");
        System.out.println("======================================");

        System.out.print("¿Cuantos vendedores hay en total? ");
        n = sc.nextInt();

        System.out.print("¿Cuantas zonas hay en donde se encuentran los vendedores? ");
        m = sc.nextInt();

        System.out.print("¿Cuanto cuesta una computadora? $");
        precioComputadora = sc.nextDouble();

        ventas = new int[n][m];

        // CAPTURAR VENTAS

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(
                    " Total de Computadoras vendidas por el vendedor "
                    + (i + 1)
                    + " en la zona "
                    + (j + 1)
                    + ": "
                );

                ventas[i][j] = sc.nextInt();
            }
        }

        // MOSTRAR MATRIZ

        System.out.println("\nMATRIZ DE COMPUTADORAS VENDIDAS");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(ventas[i][j] + " ");
            }

            System.out.println();
        }

        // TOTAL DE COMPUTADORAS

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                totalComputadoras =
                    totalComputadoras + ventas[i][j];
            }
        }

        totalDinero =
            totalComputadoras * precioComputadora;

        // VENDEDOR QUE MAS VENDIO

        for (int i = 0; i < n; i++) {

            sumaVendedor = 0;

            for (int j = 0; j < m; j++) {

                sumaVendedor =
                    sumaVendedor + ventas[i][j];
            }

            if (sumaVendedor > mayorVendedor) {

                mayorVendedor = sumaVendedor;
                vendedorMayor = i + 1;
            }
        }

        ventaMayor =
            mayorVendedor * precioComputadora;

        // VENDEDOR QUE MENOS VENDIO

        menorVendedor = mayorVendedor;

        for (int i = 0; i < n; i++) {

            sumaVendedor = 0;

            for (int j = 0; j < m; j++) {

                sumaVendedor =
                    sumaVendedor + ventas[i][j];
            }

            if (sumaVendedor < menorVendedor) {

                menorVendedor = sumaVendedor;
                vendedorMenor = i + 1;
            }
        }

        ventaMenor =
            menorVendedor * precioComputadora;

        // ZONA QUE MAS VENDIO

        for (int j = 0; j < m; j++) {

            sumaZona = 0;

            for (int i = 0; i < n; i++) {

                sumaZona =
                    sumaZona + ventas[i][j];
            }

            if (sumaZona > mayorZona) {

                mayorZona = sumaZona;
                zonaMayor = j + 1;
            }
        }

        // RESULTADOS

        System.out.println("\n======================================");
        System.out.println(" RESULTADOS");
        System.out.println("======================================");

        System.out.println(
            "\nPrecio de una computadora: $"
            + precioComputadora
        );

        System.out.println(
            "\nZona donde mas computadoras se vendieron:"
        );

        System.out.println("Zona " + zonaMayor);
        System.out.println(
            "Computadoras vendidas: " + mayorZona
        );

        System.out.println(
            "\nVendedor que menos computadoras vendio:"
        );

        System.out.println(
            "Vendedor " + vendedorMenor
        );

        System.out.println(
            "Computadoras vendidas: " + menorVendedor
        );

        System.out.println(
            "Dinero obtenido: $" + ventaMenor
        );

        System.out.println(
            "\nVendedor que mas computadoras vendio:"
        );

        System.out.println(
            "Vendedor " + vendedorMayor
        );

        System.out.println(
            "Computadoras vendidas: " + mayorVendedor
        );

        System.out.println(
            "Dinero obtenido: $" + ventaMayor
        );

        System.out.println(
            "\nCantidad total de computadoras vendidas: "
            + totalComputadoras
        );

        System.out.println(
            "Venta total: $" + totalDinero
        );

        sc.close();
    }
}
