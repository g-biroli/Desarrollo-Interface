package ventanaGrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//conexion con la base de datos que hice para la actividad
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/actividadloginue?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; 
    private static final String CLAVE = ""; 
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer conexión
            
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa con la base de datos");
            return conexion;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        conectar(); // Prueba de conexion
    }
}

