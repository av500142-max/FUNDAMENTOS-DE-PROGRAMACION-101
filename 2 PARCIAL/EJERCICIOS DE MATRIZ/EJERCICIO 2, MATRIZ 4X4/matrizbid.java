import java.util.Scanner;

public class matrizbid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Matriz original
        int[][] matriz = new int[4][4];

        // Matriz para los cuadrados
        int[][] cuadrados = new int[4][4];

        int opcion;

        // Indica si la matriz ya fue rellenada
        boolean llenada = false;

        do {

            // ==============================
            // MENU
            // ==============================

            System.out.println();
            System.out.println("==============================");
            System.out.println("       MENU DE MATRIZ");
            System.out.println("==============================");
            System.out.println("1. Rellenar matriz");
            System.out.println("2. Suma de cada fila y columna");
            System.out.println("3. Suma de una fila");
            System.out.println("4. Suma de una columna");
            System.out.println("5. Mayor y menor con posicion");
            System.out.println("6. Contar numeros pares");
            System.out.println("7. Contar numeros impares");
            System.out.println("8. Matriz con cuadrados");
            System.out.println("9. Sumar diagonal principal");
            System.out.println("10. Sumar diagonal inversa");
            System.out.println("11. Media de todos los valores");
            System.out.println("12. Salir");
            System.out.println("==============================");

            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();


            // ==============================
            // OPCION 1
            // RELLENAR MATRIZ
            // ==============================

            if (opcion == 1) {

                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 4; j++) {

                        boolean repetido;

                        do {

                            repetido = false;

                            System.out.print(
                                "Introduce un numero para [" +
                                (i + 1) + "][" + (j + 1) + "]: "
                            );

                            int numero = sc.nextInt();

                            // Revisar si el numero ya existe
                            for (int fila = 0; fila < 4; fila++) {

                                for (int columna = 0; columna < 4; columna++) {

                                    if (matriz[fila][columna] == numero) {
                                        repetido = true;
                                    }

                                }

                            }

                            if (repetido) {

                                System.out.println(
                                    "Ese numero ya existe."
                                );

                                System.out.println(
                                    "Introduce otro numero."
                                );

                            } else {

                                matriz[i][j] = numero;

                            }

                        } while (repetido);

                    }

                }

                llenada = true;

                System.out.println();
                System.out.println(
                    "La matriz se ha rellenado correctamente."
                );


            // ==============================
            // COMPROBAR SI ESTA RELLENADA
            // ==============================

            } else if (!llenada && opcion != 12) {

                System.out.println();
                System.out.println(
                    "Primero debes rellenar la matriz usando la opcion 1."
                );


            // ==============================
            // OPCIONES DESPUES DE RELLENAR
            // ==============================

            } else if (llenada) {


                // ==============================
                // MOSTRAR MATRIZ ORIGINAL
                // ==============================

                System.out.println();
                System.out.println("===== MATRIZ ORIGINAL =====");

                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 4; j++) {

                        System.out.print(
                            matriz[i][j] + "\t"
                        );

                    }

                    System.out.println();
                }


                // ==============================
                // OPCION 2
                // SUMA DE FILAS Y COLUMNAS
                // ==============================

                if (opcion == 2) {

                    System.out.println();
                    System.out.println("===== SUMA DE FILAS =====");

                    for (int i = 0; i < 4; i++) {

                        int suma = 0;

                        for (int j = 0; j < 4; j++) {

                            suma = suma + matriz[i][j];

                        }

                        System.out.println(
                            "Fila " + (i + 1) + ": " + suma
                        );
                    }


                    System.out.println();
                    System.out.println("===== SUMA DE COLUMNAS =====");

                    for (int j = 0; j < 4; j++) {

                        int suma = 0;

                        for (int i = 0; i < 4; i++) {

                            suma = suma + matriz[i][j];

                        }

                        System.out.println(
                            "Columna " + (j + 1) + ": " + suma
                        );
                    }


                // ==============================
                // OPCION 3
                // SUMA DE UNA FILA
                // ==============================

                } else if (opcion == 3) {

                    System.out.print(
                        "Que fila quieres sumar? (1-4): "
                    );

                    int fila = sc.nextInt();

                    if (fila >= 1 && fila <= 4) {

                        int suma = 0;

                        for (int j = 0; j < 4; j++) {

                            suma = suma + matriz[fila - 1][j];

                        }

                        System.out.println(
                            "La suma de la fila " +
                            fila + " es: " + suma
                        );

                    } else {

                        System.out.println(
                            "Fila incorrecta."
                        );

                    }


                // ==============================
                // OPCION 4
                // SUMA DE UNA COLUMNA
                // ==============================

                } else if (opcion == 4) {

                    System.out.print(
                        "Que columna quieres sumar? (1-4): "
                    );

                    int columna = sc.nextInt();

                    if (columna >= 1 && columna <= 4) {

                        int suma = 0;

                        for (int i = 0; i < 4; i++) {

                            suma = suma + matriz[i][columna - 1];

                        }

                        System.out.println(
                            "La suma de la columna " +
                            columna + " es: " + suma
                        );

                    } else {

                        System.out.println(
                            "Columna incorrecta."
                        );

                    }


                // ==============================
                // OPCION 5
                // MAYOR Y MENOR
                // ==============================

                } else if (opcion == 5) {

                    int mayor = matriz[0][0];
                    int menor = matriz[0][0];

                    int filaMayor = 0;
                    int columnaMayor = 0;

                    int filaMenor = 0;
                    int columnaMenor = 0;

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            if (matriz[i][j] > mayor) {

                                mayor = matriz[i][j];

                                filaMayor = i;
                                columnaMayor = j;
                            }

                            if (matriz[i][j] < menor) {

                                menor = matriz[i][j];

                                filaMenor = i;
                                columnaMenor = j;
                            }

                        }

                    }

                    System.out.println(
                        "Mayor: " + mayor
                    );

                    System.out.println(
                        "Posicion: fila " +
                        (filaMayor + 1) +
                        ", columna " +
                        (columnaMayor + 1)
                    );

                    System.out.println();

                    System.out.println(
                        "Menor: " + menor
                    );

                    System.out.println(
                        "Posicion: fila " +
                        (filaMenor + 1) +
                        ", columna " +
                        (columnaMenor + 1)
                    );


                // ==============================
                // OPCION 6
                // CONTAR PARES
                // ==============================

                } else if (opcion == 6) {

                    int pares = 0;

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            if (matriz[i][j] % 2 == 0) {

                                pares++;

                            }

                        }

                    }

                    System.out.println(
                        "Cantidad de numeros pares: " + pares
                    );


                // ==============================
                // OPCION 7
                // CONTAR IMPARES
                // ==============================

                } else if (opcion == 7) {

                    int impares = 0;

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            if (matriz[i][j] % 2 != 0) {

                                impares++;

                            }

                        }

                    }

                    System.out.println(
                        "Cantidad de numeros impares: " + impares
                    );


                // ==============================
                // OPCION 8
                // MATRIZ DE CUADRADOS
                // ==============================

                } else if (opcion == 8) {

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            cuadrados[i][j] =
                                matriz[i][j] * matriz[i][j];

                        }

                    }

                    System.out.println();
                    System.out.println(
                        "===== MATRIZ DE CUADRADOS ====="
                    );

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            System.out.print(
                                cuadrados[i][j] + "\t"
                            );

                        }

                        System.out.println();
                    }


                // ==============================
                // OPCION 9
                // DIAGONAL PRINCIPAL
                // ==============================

                } else if (opcion == 9) {

                    int sumaDiagonal = 0;

                    for (int i = 0; i < 4; i++) {

                        sumaDiagonal =
                            sumaDiagonal + matriz[i][i];

                    }

                    System.out.println(
                        "La suma de la diagonal principal es: "
                        + sumaDiagonal
                    );


                // ==============================
                // OPCION 10
                // DIAGONAL INVERSA
                // ==============================

                } else if (opcion == 10) {

                    int sumaDiagonalInversa = 0;

                    for (int i = 0; i < 4; i++) {

                        sumaDiagonalInversa =
                            sumaDiagonalInversa +
                            matriz[i][3 - i];

                    }

                    System.out.println(
                        "La suma de la diagonal inversa es: "
                        + sumaDiagonalInversa
                    );


                // ==============================
                // OPCION 11
                // MEDIA
                // ==============================

                } else if (opcion == 11) {

                    int sumaTotal = 0;

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            sumaTotal =
                                sumaTotal + matriz[i][j];

                        }

                    }

                    double media = sumaTotal / 16.0;

                    System.out.println(
                        "La media de todos los valores es: "
                        + media
                    );
                }

            }

        } while (opcion != 12);


        System.out.println();
        System.out.println("Programa terminado.");

        sc.close();
    }
}
