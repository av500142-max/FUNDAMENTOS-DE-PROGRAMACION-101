import java.util.Scanner;

public class calculos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el primer numero: ");
        double num1=sc.nextDouble();

        System.out.print("Ingresa el segundo numero: ");
        double num2=sc.nextDouble();

        System.out.print("Ingresa la Operación (+,-,*,/):");
        char operador = sc.next().charAt(0);
        
        switch(operador){
            case'+': System.out.println("Resueltado:" + (num1+num2));
            break;
             case'-': System.out.println("Resueltado:" + (num1-num2));
            break;
             case'*': System.out.println("Resueltado:" + (num1*num2));
            break;
            case '/': 
            if (num2!=0){
                System.out.println("Resultado:" + (num1/num2));
            }else{
            System.out.println("Error: no se puede dividir entre cero.");
            }
            break;

            default: System.out.println("Operador no valido.");
        }
        

        
    }
}
