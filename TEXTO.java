import java.io.*;
import java.util.*;
public class TEXTO {
    public static void guardarNotas(String nombreArchivo, List<Integer> notas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            for (Integer nota : notas) {
                writer.write(nota.toString());
                writer.newLine(); 
            }
            System.out.println("Notas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar las notas: " + e.getMessage());
        }
    }
    public static void leerNotas(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Notas almacenadas:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer las notas: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> notas = new ArrayList<>();
        String nombreArchivo = "notas.txt";
        int opcion;
        do {
            System.out.println("1. Ingresar nota");
            System.out.println("2. Mostrar notas guardadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la nota: ");
                    int nota = scanner.nextInt();
                    notas.add(nota);
                    guardarNotas(nombreArchivo, notas);
                    break;
                case 2:
                    leerNotas(nombreArchivo);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 3);
        scanner.close();
    }
}
