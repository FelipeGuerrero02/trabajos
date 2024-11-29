import java.util.Scanner;
class Aritmetica {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner SC = new Scanner(System.in);
        System.out.println("ingrese el primer numero :");
        int num_1 = SC.nextInt();
        System.out.println("ingrese el segundo numero :");
        int num_2 = SC.nextInt();
        int suma = num_1 + num_2;
        int resta = num_1 - num_2;
        int multiplicacion = num_1 * num_2;
        int division = num_1 / num_2;
        int modulo = num_1 % num_2;

        System.out.println(" la suma es: " + suma);
        System.out.println(" la resta es: " + resta);
        System.out.println(" la multiplicacion es: " + multiplicacion);
        System.out.println(" la division es: " + division);
        System.out.println(" el modulo es: " + modulo);
    }
}
