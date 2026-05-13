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
            System.out.println("2. Salir");

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

                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();

                    servicio.insertarAlumno(
                            carnet,
                            nombres,
                            apellidos,
                            seccion,
                            nota
                    );

                    break;

                case 2:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 2);
    }
}