import java.util.Scanner;

public class calificacionesexamen {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, m;

        System.out.print("¿Cuantos estudiantes hay? ");
        n = sc.nextInt();

        System.out.print("¿Cuantos examenes hay? ");
        m = sc.nextInt();

        double[][] notas = new double[n][m];

        // =================================
        // CAPTURAR CALIFICACIONES
        // =================================

        System.out.println("\nCAPTURA DE CALIFICACIONES");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(
                    "Estudiante " + (i + 1) +
                    ", examen " + (j + 1) + ": "
                );

                notas[i][j] = sc.nextDouble();
            }
        }

        // =================================
        // MOSTRAR MATRIZ
        // =================================

        System.out.println("\nMATRIZ DE CALIFICACIONES");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(notas[i][j] + "   ");
            }

            System.out.println();
        }

        // =================================
        // PROMEDIO DE CADA ESTUDIANTE
        // =================================

        System.out.println("\nPROMEDIO DE CADA ESTUDIANTE");

        double mejorPromedio = -1;

        for (int i = 0; i < n; i++) {

            double suma = 0;

            for (int j = 0; j < m; j++) {

                suma = suma + notas[i][j];
            }

            double promedio = suma / m;

            System.out.println(
                "Estudiante " + (i + 1) +
                ": " + promedio
            );

            if (promedio > mejorPromedio) {

                mejorPromedio = promedio;
            }
        }

        // =================================
        // MEJOR ESTUDIANTE
        // =================================

        System.out.println("\nMEJOR ESTUDIANTE");

        for (int i = 0; i < n; i++) {

            double suma = 0;

            for (int j = 0; j < m; j++) {

                suma = suma + notas[i][j];
            }

            double promedio = suma / m;

            if (promedio == mejorPromedio) {

                System.out.println(
                    "Estudiante " + (i + 1) +
                    " con promedio " + promedio
                );
            }
        }

        // =================================
        // ESTUDIANTES ENTRE 9 Y 10
        // =================================

        System.out.println(
            "\nESTUDIANTES CON PROMEDIO ENTRE 9 Y 10"
        );

        for (int i = 0; i < n; i++) {

            double suma = 0;

            for (int j = 0; j < m; j++) {

                suma = suma + notas[i][j];
            }

            double promedio = suma / m;

            if (promedio >= 9 && promedio <= 10) {

                System.out.println(
                    "Estudiante " + (i + 1) +
                    " - Promedio: " + promedio
                );
            }
        }

        // =================================
        // ESTUDIANTES MENORES DE 7
        // =================================

        System.out.println(
            "\nESTUDIANTES CON PROMEDIO MENOR A 7"
        );

        for (int i = 0; i < n; i++) {

            double suma = 0;

            for (int j = 0; j < m; j++) {

                suma = suma + notas[i][j];
            }

            double promedio = suma / m;

            if (promedio < 7) {

                System.out.println(
                    "Estudiante " + (i + 1) +
                    " - Promedio: " + promedio
                );
            }
        }

        // =================================
        // PROMEDIO DE CADA EXAMEN
        // =================================

        System.out.println("\nPROMEDIO DE CADA EXAMEN");

        double mayorExamen = -1;
        double menorExamen = 11;

        int examenMayor = 0;
        int examenMenor = 0;

        for (int j = 0; j < m; j++) {

            double sumaExamen = 0;

            for (int i = 0; i < n; i++) {

                sumaExamen = sumaExamen + notas[i][j];
            }

            double promedioExamen = sumaExamen / n;

            System.out.println(
                "Examen " + (j + 1) +
                ": " + promedioExamen
            );

            if (promedioExamen > mayorExamen) {

                mayorExamen = promedioExamen;
                examenMayor = j + 1;
            }

            if (promedioExamen < menorExamen) {

                menorExamen = promedioExamen;
                examenMenor = j + 1;
            }
        }

        // =================================
        // RESULTADOS FINALES
        // =================================

        System.out.println("\nEXAMEN CON MAYOR PROMEDIO");

        System.out.println(
            "Examen " + examenMayor +
            " con promedio " + mayorExamen
        );

        System.out.println("\nEXAMEN CON MENOR PROMEDIO");

        System.out.println(
            "Examen " + examenMenor +
            " con promedio " + menorExamen
        );

        sc.close();
    }
}