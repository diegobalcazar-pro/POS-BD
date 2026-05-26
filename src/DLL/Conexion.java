package DLL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String URL ="jdbc:mysql://localhost:3306/POS";
    private static String USER = "root";
    private static String PASSWORD ="";
    
    private static Connection conect;
    private static Conexion instance;
    
    private Conexion() {
        try {
            conect = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
    public static Conexion getInstance() {
        if(instance == null) instance = new Conexion();
        return instance;    
    }
    public Connection getConnection() {
        return conect;
    }
}