import java.util.ArrayList;
import java.util.Scanner;
public class GL {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");
        System.out.println("Lista inicial: " + lista);
        System.out.print("Introduce un índice para acceder a un elemento de la lista: ");
        int indice = scanner.nextInt();
        try {
            String elemento = lista.get(indice);
            System.out.println("Elemento en el índice " + indice + ": " + elemento);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: El índice " + indice + " está fuera de los límites de la lista.");
        }
        try {
            String elemento = lista.get(5);  
            System.out.println("Elemento en el índice 5: " + elemento);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: El índice 5 está fuera de los límites de la lista.");
        }
        System.out.print("Introduce un nuevo elemento para añadir a la lista: ");
        scanner.nextLine(); 
        String nuevoElemento = scanner.nextLine();
        lista.add(nuevoElemento);
        System.out.println("Lista después de añadir el nuevo elemento: " + lista);
        scanner.close();
    }
}
