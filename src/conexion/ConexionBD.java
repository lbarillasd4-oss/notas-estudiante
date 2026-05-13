package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/BDNotas";

    private static final String USER = "root";

    private static final String PASSWORD = "0708";

    public static Connection conectar() {

        Connection conexion = null;

        try {

            conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a MySQL");

        } catch (Exception e) {

            System.out.println(
                    "Error de conexion: " + e.getMessage()
            );
        }

        return conexion;
    }
}
