package modelos;

public class Alumno {

    private String carnet;
    private String nombres;
    private String apellidos;
    private String seccion;
    private double nota;

    public Alumno(
            String carnet,
            String nombres,
            String apellidos,
            String seccion,
            double nota
    ) {

        this.carnet = carnet;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.seccion = seccion;
        this.nota = nota;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getSeccion() {
        return seccion;
    }

    public double getNota() {
        return nota;
    }
}
