import java.util.Scanner;
public class arreglosunidimensionales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // EL USUARIO DECIDE EL TAMAÑO DEL ARREGLO
        System.out.print("¿Que tamaño quiere que tenga el arreglo? ");
        int capacidad = sc.nextInt();

        while (capacidad <= 0) {
            System.out.println("El tamaño del arreglo debe ser mayor que 0.");
            System.out.print("¿Que tamaño quieres que tenga el arreglo? ");
            capacidad = sc.nextInt();
        }

        // Crear arreglo con el tamaño elegido
        int[] numeros = new int[capacidad];

        // El usuario decide cuantos elementos ingresar inicialmente
        System.out.print(
            "¿Cuantos elementos quiere ingresar inicialmente? "
        );
        int cantidad = sc.nextInt();

        while (cantidad < 0 || cantidad > capacidad) {
            System.out.println(
                "La cantidad debe estar entre 0 y " + capacidad
            );

            System.out.print(
                "¿Cuantos elementos quiere ingresar inicialmente? "
            );

            cantidad = sc.nextInt();
        }

        // INGRESAR ELEMENTOS
        for (int i = 0; i < cantidad; i++) {

            System.out.print(
                "Ingresa el elemento " + (i + 1) + ": "
            );

            numeros[i] = sc.nextInt();
        }

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println(" MENU DE ARREGLOS");
            System.out.println("==============================");
            System.out.println("1. Mostrar el arreglo");
            System.out.println("2. Agregar un elemento");
            System.out.println("3. Eliminar un elemento");
            System.out.println("4. Modificar un elemento");
            System.out.println("5. Busqueda lineal");
            System.out.println("6. Busqueda binaria");
            System.out.println("7. Ordenamiento burbuja");
            System.out.println("8. Ordenamiento insercion");
            System.out.println("9. Ordenamiento seleccion");
            System.out.println("10. Salir");
            System.out.println("==============================");

            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                // MOSTRAR
                case 1:

                    System.out.println("\nArreglo Actual:");

                    for (int i = 0; i < cantidad; i++) {
                        System.out.print(numeros[i] + " ");
                    }

                    System.out.println();

                    System.out.println(
                        "Elementos: " + cantidad +
                        " / Capacidad: " + capacidad
                    );

                    break;


                // AGREGAR
                case 2:

                    if (cantidad == capacidad) {

                        System.out.println(
                            "\nNo se pueden agregar mas elementos."
                        );

                        System.out.println(
                            "El arreglo esta lleno (" +
                            capacidad +
                            " elementos)."
                        );

                        System.out.println(
                            "Elimina primero un elemento para liberar espacio."
                        );

                    } else {

                        System.out.print(
                            "\nIngresa el elemento que quieres agregar: "
                        );

                        int nuevo = sc.nextInt();

                        numeros[cantidad] = nuevo;

                        cantidad++;

                        System.out.println(
                            "Elemento agregado correctamente."
                        );
                    }

                    break;


                // ELIMINAR
                case 3:

                    if (cantidad == 0) {

                        System.out.println(
                            "\nEl arreglo esta vacio."
                        );

                    } else {

                        System.out.print(
                            "\nIngresa el elemento que quieres eliminar: "
                        );

                        int eliminar = sc.nextInt();

                        int posicion = -1;

                        // Buscar elemento
                        for (int i = 0; i < cantidad; i++) {

                            if (numeros[i] == eliminar) {

                                posicion = i;
                                break;
                            }
                        }

                        if (posicion == -1) {

                            System.out.println(
                                "El elemento no se encuentra."
                            );

                        } else {

                            // Mover elementos a la izquierda
                            for (
                                int i = posicion;
                                i < cantidad - 1;
                                i++
                            ) {

                                numeros[i] = numeros[i + 1];
                            }

                            cantidad--;

                            System.out.println(
                                "Elemento eliminado correctamente."
                            );
                        }
                    }

                    break;
                // MODIFICAR
                case 4:

                if (cantidad == 0) {

                  System.out.println(
                 "\nEl arreglo esta vacio."
                 );

                 } else {

                 System.out.print(
                 "\nIngresa el elemento que quieres modificar: "
                 );

        int modificar = sc.nextInt();

        int posicion = -1;

        // Buscar el elemento
        for (int i = 0; i < cantidad; i++) {

            if (numeros[i] == modificar) {

                posicion = i;
                break;
            }
        }

        if (posicion == -1) {

            System.out.println(
                "El elemento no se encuentra."
            );

        } else {

            System.out.print(
                "Ingresa el nuevo valor: "
            );

            int nuevoValor = sc.nextInt();

            // Reemplazar en la misma posicion
            numeros[posicion] = nuevoValor;

            System.out.println(
                "Elemento modificado correctamente."
            );

            System.out.println(
                "La posicion se mantuvo en: " + posicion
            );
        }
    }

    break;

                // BUSQUEDA LINEAL
                case 5:

                    System.out.print(
                        "\n¿Que numero quieres buscar? "
                    );

                    int buscado = sc.nextInt();

                    int posicion = -1;

                    for (int i = 0; i < cantidad; i++) {

                        if (numeros[i] == buscado) {

                            posicion = i;
                            break;
                        }
                    }

                    if (posicion != -1) {

                        System.out.println(
                            "Elemento encontrado en la posicion "
                            + posicion
                        );

                    } else {

                        System.out.println(
                            "Elemento no encontrado."
                        );
                    }

                    break;


                // BUSQUEDA BINARIA
                case 6:

                    if (cantidad == 0) {

                        System.out.println(
                            "El arreglo esta vacio."
                        );

                        break;
                    }

                    int[] copia = new int[cantidad];

                    // Copiar arreglo
                    for (int i = 0; i < cantidad; i++) {

                        copia[i] = numeros[i];
                    }

                    // Ordenar copia
                    for (int i = 0; i < copia.length - 1; i++) {

                        for (
                            int j = 0;
                            j < copia.length - 1 - i;
                            j++
                        ) {

                            if (copia[j] > copia[j + 1]) {

                                int aux = copia[j];

                                copia[j] = copia[j + 1];

                                copia[j + 1] = aux;
                            }
                        }
                    }

                    System.out.print(
                        "\nArreglo ordenado: "
                    );

                    for (int i = 0; i < copia.length; i++) {

                        System.out.print(copia[i] + " ");
                    }

                    System.out.print(
                        "\n¿Que numero quieres buscar? "
                    );

                    buscado = sc.nextInt();

                    int inicio = 0;
                    int fin = copia.length - 1;

                    posicion = -1;

                    while (inicio <= fin) {

                        int medio = (inicio + fin) / 2;

                        if (copia[medio] == buscado) {

                            posicion = medio;
                            break;

                        } else if (buscado < copia[medio]) {

                            fin = medio - 1;

                        } else {

                            inicio = medio + 1;
                        }
                    }

                    if (posicion != -1) {

                        System.out.println(
                            "Elemento encontrado en la posicion "
                            + posicion +
                            " del arreglo ordenado."
                        );

                    } else {

                        System.out.println(
                            "Elemento no encontrado."
                        );
                    }

                    break;


                // BURBUJA
                case 7:

                    copia = new int[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        copia[i] = numeros[i];
                    }

                    for (int i = 0; i < copia.length - 1; i++) {

                        for (
                            int j = 0;
                            j < copia.length - 1 - i;
                            j++
                        ) {

                            if (copia[j] > copia[j + 1]) {

                                int aux = copia[j];

                                copia[j] = copia[j + 1];

                                copia[j + 1] = aux;
                            }
                        }
                    }

                    System.out.println(
                        "\nOrdenamiento por BURBUJA:"
                    );

                    for (int i = 0; i < copia.length; i++) {

                        System.out.print(copia[i] + " ");
                    }

                    System.out.println();

                    break;


                // INSERCION
                case 8:

                    copia = new int[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        copia[i] = numeros[i];
                    }

                    for (int i = 1; i < copia.length; i++) {

                        int aux = copia[i];

                        int j = i - 1;

                        while (j >= 0 && copia[j] > aux) {

                            copia[j + 1] = copia[j];

                            j--;
                        }

                        copia[j + 1] = aux;
                    }

                    System.out.println(
                        "\nOrdenamiento por INSERCION:"
                    );

                    for (int i = 0; i < copia.length; i++) {

                        System.out.print(copia[i] + " ");
                    }

                    System.out.println();

                    break;


                // SELECCION
                case 9:

                    copia = new int[cantidad];

                    for (int i = 0; i < cantidad; i++) {

                        copia[i] = numeros[i];
                    }

                    for (int i = 0; i < copia.length - 1; i++) {

                        int posicionMenor = i;

                        for (
                            int j = i + 1;
                            j < copia.length;
                            j++
                        ) {

                            if (
                                copia[j] <
                                copia[posicionMenor]
                            ) {

                                posicionMenor = j;
                            }
                        }

                        int aux = copia[i];

                        copia[i] = copia[posicionMenor];

                        copia[posicionMenor] = aux;
                    }

                    System.out.println(
                        "\nOrdenamiento por SELECCION:"
                    );

                    for (int i = 0; i < copia.length; i++) {

                        System.out.print(copia[i] + " ");
                    }

                    System.out.println();

                    break;


                // SALIR
                case 10:

                    System.out.println(
                        "\nPrograma terminado."
                    );

                    break;


                default:

                    System.out.println(
                        "\nOpcion no valida."
                    );
            }

        } while (opcion != 9);

        sc.close();
    }
}
