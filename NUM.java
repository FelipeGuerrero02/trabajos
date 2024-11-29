import java.util.Scanner;
public class NUM{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner (System.in)) {
            System.out.println("ingrese el primer numero");
             int num1=scanner.nextInt();
             System.out.println("ingrese el segundo numero");
             int num2= scanner.nextInt();
             System.out.println("ingrese el tercer numero");
             int num3= scanner.nextInt();
             if (num1>num2 && num1>num3){
                System.out.println("el numero mayor es el primer numero: " + num1);
             }
             else if(num2>num1 && num2>num3){
                System.out.println("el numero mayor es el numero dos: " + num2);
             }
             else{
                System.out.println("el numero mayor es el numero tres: " + num3);
             }
        }
    }
}
