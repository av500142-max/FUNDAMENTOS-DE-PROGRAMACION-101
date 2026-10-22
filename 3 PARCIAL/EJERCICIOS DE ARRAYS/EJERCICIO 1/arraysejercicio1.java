import java.util.Arrays;
import java.util.Scanner;
public class arraysejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        System.out.println(" Analisis de ventas por Sucursal ");

        // 1. Lectura de la cantidad de sucursales
        System.out.print("¿Cuantas sucursales deseas registrar?: ");
        int numSucursales = scanner.nextInt();
        scanner.nextLine(); 

        String[] sucursales = new String[numSucursales];
        double[][] ventas = new double[numSucursales][12];

        // 2. Registro de nombres y ventas mensuales por sucursal
        for (int i = 0; i < numSucursales; i++) {
            System.out.print("Ingrese el nombre de la sucursal #" + (i + 1) + ": ");
            sucursales[i] = scanner.nextLine();

            System.out.println("Ingreso de ventas para " + sucursales[i] + ":");
            for (int j = 0; j < 12; j++) {
                System.out.print(" - Venta de " + meses[j] + ": $");
                ventas[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); 
        }

        // 3. Procesamiento de los datos ingresados
        double[] totalesAnuales = new double[numSucursales];
        double[] promediosMensuales = new double[numSucursales];
        int[] indicesMejorMes = new int[numSucursales];
        double sumaGlobalVentas = 0;

        for (int i = 0; i < numSucursales; i++) {
            double sumaAnual = 0;
            double ventaMaxima = ventas[i][0];
            int mejorMesIdx = 0;

            for (int j = 0; j < 12; j++) {
                double ventaActual = ventas[i][j];
                sumaAnual += ventaActual;

                if (ventaActual > ventaMaxima) {
                    ventaMaxima = ventaActual;
                    mejorMesIdx = j;
                }
            }

            totalesAnuales[i] = sumaAnual;
            promediosMensuales[i] = sumaAnual / 12.0;
            indicesMejorMes[i] = mejorMesIdx;
            sumaGlobalVentas += sumaAnual;
        }

        double promedioGlobalVentas = sumaGlobalVentas / numSucursales;

        // DESEMPEÑO POR SUCURSAL
        System.out.println(" Reporte de ventas por Sucursal ");

        for (int i = 0; i < numSucursales; i++) {
            System.out.println(">>> " + sucursales[i] + " <<<");
            
            System.out.println("Ventas mensuales: " + Arrays.toString(ventas[i]));
            System.out.printf("Total anual: $%.2f%n", totalesAnuales[i]);
            System.out.printf("Promedio mensual: $%.2f%n", promediosMensuales[i]);
            System.out.printf("Mejor mes: %s (Venta: $%.2f)%n", 
                              meses[indicesMejorMes[i]], ventas[i][indicesMejorMes[i]]);
        }

        // SUCURSALES QUE SUPERAN EL PROMEDIO GLOBAL
        System.out.println(" Analisis Comparativo y Promedio Global ");
        System.out.printf("Promedio global de ventas anuales: $%.2f%n%n", promedioGlobalVentas);
        System.out.println("Sucursales que superan el promedio global:");

        boolean algunaSupera = false;
        for (int i = 0; i < numSucursales; i++) {
            if (totalesAnuales[i] > promedioGlobalVentas) {
                System.out.printf(" - %s (Total: $%.2f | Supera por: $%.2f)%n", 
                                  sucursales[i], totalesAnuales[i], (totalesAnuales[i] - promedioGlobalVentas));
                algunaSupera = true;
            }
        }

        if (!algunaSupera) {
            System.out.println(" - Todas las sucursales tienen ventas identicas al promedio global.");
        }

        // REPORTE 3: RANKING DE SUCURSALES (USANDO ARRAYS.COPYOF Y ARRAYS.SORPORT)
        double[] totalesOrdenados = Arrays.copyOf(totalesAnuales, totalesAnuales.length);

        // Ordenamos los totales de menor a mayor
        Arrays.sort(totalesOrdenados);

        System.out.println(" RANKING DE SUCURSALES (MAYOR A MENOR)");

        int posicion = 1;
        for (int i = totalesOrdenados.length - 1; i >= 0; i--) {
            double totalBuscado = totalesOrdenados[i];

            for (int j = 0; j < numSucursales; j++) {
                if (totalesAnuales[j] == totalBuscado) {
                    System.out.printf("%d. %-20s - Ventas Anuales: $%.2f%n", posicion++, sucursales[j], totalBuscado);
                    break;
                }
            }
        }
        scanner.close();
    }
}