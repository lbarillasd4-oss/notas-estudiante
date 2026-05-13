package servicios;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlumnoServicio {

    public void insertarAlumno(
            String carnet,
            String nombres,
            String apellidos,
            String seccion,
            double nota
    ) {

        try {

            Connection con = ConexionBD.conectar();

            String sql =
                    "INSERT INTO alumnos VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, carnet);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, seccion);
            ps.setDouble(5, nota);

            ps.executeUpdate();

            System.out.println(
                    "Alumno agregado correctamente"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}
