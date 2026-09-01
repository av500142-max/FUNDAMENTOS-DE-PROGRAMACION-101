import java.util.Scanner;

public class areas {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("=====CALCULO DE AREAS=====");
        System.out.println("1.Cuadrado");
        System.out.println("2.Rectangulo");
        System.out.println("3.Triangulo");
        System.out.println("4.Circulo");

        System.out.print("Elige una opcion:"); int opcion=sc.nextInt();
         double area;

         switch (opcion){

            case 1: System.out.print("Ingresa el lado:");
            double lado=sc.nextDouble();

            area=lado*lado;

            System.out.println("Area del Cuadrado:" +area);
            break;

            case 2: System.out.print("Ingresa la base:");
            double base=sc.nextDouble();
            System.out.print("Ingresa la altura:");
            double altura=sc.nextDouble();
            area = base * altura;
            System.out.println("Area del Rectangulo:" + area);
            break;
            
            case 3: System.out.print("Ingresa la base:");
            base=sc.nextDouble();
            System.out.print("Ingresa la altura:");
            altura=sc.nextDouble();
            area = (base * altura) / 2;
            System.out.println("Area del Triangulo:" + area);
            break;

            case 4: System.out.print("Ingresa el radio:");
            double radio = sc.nextDouble();
            area = Math.PI * radio * radio;
            System.out.println("Area del Circulo:" + area);
            break;
            default: System.out.println("Opcion no valida.");


         }
    }

}