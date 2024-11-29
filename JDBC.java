import java.sql.*;
public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "root";  
    public static Connection obtenerConexion() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error al intentar conectar a la base de datos.");
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
            return null;
        }
    }
    public static void realizarConsulta(Connection conn) {
        String sql = "SELECT * FROM usuarios"; 
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta.");
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
        }
    }
    public static void insertarUsuario(Connection conn, String nombre) {
        String sql = "INSERT INTO usuarios (nombre) VALUES (?)"; 
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario insertado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario.");
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
        }
    }
    public static void main(String[] args) {
        Connection conn = obtenerConexion();
        if (conn != null) {
            realizarConsulta(conn);
            insertarUsuario(conn, "Nuevo Usuario");
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                System.out.println("Mensaje: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}
