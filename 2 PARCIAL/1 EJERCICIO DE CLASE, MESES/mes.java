import java.util.Scanner;

public class mes {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int meses;

        System.out.print("Ingresa el numero del Mes: ");
        meses = entrada.nextInt(); 

        switch (meses) {
            case 1: System.out.println("ENERO, 31 dias");
            break;
            case 2: System.out.println("FEBRERO, 28 dias");
            break;
            case 3: System.out.println("MARZO, 31 dias");
            break;
            case 4: System.out.println("ABRIL, 30 dias");
            break;
            case 5: System.out.println("MAYO, 31 dias");
            break;
            case 6: System.out.println("JUNIO, 30 dias");
            break;
            case 7: System.out.println("JULIO, 31 dias");
            break;
            case 8: System.out.println("AGOSTO, 31 dias");
            break;
            case 9: System.out.println("SEPTIEMBRE, 30 dias");
            break;
            case 10: System.out.println("OCTUBRE, 31 dias");
            break;
            case 11: System.out.println("NOVIENBRE, 30 dias");
            break;
            case 12: System.out.println("DICIEMBRE, 31 dias");
            break;
            default: System.out.println("Erroro de Captura, Intentarlo denuevo");
            break;
        }

    }
}