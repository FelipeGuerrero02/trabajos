public class MVM {

    public static int incrementar(int x) {
        x += 1;
        System.out.println("Dentro del método: x = " + x);
        return x;
    }

    public static void main(String[] args) {
        int x = 5;
        System.out.println("Antes de llamar al método: x = " + x);
        x = incrementar(x);  
        System.out.println("Después de llamar al método: x = " + x);
    }
}
