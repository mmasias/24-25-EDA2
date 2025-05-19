public class RegistroAcademico {
    private Alumno[] grupoAlumnos;
    private int[] valoresDigest;
    
    public RegistroAcademico(Alumno[] alumnos) {
        this.grupoAlumnos = alumnos;
        this.valoresDigest = new int[alumnos.length];
        generarDigest();
    }
    
    private void generarDigest() {
        for (int pos = 0; pos < grupoAlumnos.length; pos++) {
            valoresDigest[pos] = grupoAlumnos[pos].hashCode();
        }
    }
    
    public int[] obtenerDigests() {
        return valoresDigest;
    }
    
    public Alumno consultarAlumno(int posicion) {
        return grupoAlumnos[posicion];
    }
}