package servicios;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlumnoServicio {

    // INSERTAR ALUMNO
    public void insertarAlumno(
            String carnet,
            String nombres,
            String apellidos,
            String seccion,
            double nota
    ) {

        try {

            Connection con =
                    ConexionBD.conectar();

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

    // INGRESAR NOTA
    public void ingresarNota(
            String carnet,
            double nota
    ) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "UPDATE alumnos SET nota=? " +
                    "WHERE carnet=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setDouble(1, nota);
            ps.setString(2, carnet);

            int filas =
                    ps.executeUpdate();

            if (filas > 0) {

                System.out.println(
                        "Nota ingresada correctamente"
                );

            } else {

                System.out.println(
                        "Alumno no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // BUSCAR
    public void buscarAlumno(String dato) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "SELECT * FROM alumnos " +
                    "WHERE carnet=? " +
                    "OR nombres LIKE ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, dato);

            ps.setString(
                    2,
                    "%" + dato + "%"
            );

            ResultSet rs =
                    ps.executeQuery();

            boolean encontrado =
                    false;

            while (rs.next()) {

                encontrado = true;

                System.out.println(
                        "\n===== ALUMNO ====="
                );

                System.out.println(
                        "Carnet: " +
                        rs.getString("carnet")
                );

                System.out.println(
                        "Nombre: " +
                        rs.getString("nombres")
                );

                System.out.println(
                        "Apellido: " +
                        rs.getString("apellidos")
                );

                System.out.println(
                        "Seccion: " +
                        rs.getString("seccion")
                );

                System.out.println(
                        "Nota: " +
                        rs.getDouble("nota")
                );
            }

            if (!encontrado) {

                System.out.println(
                        "Alumno no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // ACTUALIZAR
    public void actualizarAlumno(
            String carnet,
            String nombres,
            String apellidos,
            String seccion,
            double nota
    ) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "UPDATE alumnos " +
                    "SET nombres=?, " +
                    "apellidos=?, " +
                    "seccion=?, " +
                    "nota=? " +
                    "WHERE carnet=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setString(3, seccion);
            ps.setDouble(4, nota);
            ps.setString(5, carnet);

            int filas =
                    ps.executeUpdate();

            if (filas > 0) {

                System.out.println(
                        "Alumno actualizado"
                );

            } else {

                System.out.println(
                        "Alumno no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // ELIMINAR
    public void eliminarAlumno(
            String carnet
    ) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "DELETE FROM alumnos " +
                    "WHERE carnet=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, carnet);

            int filas =
                    ps.executeUpdate();

            if (filas > 0) {

                System.out.println(
                        "Alumno eliminado"
                );

            } else {

                System.out.println(
                        "Alumno no encontrado"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // LISTAR
    public void listarAlumnos(
            String seccion
    ) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "SELECT * FROM alumnos " +
                    "WHERE seccion=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, seccion);

            ResultSet rs =
                    ps.executeQuery();

            boolean encontrado =
                    false;

            System.out.println(
                    "\n===== LISTA ====="
            );

            while (rs.next()) {

                encontrado = true;

                System.out.println(
                        "----------------"
                );

                System.out.println(
                        "Carnet: " +
                        rs.getString("carnet")
                );

                System.out.println(
                        "Nombre: " +
                        rs.getString("nombres")
                );

                System.out.println(
                        "Apellido: " +
                        rs.getString("apellidos")
                );

                System.out.println(
                        "Seccion: " +
                        rs.getString("seccion")
                );

                System.out.println(
                        "Nota: " +
                        rs.getDouble("nota")
                );
            }

            if (!encontrado) {

                System.out.println(
                        "No hay alumnos en esa seccion"
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    // PROMEDIO
    public void promedioSeccion(
            String seccion
    ) {

        try {

            Connection con =
                    ConexionBD.conectar();

            String sql =
                    "SELECT AVG(nota) AS promedio " +
                    "FROM alumnos WHERE seccion=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, seccion);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Promedio: " +
                        rs.getDouble("promedio")
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}
