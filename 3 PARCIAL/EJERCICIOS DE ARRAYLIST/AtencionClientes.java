import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    int turno;
    String nombre;

    public Cliente(int turno, String nombre) {
        this.turno = turno;
        this.nombre = nombre;
    }

    public int getTurno() { return turno; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Turno: [" + turno + "] - Cliente: " + nombre;
    }
}

public class AtencionClientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> colaClientes = new ArrayList<>();
        int contadorTurnos = 1;
        int opcion;

        do {
            System.out.println("SISTEMA DE ATENCION DE CLIENTES");
            System.out.println("1. Registrar un nuevo cliente y numero de turno");
            System.out.println("2. Atender siguiente cliente");
            System.out.println("3. Mostrar siguiente cliente a atender");
            System.out.println("4. Mostrar los clientes pendientes");
            System.out.println("5. Consultar cuantos clientes estan esperando");
            System.out.println("6. Cancelar un turno");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    // Agregar al final de la cola
                    colaClientes.add(new Cliente(contadorTurnos, nombre));
                    System.out.println("Cliente registrado, el numero de turno asignado es: " + contadorTurnos);
                    contadorTurnos++;
                    break;

                case 2:
                    if (colaClientes.isEmpty()) {
                        System.out.println("No hay ningun cliente en la fila de espera.");
                    } else {
                        // Atender al primero de la fila
                        Cliente atendido = colaClientes.remove(0);
                        System.out.println("Atendiendo a: " + atendido);
                    }
                    break;

                case 3:
                    if (colaClientes.isEmpty()) {
                        System.out.println("La fila esta vacia.");
                    } else {
                        System.out.println("El siguiente en la fila es: " + colaClientes.get(0));
                    }
                    break;

                case 4:
                    if (colaClientes.isEmpty()) {
                        System.out.println("No hay clientes pendientes.");
                    } else {
                        System.out.println("Clientes que siguen en espera");
                        for (Cliente c : colaClientes) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Clientes esperando actualmente: " + colaClientes.size());
                    break;

                case 6:
                    System.out.print("Ingrese el numero de turno del cliente que cancelo su cita: ");
                    int turnoCancel = scanner.nextInt();
                    boolean cancelado = false;
                    for (int i = 0; i < colaClientes.size(); i++) {
                        if (colaClientes.get(i).getTurno() == turnoCancel) {
                            colaClientes.remove(i);
                            System.out.println("El turno " + turnoCancel + " ha sido cancelado y removido de la fila");
                            cancelado = true;
                            break;
                        }
                    }
                    if (!cancelado) System.out.println("Error: No se encontro a ningun cliente con ese numero de turno.");
                    break;

                case 7:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 7);
        scanner.close();
    }
}
