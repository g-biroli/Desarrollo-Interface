package ventanaGrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_login";
    private static final String USER = "root"; // Usuário padrão do XAMPP
    private static final String PASSWORD = ""; // Senha padrão do XAMPP (vazia)
    
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Certifica-se que o driver JDBC do MySQL está carregado
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem-sucedida com o banco de dados MySQL!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return conexion;
    }
}

