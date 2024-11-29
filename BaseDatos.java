import java.sql.*;
import java.util.Scanner;
public class BaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_usuarios";
    private static final String USER = "root"; 
    private static final String PASSWORD = "root";  
    private static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void añadirUsuario(String nombre, String correo, int edad) {
        String sql = "INSERT INTO usuarios (nombre, correo, edad) VALUES (?, ?, ?)";
        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setInt(3, edad);
            stmt.executeUpdate();
            System.out.println("Usuario añadido correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al añadir el usuario: " + e.getMessage());
        }
    }
    public static void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }
    public static void actualizarUsuario(int id, String nombre, String correo, int edad) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, edad = ? WHERE id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setInt(3, edad);
            stmt.setInt(4, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario con el ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nGestión de Usuarios:");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el correo del usuario: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese la edad del usuario: ");
                    int edad = scanner.nextInt();
                    añadirUsuario(nombre, correo, edad);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    eliminarUsuario(idEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del usuario a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Ingrese el nuevo nombre del usuario: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo correo del usuario: ");
                    String nuevoCorreo = scanner.nextLine();
                    System.out.print("Ingrese la nueva edad del usuario: ");
                    int nuevaEdad = scanner.nextInt();
                    actualizarUsuario(idActualizar, nuevoNombre, nuevoCorreo, nuevaEdad);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
            }
        } while (opcion != 4);
        scanner.close();
    }
}
