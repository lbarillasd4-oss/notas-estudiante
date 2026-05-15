package principal;

import java.util.Scanner;
import servicios.AlumnoServicio;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AlumnoServicio servicio =
                new AlumnoServicio();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");

            System.out.println("1. Ingresar alumno");
            System.out.println("2. Ingresar notas");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Actualizar alumno y nota");
            System.out.println("5. Buscar alumno");
            System.out.println("6. Obtener promedio");
            System.out.println("7. Listar alumnos");
            System.out.println("8. Salir");

            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Carnet: ");
                    String carnet = sc.nextLine();

                    System.out.print("Nombres: ");
                    String nombres = sc.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidos = sc.nextLine();

                    System.out.print("Seccion: ");
                    String seccion = sc.nextLine();

                    double nota = 0;

                    servicio.insertarAlumno(
                            carnet,
                            nombres,
                            apellidos,
                            seccion,
                            nota
                    );

                    break;

                case 2:

                    System.out.print(
                            "Carnet del alumno: "
                    );

                    carnet = sc.nextLine();

                    System.out.print(
                            "Nueva nota: "
                    );

                    nota = sc.nextDouble();

                    servicio.ingresarNota(
                            carnet,
                            nota
                    );

                    break;

                case 3:

                    System.out.print(
                            "Carnet a eliminar: "
                    );

                    carnet = sc.nextLine();

                    System.out.print(
                            "Seguro que desea eliminar? (s/n): "
                    );

                    String respuesta = sc.nextLine();

                    if (respuesta.equalsIgnoreCase("s")) {

                        servicio.eliminarAlumno(carnet);

                    } else {

                        System.out.println(
                                "Eliminacion cancelada"
                        );
                    }

                    break;

                case 4:

                    System.out.print(
                            "Carnet: "
                    );

                    carnet = sc.nextLine();

                    System.out.print(
                            "Nuevo nombre: "
                    );

                    nombres = sc.nextLine();

                    System.out.print(
                            "Nuevo apellido: "
                    );

                    apellidos = sc.nextLine();

                    System.out.print(
                            "Nueva seccion: "
                    );

                    seccion = sc.nextLine();

                    System.out.print(
                            "Nueva nota: "
                    );

                    nota = sc.nextDouble();

                    servicio.actualizarAlumno(
                            carnet,
                            nombres,
                            apellidos,
                            seccion,
                            nota
                    );

                    break;

                case 5:

                    System.out.print(
                            "Ingrese carnet o nombre: "
                    );

                    String dato = sc.nextLine();

                    servicio.buscarAlumno(dato);

                    break;

                case 6:

                    System.out.print(
                            "Ingrese seccion: "
                    );

                    seccion = sc.nextLine();

                    servicio.promedioSeccion(seccion);

                    break;

                case 7:

                    System.out.print(
                            "Ingrese seccion: "
                    );

                    seccion = sc.nextLine();

                    servicio.listarAlumnos(seccion);

                    break;

                case 8:

                    System.out.println(
                            "Saliendo..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida"
                    );
            }

        } while (opcion != 8);

        sc.close();
    }
}

