import java.util.Scanner;

public class colasmenu {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño de la cola: ");
        int tamanio = teclado.nextInt();
        
        ColaArreglo cola = new ColaArreglo(tamanio);
        int opcion;

        do {
            // El menú muestra dinámicamente las posiciones del Frente y del Final
            System.out.println("MENU DE LA COLA (Frente: " + cola.getFrente() + " | Final: " + cola.getFinal() + ")");
            System.out.println("1. Colocar un elemento");
            System.out.println("2. Eliminar elementos uno por uno");
            System.out.println("3. Eliminar elemento especifico");
            System.out.println("4. Mostrar cola completa");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento: ");
                    int valor = teclado.nextInt();
                    cola.enqueue(valor);
                    cola.mostrarCola(); // Muestra la cola actualizada
                    break;
                case 2:
                    cola.dequeue(); // Saca el elemento del frente de uno en uno
                    cola.mostrarCola(); // Muestra la cola actualizada
                    break;
                case 3:
                    System.out.print("Ingrese el elemento exacto que desea eliminar: ");
                    int elementoAEliminar = teclado.nextInt();
                    cola.eliminarElemento(elementoAEliminar);
                    cola.mostrarCola(); // Muestra la cola actualizada
                    break;
                case 4:
                    cola.mostrarCola(); // Opción explícita para ver el estado actual
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);

        teclado.close();
    }
}

class ColaArreglo {
    private int[] cola;
    private int frente;
    private int fin;
    private int capacidad;

    public ColaArreglo(int tamanio) {
        this.capacidad = tamanio;
        this.cola = new int[tamanio];
        this.frente = 0;
        this.fin = -1; // -1 significa que no hay elementos formados aún
    }

    public int getFrente() {
        return this.frente;
    }

    public int getFinal() {
        return this.fin;
    }

    public boolean estaLlena() {
        return fin == capacidad - 1;
    }

    public boolean estaVacia() {
        return frente > fin;
    }

    // ENQUEUE con alerta de Cola Llena / Desbordamiento (Overflow)
    public void enqueue(int elemento) {
        if (estaLlena()) {
            System.out.println("ERROR: Cola Llena - Desbordamiento (Overflow)");
        } else {
            fin++;
            cola[fin] = elemento;
            System.out.println("Elemento [" + elemento + "] encolado al final (Posicion " + fin + ").");
        }
    }

    // DEQUEUE estándar: Elimina el elemento que está al frente uno por uno
    public void dequeue() {
        if (estaVacia()) {
            System.out.println("ERROR: Cola Vacia - Subdesbordamiento (Underflow)");
            return;
        }
        int eliminado = cola[frente];
        frente++;
        System.out.println("Elemento del frente [" + eliminado + "] atendido y eliminado de la cola.");
    }

    // Método auxiliar interno para extracciones directas
    public int dequeueDirecto() {
        int eliminado = cola[frente];
        frente++;
        return eliminado;
    }

    // Método que fuerza la regla FIFO eliminando automáticamente los que llegaron primero
    public void eliminarElemento(int objetivo) {
        if (estaVacia()) {
            System.out.println("ERROR: Cola Vacia - Subdesbordamiento (Underflow).");
            return;
        }

        // Buscamos en qué índice de la cola está el elemento solicitado
        int indiceEncontrado = -1;
        for (int i = frente; i <= fin; i++) {
            if (cola[i] == objetivo) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("El elemento " + objetivo + " no existe en la cola.");
            return;
        }

        // Respetando FIFO: Si el elemento está atrás, hay que despachar automáticamente a los de adelante
        while (frente < indiceEncontrado) {
            System.out.println("Eliminando automaticamente elemento al frente [" + cola[frente] + "] para avanzar en la fila.");
            dequeueDirecto();
        }

        // Finalmente, eliminamos el elemento que el usuario seleccionó
        System.out.println("Elemento seleccionado [" + dequeueDirecto() + "] ha salido de la cola.");
    }

    // Método para presentar la cola actual
    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Cola actual: [ Vacia ]");
            return;
        }
        System.out.print("Cola actual (Frente -> Final): [ ");
        for (int i = frente; i <= fin; i++) {
            System.out.print(cola[i] + " ");
        }
        System.out.println("]");
    }
}