import java.util.Scanner;
public class arreglosbidimensionales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // NUMERO DE FILAS Y COLUMNAS
        
        System.out.print("¿Cuantas filas vamos a Agregar? ");
        int filas = sc.nextInt();

        while (filas <= 0) {
            System.out.println("Las filas deben ser mayores que 0.");
            System.out.print("¿Cuantas filas quiere? ");
            filas = sc.nextInt();
        }

        System.out.print("¿Cuantas columnas vamos a Agregar? ");
        int columnas = sc.nextInt();

        while (columnas <= 0) {
            System.out.println("Las columnas deben ser mayores que 0.");
            System.out.print("¿Cuantas columnas quiere? ");
            columnas = sc.nextInt();
        }

        // Crear arreglo bidimensional
        int[][] numeros = new int[filas][columnas];

        // INGRESAR ELEMENTOS

        System.out.println("\nINGRESA LOS ELEMENTOS");

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print(
                    "Elemento [" + i + "][" + j + "]: "
                );

                numeros[i][j] = sc.nextInt();
            }
        }

        int opcion;

        do {

            // MENU DE ARREGLO BIDIMENSIONAL

            System.out.println("\n==============================");
            System.out.println(" MENU DE ARREGLO BIDIMENSIONAL");
            System.out.println("==============================");
            System.out.println("1. Mostrar la matriz");
            System.out.println("2. Agregar un elemento");
            System.out.println("3. Modificar un elemento");
            System.out.println("4. Eliminar un elemento");
            System.out.println("5. Buscar un elemento");
            System.out.println("6. Ordenar por burbuja");
            System.out.println("7. Ordenar por seleccion");
            System.out.println("8. Salir");
            System.out.println("==============================");

            System.out.print("Elige una de las siguientes opciones que te presentan: ");
            opcion = sc.nextInt();


            switch (opcion) {

                // MOSTRAR

                case 1:

                    System.out.println("\nMATRIZ:");

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            System.out.print(
                                numeros[i][j] + "\t"
                            );
                        }

                        System.out.println();
                    }

                    break;

                // AGREGAR

                case 2:

                    System.out.print(
                        "\n¿En que fila quieres agregar el elemento? "
                    );

                    int filaAgregar = sc.nextInt();

                    System.out.print(
                        "¿En que columna quieres agregar el elemento? "
                    );

                    int columnaAgregar = sc.nextInt();


                    if (
                        filaAgregar >= 0 &&
                        filaAgregar < filas &&
                        columnaAgregar >= 0 &&
                        columnaAgregar < columnas
                    ) {

                        System.out.print(
                            "Ingresa el nuevo elemento: "
                        );

                        int nuevo = sc.nextInt();

                        numeros[filaAgregar][columnaAgregar] = nuevo;

                        System.out.println(
                            "Elemento agregado correctamente."
                        );

                    } else {

                        System.out.println(
                            " ERROR, Posicion fuera de rango."
                        );
                    }

                    break;

                // MODIFICAR

                case 3:

                    System.out.print(
                        "\n¿Que elemento quieres modificar? "
                    );

                    int modificar = sc.nextInt();

                    int filaModificar = -1;
                    int columnaModificar = -1;


                    // Buscar elemento
                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            if (numeros[i][j] == modificar) {

                                filaModificar = i;
                                columnaModificar = j;

                                break;
                            }
                        }

                        if (filaModificar != -1) {
                            break;
                        }
                    }


                    if (filaModificar == -1) {

                        System.out.println(
                            "El elemento no se encuentra."
                        );

                    } else {

                        System.out.print(
                            "Ingresa el nuevo valor: "
                        );

                        int nuevoValor = sc.nextInt();

                        numeros[filaModificar][columnaModificar]
                            = nuevoValor;

                        System.out.println(
                            "Elemento modificado correctamente."
                        );

                        System.out.println(
                            "Se mantuvo en la posicion [" +
                            filaModificar + "][" +
                            columnaModificar + "]"
                        );
                    }

                    break;

                // ELIMINAR

                case 4:

                    System.out.print(
                        "\n¿Que elemento quieres eliminar? "
                    );

                    int eliminar = sc.nextInt();

                    int filaEliminar = -1;
                    int columnaEliminar = -1;


                    // Buscar elemento
                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            if (numeros[i][j] == eliminar) {

                                filaEliminar = i;
                                columnaEliminar = j;

                                break;
                            }
                        }

                        if (filaEliminar != -1) {
                            break;
                        }
                    }


                    if (filaEliminar == -1) {

                        System.out.println(
                            "El elemento no se encuentra."
                        );

                    } else {

                        // Se coloca 0 en la posicion
                        numeros[filaEliminar][columnaEliminar] = 0;

                        System.out.println(
                            "Elemento eliminado correctamente."
                        );

                        System.out.println(
                            "La posicion [" +
                            filaEliminar + "][" +
                            columnaEliminar +
                            "] ahora contiene 0."
                        );
                    }

                    break;


                // BUSCAR

                case 5:

                    System.out.print(
                        "\n¿Que elemento quiere buscar? "
                    );

                    int buscar = sc.nextInt();

                    boolean encontrado = false;


                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            if (numeros[i][j] == buscar) {

                                System.out.println(
                                    "Elemento encontrado en [" +
                                    i + "][" + j + "]"
                                );

                                encontrado = true;
                            }
                        }
                    }


                    if (!encontrado) {

                        System.out.println(
                            "Elemento no encontrado."
                        );
                    }

                    break;


                // BURBUJA

                case 6:

                    /*
                     * Se recorre toda la matriz como si
                     * fuera una lista de elementos.
                     */

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            for (int f = 0; f < filas; f++) {

                                for (int c = 0; c < columnas - 1; c++) {

                                    if (
                                        numeros[f][c] >
                                        numeros[f][c + 1]
                                    ) {

                                        int aux =
                                            numeros[f][c];

                                        numeros[f][c] =
                                            numeros[f][c + 1];

                                        numeros[f][c + 1] =
                                            aux;
                                    }
                                }
                            }
                        }
                    }


                    System.out.println(
                        "\nMatriz ordenada por BURBUJA:"
                    );

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            System.out.print(
                                numeros[i][j] + "\t"
                            );
                        }

                        System.out.println();
                    }

                    break;


                // SELECCION

                case 7:

                    /*
                     * Ordenamiento por seleccion
                     * dentro de cada fila.
                     */

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas - 1; j++) {

                            int posicionMenor = j;

                            for (
                                int k = j + 1;
                                k < columnas;
                                k++
                            ) {

                                if (
                                    numeros[i][k] <
                                    numeros[i][posicionMenor]
                                ) {

                                    posicionMenor = k;
                                }
                            }


                            int aux =
                                numeros[i][j];

                            numeros[i][j] =
                                numeros[i][posicionMenor];

                            numeros[i][posicionMenor] =
                                aux;
                        }
                    }


                    System.out.println(
                        "\nMatriz ordenada por SELECCION:"
                    );

                    for (int i = 0; i < filas; i++) {

                        for (int j = 0; j < columnas; j++) {

                            System.out.print(
                                numeros[i][j] + "\t"
                            );
                        }

                        System.out.println();
                    }

                    break;


                // SALIR

                case 8:

                    System.out.println(
                        "\n El Programa ha Finalizado."
                    );

                    break;


                default:

                    System.out.println(
                        "\nError, Opcion no valida."
                    );
            }

        } while (opcion != 8);


        sc.close();
    }
}
