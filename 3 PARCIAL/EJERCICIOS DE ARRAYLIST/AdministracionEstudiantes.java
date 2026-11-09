import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
class Estudiante {
    String matricula;
    String nombre;
    double calificacion;

    public Estudiante(String matricula, String nombre, double calificacion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getMatricula() { return matricula; }
    public String getNombre() { return nombre; }
    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }

    @Override
    public String toString() {
        return "Matricula: " + matricula + " , Nombre: " + nombre + " , Calificacion: " + calificacion;
    }
}

public class AdministracionEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        int opcion;

        do {
            System.out.println("SISTEMA DE ADMINISTRACION DE ESTUDIANTES");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Ordenar alfabeticamente");
            System.out.println("3. Buscar matricula");
            System.out.println("4. Modificar calificacion");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Mostrar promedio general del grupo");
            System.out.println("7. Calificacion mas alta y mas baja");
            System.out.println("8. Mostrar estudiantes con calificacion mayor a 9");
            System.out.println("9. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su matricula: ");
                    String mat = scanner.nextLine();
                    
                    // Verificar duplicados 
                    boolean existe = false;
                    for (Estudiante e : listaEstudiantes) {
                        if (e.getMatricula().equalsIgnoreCase(mat)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Error: Matricula detectada como Duplicado.");
                    } else {
                        System.out.print("Ingrese nombre: ");
                        String nom = scanner.nextLine();
                        System.out.print("Ingrese calificacion: ");
                        double cal = scanner.nextDouble();
                        listaEstudiantes.add(new Estudiante(mat, nom, cal));
                        System.out.println("¡Estudiante registrado con exito!");
                    }
                    break;

                case 2:
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        // Ordenar alfabéticamente
                        ArrayList<Estudiante> copiaOrdenada = new ArrayList<>(listaEstudiantes);
                        copiaOrdenada.sort(Comparator.comparing(Estudiante::getNombre, String.CASE_INSENSITIVE_ORDER));
                        System.out.println("Lista de Estudiantes:");
                        for (Estudiante e : copiaOrdenada) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la matricula: ");
                    String busqMat = scanner.nextLine();
                    boolean encontrado = false;
                    for (Estudiante e : listaEstudiantes) {
                        if (e.getMatricula().equalsIgnoreCase(busqMat)) {
                            System.out.println("Estudiante encontrado: " + e);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Estudiante no encontrado.");
                    break;

                case 4:
                    System.out.print("Ingrese la matricula del estudiante a modificar: ");
                    String modMat = scanner.nextLine();
                    boolean modificado = false;
                    for (Estudiante e : listaEstudiantes) {
                        if (e.getMatricula().equalsIgnoreCase(modMat)) {
                            System.out.print("Ingrese la nueva calificacion: ");
                            e.setCalificacion(scanner.nextDouble());
                            System.out.println("¡Calificacion actualizada con exito!");
                            modificado = true;
                            break;
                        }
                    }
                    if (!modificado) System.out.println("Estudiante no encontrado.");
                    break;

                case 5:
                    System.out.print("Ingrese la matricula que se va a eliminar: ");
                    String elimMat = scanner.nextLine();
                    boolean eliminado = false;
                    for (int i = 0; i < listaEstudiantes.size(); i++) {
                        if (listaEstudiantes.get(i).getMatricula().equalsIgnoreCase(elimMat)) {
                            listaEstudiantes.remove(i);
                            System.out.println("¡Estudiante eliminado correctamente!");
                            eliminado = true;
                            break;
                        }
                    }
                    if (!eliminado) System.out.println("Estudiante no encontrado.");
                    break;

                case 6:
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes para calcular promedio.");
                    } else {
                        double suma = 0;
                        for (Estudiante e : listaEstudiantes) {
                            suma += e.getCalificacion();
                        }
                        double promedio = suma / listaEstudiantes.size();
                        System.out.println("Promedio general del grupo: " + promedio);
                    }
                    break;

                case 7:
                    if (listaEstudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        Estudiante masAlto = listaEstudiantes.get(0);
                        Estudiante masBajo = listaEstudiantes.get(0);
                        for (Estudiante e : listaEstudiantes) {
                            if (e.getCalificacion() > masAlto.getCalificacion()) masAlto = e;
                            if (e.getCalificacion() < masBajo.getCalificacion()) masBajo = e;
                        }
                        System.out.println("Calificacion mas alta: " + masAlto);
                        System.out.println("Calificacion mas baja: " + masBajo);
                    }
                    break;

                case 8:
                    System.out.println("Estudiantes con promedio mayor a 9");
                    boolean hayMayores = false;
                    for (Estudiante e : listaEstudiantes) {
                        if (e.getCalificacion() > 9) {
                            System.out.println(e);
                            hayMayores = true;
                        }
                    }
                    if (!hayMayores) System.out.println("No hay estudiantes con calificacion superior a 9.");
                    break;

                case 9:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 9);
        scanner.close();
    }
}