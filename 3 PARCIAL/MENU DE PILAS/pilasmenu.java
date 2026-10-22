import java.util.Scanner;

public class pilasmenu{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Ingrese el tamano de la pila: ");
        int tamanio = teclado.nextInt();
        
        PilaArreglo pila = new PilaArreglo(tamanio);
        int opcion;

        do {
            // El menú muestra dinámicamente el valor actual del tope
            System.out.println("--- MENU DE LA PILA (Tope actual: " + pila.getTope() + ") ---");
            System.out.println("1. Push (Colocar elemento)");
            System.out.println("2. Pop / Eliminar elemento especifico");
            System.out.println("3. Mostrar pila completa");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento que se colocara en la pila: ");
                    int valor = teclado.nextInt();
                    pila.push(valor);
                    pila.mostrarPila(); // Muestra la pila actualizada con el nuevo cambio
                    break;
                case 2:
                    System.out.print("Ingrese el elemento que desea eliminar: ");
                    int elementoAEliminar = teclado.nextInt();
                    pila.eliminarElemento(elementoAEliminar);
                    pila.mostrarPila(); // Muestra la pila actualizada con el nuevo cambio
                    break;
                case 3:
                    pila.mostrarPila(); // Opción explícita en el menú para ver la pila
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 4);

        teclado.close();
    }
}

class PilaArreglo {
    private int[] pila;
    private int tope;
    private int capacidad;

    public PilaArreglo(int tamanio) {
        this.capacidad = tamanio;
        this.pila = new int[tamanio];
        this.tope = -1; // -1 significa pila vacía
    }

    public int getTope() {
        return this.tope;
    }

    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    // PUSH con alerta de Pila Llena / Desbordamiento (Overflow)
    public void push(int elemento) {
        if (estaLlena()) {
            System.out.println("ERROR: Pila Llena - Desbordamiento (Overflow).");
        } else {
            tope++;
            pila[tope] = elemento;
            System.out.println("Elemento colocado con exito.");
        }
    }

    // POP directo de la cima
    public int popDirecto() {
        int eliminado = pila[tope];
        tope--;
        return eliminado;
    }

    // Método que fuerza la regla LIFO eliminando automáticamente lo que esté arriba
    // Maneja la alerta de Pila Vacía / Subdesbordamiento (Underflow)
    public void eliminarElemento(int objetivo) {
        if (estaVacia()) {
            System.out.println("ERROR: Pila Vacia - Subdesbordamiento (Underflow).");
            return;
        }

        // Buscamos en qué índice del arreglo está el elemento
        int indiceEncontrado = -1;
        for (int i = 0; i <= tope; i++) {
            if (pila[i] == objetivo) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("El elemento no existe en la pila.");
            return;
        }

        // Si el elemento está más abajo de la cima, eliminamos automáticamente los de arriba
        while (tope > indiceEncontrado) {
            System.out.println("Se elimino el elemento superior [" + pila[tope] + "] para poder llegar al elemento solicitado.");
            popDirecto();
        }

        // Finalmente, eliminamos el elemento que el usuario pidió
        System.out.println("Elemento seleccionado [" + popDirecto() + "] eliminado correctamente.");
    }

    // Método para presentar la pila actual
    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Pila actual: [ Vacia ]");
            return;
        }
        System.out.print("Pila actual: [ ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(pila[i] + " ");
        }
        System.out.println("]");
    }
}

