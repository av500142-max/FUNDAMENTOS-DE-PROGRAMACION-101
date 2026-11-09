import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

class Tarea{
    String identificador;
    String descripcion;
    int prioridad;
    boolean completada;

    public Tarea(String identificador, String descripcion, int prioridad){
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = false;
    }
    
    public String getIdentificador() {
        return identificador;}
        public String getDescripcion() {
            return descripcion;}
            public int getPrioridad(){
                return prioridad;}
                public boolean isCompletada() {
                    return completada;}
                    public void setCompletada(boolean completada){
                        this.completada = completada;}

@Override 
public String toString(){
    String estado = completada ? "[Completada}" : "[Pendiente]";
    return "ID: " + identificador + " , Descripcion: " + descripcion + " , Prioridad: " + prioridad + "" + estado; }
}

public class GestionTareasLinkedList{
    public static void main(String[] args){
        Scanner(System.in);
        LinkedList <Tarea> listaTareas = new LinkedList<>();
        int opcion;

        do { 
            System.out.println("Sistema de Gestion de Tareas");
            System.out.println("1.Registrar una Tarea al Final");
            System.out.println("2.Registrar una Tarea al Inicio");
            System.out.println("3.Insertar una Tarea en una Posicion Especifica");
            System.out.println("4.Eliminar Tarea por Identificador");
            System.out.println("5.Buscar Tarea por descripcion");
            System.out.println("6.Mostrar todas las tareas pendientes");
            System.out.println("7.Marcar tarea como completada");
            System.out.println("8.Recorrer la lista en orden inverso");
            System.out.println("9.Salir del Programa");
            System.out.print("Elija una opcion:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:
                    System.out.print("Identificador:");
                    String id1 = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String desc1 = scanner.nextLine();
                    System.out.print("Prioridad (numero):");
                    int prio1 = scanner.nextInt();
                    listaTareas.addLast(new Tarea(id1, desc1, prio1));
                    System.out.println("Tarea agregada al final");
                    break;

                    case 2:
                        
            }







        } while (true);

    }
}