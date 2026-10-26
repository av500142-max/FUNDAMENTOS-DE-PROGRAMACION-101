import java.util.Arrays;
import java.util.Scanner;

public class arraysejercicio2nuevo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numeros de Identificadores de Transacciones que se van a Ingresar ");
        int n = scanner.nextInt();

        int[] original = new int[n];
        System.out.println("Ingresa los " + n + " identificadores:");
        for (int i = 0; i < n; i++) {
            System.out.print(" - Elemento " + (i + 1) + ": ");
            original[i] = scanner.nextInt();
        }

        System.out.println("Arreglo original: " + Arrays.toString(original));

        // Copiar y ordenar para análisis de frecuencias usando métodos de Arrays
        int[] copiaOrdenada = Arrays.copyOf(original, original.length);
        Arrays.sort(copiaOrdenada);

        // Identificar duplicados únicos
        int[] duplicadosTemp = new int[copiaOrdenada.length];
        int countDupUnicos = 0;

        for (int i = 0; i < copiaOrdenada.length - 1; i++) {
            if (copiaOrdenada[i] == copiaOrdenada[i + 1]) {
                boolean yaExiste = false;
                for (int k = 0; k < countDupUnicos; k++) {
                    if (duplicadosTemp[k] == copiaOrdenada[i]) {
                        yaExiste = true;
                        break;
                    }
                }
                if (!yaExiste) {
                    duplicadosTemp[countDupUnicos++] = copiaOrdenada[i];
                }
            }
        }
        int[] duplicadosUnicos = Arrays.copyOf(duplicadosTemp, countDupUnicos);

        // Construir arreglo depurado conservando elementos únicos
        int[] depuradoTemp = new int[original.length];
        int countDepurado = 0;
        int registrosEliminados = 0;

        for (int i = 0; i < original.length; i++) {
            boolean yaIncluido = false;
            for (int j = 0; j < countDepurado; j++) {
                if (depuradoTemp[j] == original[i]) {
                    yaIncluido = true;
                    break;
                }
            }
            if (!yaIncluido) {
                depuradoTemp[countDepurado++] = original[i];
            } else {
                registrosEliminados++;
            }
        }

        // Ajustar el tamaño del arreglo con Arrays.copyOf()
        int[] depurado = Arrays.copyOf(depuradoTemp, countDepurado);
        
        // Ordenar el arreglo depurado inicial de menor a mayor
        Arrays.sort(depurado);

        // Resultados iniciales
        System.out.println("Arreglo depurado y ordenado: " + Arrays.toString(depurado));
        
        if (duplicadosUnicos.length > 0) {
            String idsDuplicadosStr = Arrays.toString(duplicadosUnicos);
            idsDuplicadosStr = idsDuplicadosStr.substring(1, idsDuplicadosStr.length() - 1);
            System.out.println("Identificadores repetidos: " + idsDuplicadosStr);
        } else {
            System.out.println("Identificadores repetidos: No se encontraron ");
        }
        
        System.out.println("Registros eliminados: " + registrosEliminados);

        // Bucle repetitivo para agregar elementos las veces que desee
        char respuesta;
        while (true) {
            System.out.print("Desea agregar un nuevo elemento al arreglo depurado, (s/n): ");
            respuesta = scanner.next().toLowerCase().charAt(0);

            if (respuesta == 'n') {
                System.out.println("Programa Finalizado");
                break;
            } else if (respuesta != 's') {
                System.out.println("Opcion no valida. Por favor, ingrese 's' para si o 'n' para no.");
                continue; // Vuelve a preguntar si se ingresa otra letra errónea
            }

            System.out.print("Ingrese el nuevo identificador: ");
            int nuevoElemento = scanner.nextInt();

            // Verificar si ya existe en el arreglo depurado
            boolean existeEnDepurado = false;
            for (int i = 0; i < depurado.length; i++) {
                if (depurado[i] == nuevoElemento) {
                    existeEnDepurado = true;
                    break;
                }
            }

            if (existeEnDepurado) {
                System.out.println("Error: El identificador " + nuevoElemento + " es un elemento repetido.");
            } else {
                // Ampliar el arreglo depurado usando Arrays.copyOf()
                depurado = Arrays.copyOf(depurado, depurado.length + 1);
                depurado[depurado.length - 1] = nuevoElemento;
                
                // Volver a ordenar para mantener el orden ascendente con el nuevo elemento incluido
                Arrays.sort(depurado);
                
                System.out.println("Elemento agregado con exito.");
                System.out.println("Arreglo depurado actualizado: " + Arrays.toString(depurado));
            }
        }

        scanner.close();
    }
}