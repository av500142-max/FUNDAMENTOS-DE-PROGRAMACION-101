import java.util.Arrays;
import java.util.Scanner;

public class arrayejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuantos identificadores de transacciones vas a ingresar? ");
        int n = scanner.nextInt();

        int[] original = new int[n];
        System.out.println("Ingresa los " + n + " identificadores (pueden incluir duplicados):");
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

        // Construir arreglo depurado conservando orden original
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

        // Resultados
        System.out.println("Arreglo depurado: " + Arrays.toString(depurado));
        
        if (duplicadosUnicos.length > 0) {
            String idsDuplicadosStr = Arrays.toString(duplicadosUnicos);
            idsDuplicadosStr = idsDuplicadosStr.substring(1, idsDuplicadosStr.length() - 1);
            System.out.println("Identificadores duplicados: " + idsDuplicadosStr);
        } else {
            System.out.println("Identificadores duplicados: Ninguno");
        }
        
        System.out.println("Registros eliminados: " + registrosEliminados);

        scanner.close();
    }
}

