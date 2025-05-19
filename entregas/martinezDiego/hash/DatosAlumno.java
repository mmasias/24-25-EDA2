package entregas.martinezDiego.hash;

class DatosAlumno {

    private String nombreAlumno;
    private String apellidosAlumno;
    private int idAlumno;
    private String asignatura;
    private double notaFinal;

    public DatosAlumno(String nombreAlumno, String apellidosAlumno, int idAlumno, String asignatura,
            double notaFinal) {
        this.nombreAlumno = nombreAlumno;
        this.apellidosAlumno = apellidosAlumno;
        this.idAlumno = idAlumno;
        this.asignatura = asignatura;
        this.notaFinal = notaFinal;

    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidosAlumno() {
        return apellidosAlumno;
    }

    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

}
