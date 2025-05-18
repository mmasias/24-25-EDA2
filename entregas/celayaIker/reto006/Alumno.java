package entregas.celayaIker.reto006;

public class Alumno {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double evaluacionContinua;
    private double examenParcial;
    private double examenFinal;

    public Alumno(String nombre, String apellido1, String apellido2, double evaluacionContinua, double examenParcial, double examenFinal) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.evaluacionContinua = evaluacionContinua;
        this.examenParcial = examenParcial;
        this.examenFinal = examenFinal;
    }

    public void setExamenFinal(double examenFinal) {
        this.examenFinal = examenFinal;
    }

    public String getDatosActa() {
        return nombre + " " + apellido1 + " " + apellido2 + "|" +
               evaluacionContinua + "|" + examenParcial + "|" + examenFinal;
    }

    @Override
    public String toString() {
        return getDatosActa();
    }
}
