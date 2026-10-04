import java.util.Scanner;

public class vendedores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, m;

        // Pedir cantidad de vendedores y zonas
        System.out.print("¿Cuantos vendedores hay? ");
        n = sc.nextInt();

        System.out.print("¿Cuantas zonas hay? ");
        m = sc.nextInt();

        // Crear la matriz
        int[][] ventas = new int[n][m];

        // Llenar la matriz
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(
                    "Ventas del vendedor " + (i + 1) +
                    " en la zona " + (j + 1) + ": "
                );

                ventas[i][j] = sc.nextInt();
            }
        }

        // Mostrar matriz
        System.out.println();
        System.out.println("===== MATRIZ DE VENTAS =====");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(ventas[i][j] + "\t");
            }

            System.out.println();
        }


        // =====================================
        // VENDEDOR QUE MAS VENDIO
        // =====================================

        int mayorVendedor = -1;
        int vendedorMayor = 0;

        for (int i = 0; i < n; i++) {

            int total = 0;

            for (int j = 0; j < m; j++) {

                total = total + ventas[i][j];
            }

            if (total > mayorVendedor) {

                mayorVendedor = total;
                vendedorMayor = i;
            }
        }


        // =====================================
        // VENDEDOR QUE MENOS VENDIO
        // =====================================

        int menorVendedor = mayorVendedor;
        int vendedorMenor = 0;

        for (int i = 0; i < n; i++) {

            int total = 0;

            for (int j = 0; j < m; j++) {

                total = total + ventas[i][j];
            }

            if (total < menorVendedor) {

                menorVendedor = total;
                vendedorMenor = i;
            }
        }


        // =====================================
        // ZONA QUE MAS VENDIO
        // =====================================

        int mayorZona = -1;
        int zonaMayor = 0;

        for (int j = 0; j < m; j++) {

            int sumaZona = 0;

            for (int i = 0; i < n; i++) {

                sumaZona = sumaZona + ventas[i][j];
            }

            if (sumaZona > mayorZona) {

                mayorZona = sumaZona;
                zonaMayor = j;
            }
        }


        // =====================================
        // TOTAL DE TODAS LAS VENTAS
        // =====================================

        int totalGeneral = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                totalGeneral = totalGeneral + ventas[i][j];
            }
        }


        // =====================================
        // MOSTRAR RESULTADOS
        // =====================================

        System.out.println();
        System.out.println("===== RESULTADOS =====");

        System.out.println(
            "La zona que mas computadoras vendio fue la zona "
            + (zonaMayor + 1)
        );

        System.out.println(
            "Computadoras vendidas en esa zona: "
            + mayorZona
        );

        System.out.println();

        System.out.println(
            "El vendedor que menos computadoras vendio fue el vendedor "
            + (vendedorMenor + 1)
        );

        System.out.println(
            "Computadoras vendidas: "
            + menorVendedor
        );

        System.out.println();

        System.out.println(
            "El vendedor que mas computadoras vendio fue el vendedor "
            + (vendedorMayor + 1)
        );

        System.out.println(
            "Computadoras vendidas: "
            + mayorVendedor
        );

        System.out.println();

        System.out.println(
            "La cantidad total de computadoras vendidas fue: "
            + totalGeneral
        );

        sc.close();
    }
}