import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

class Tarea {
    String identificador;
    String descripcion;
    int prioridad;
    boolean completada;

    public Tarea(String identificador, String descripcion, int prioridad) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }

    public String getIdentificador() { return identificador; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    @Override
    public String toString() {
        String estado = completada ? "[Completada]" : "[Pendiente]";
        return "ID: " + identificador + " | Descripcion: " + descripcion + " | Prioridad: " + prioridad + " " + estado;
    }
}

public class GestionTareasLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Tarea> listaTareas = new LinkedList<>();
        int opcion;

        do {
            System.out.println("SISTEMA DE GESTION DE TAREAS (LinkedList)");
            System.out.println("1. Registrar tarea al final");
            System.out.println("2. Registrar tarea al inicio");
            System.out.println("3. Insertar tarea en una posicion especifica");
            System.out.println("4. Eliminar tarea por identificador");
            System.out.println("5. Buscar tarea por descripcion");
            System.out.println("6. Mostrar todas las tareas pendientes");
            System.out.println("7. Marcar tarea como completada");
            System.out.println("8. Mostrar primera y ultima tarea registrada");
            System.out.println("9. Recorrer la lista en orden inverso");
            System.out.println("10. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Identificador: ");
                    String id1 = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String desc1 = scanner.nextLine();
                    System.out.print("Prioridad (numero): ");
                    int prio1 = scanner.nextInt();
                    listaTareas.addLast(new Tarea(id1, desc1, prio1));
                    System.out.println("Tarea agregada al final.");
                    break;

                case 2:
                    System.out.print("Identificador: ");
                    String id2 = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String desc2 = scanner.nextLine();
                    System.out.print("Prioridad (numero): ");
                    int prio2 = scanner.nextInt();
                    listaTareas.addFirst(new Tarea(id2, desc2, prio2));
                    System.out.println("Tarea agregada al inicio.");
                    break;

                case 3:
                    System.out.print("Ingrese la posicion indice donde desea insertarla (0 a " + listaTareas.size() + "): ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    if (pos >= 0 && pos <= listaTareas.size()) {
                        System.out.print("Identificador: ");
                        String id3 = scanner.nextLine();
                        System.out.print("Descripcion: ");
                        String desc3 = scanner.nextLine();
                        System.out.print("Prioridad (numero): ");
                        int prio3 = scanner.nextInt();
                        listaTareas.add(pos, new Tarea(id3, desc3, prio3));
                        System.out.println("Tarea insertada en la posicion " + pos);
                    } else {
                        System.out.println("Posición invalida.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el identificador de la tarea a eliminar: ");
                    String elimId = scanner.nextLine();
                    boolean encontradaElim = false;
                    for (int i = 0; i < listaTareas.size(); i++) {
                        if (listaTareas.get(i).getIdentificador().equalsIgnoreCase(elimId)) {
                            listaTareas.remove(i);
                            System.out.println("Tarea eliminada con exito");
                            encontradaElim = true;
                            break;
                        }
                    }
                    if (!encontradaElim) System.out.println("No se encontro ninguna tarea con ese ID.");
                    break;

                case 5:
                    System.out.print("Ingrese texto a buscar en la descripcion: ");
                    String textBusq = scanner.nextLine().toLowerCase();
                    boolean huboResultados = false;
                    System.out.println("Resultados de Busqueda");
                    for (Tarea t : listaTareas) {
                        if (t.getDescripcion().toLowerCase().contains(textBusq)) {
                            System.out.println(t);
                            huboResultados = true;
                        }
                    }
                    if (!huboResultados) System.out.println("No se encontraron coincidencias.");
                    break;

                case 6:
                    if (listaTareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                    } else {
                        System.out.println("Lista de Tareas");
                        for (Tarea t : listaTareas) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el identificador de la tarea a marcar como completada: ");
                    String compId = scanner.nextLine();
                    boolean marcada = false;
                    for (Tarea t : listaTareas) {
                        if (t.getIdentificador().equalsIgnoreCase(compId)) {
                            t.setCompletada(true);
                            System.out.println("Tarea marcada como completada");
                            marcada = true;
                            break;
                        }
                    }
                    if (!marcada) System.out.println("Tarea no encontrada.");
                    break;

                case 8:
                    if (listaTareas.isEmpty()) {
                        System.out.println("La lista esta vacía.");
                    } else {
                        System.out.println("Primera tarea: " + listaTareas.getFirst());
                        System.out.println("Ultima tarea: " + listaTareas.getLast());
                    }
                    break;

                case 9:
                    if (listaTareas.isEmpty()) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        System.out.println("Tareas en Orden Inverso");
                        Iterator<Tarea> it = listaTareas.descendingIterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                    }
                    break;

                case 10:
                    System.out.println("Saliendo del gestor de tareas");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 10);
        scanner.close();
    }
}