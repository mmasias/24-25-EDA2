public class Acta {
    private Alumno[] estudiantes;
    private int[] codigosHash;

    public Acta(Alumno[] estudiantes) {
        this.estudiantes = estudiantes;
        codigosHash = new int[estudiantes.length];
        generarCodigos();
    }

    private void generarCodigos() {
        for (int i = 0; i < estudiantes.length; i++) {
            codigosHash[i] = calcularCodigoHash(estudiantes[i]);
        }
    }

    private int calcularCodigoHash(Alumno estudiante) {
        int hash = 19;
        hash = 37 * hash + Math.abs(estudiante.getNombre().hashCode());
        hash = 37 * hash + Math.abs(estudiante.getApellido().hashCode());
        hash = 37 * hash + Math.abs(estudiante.getIdentificacion().hashCode());
        hash = 37 * hash + Math.abs((int) (Double.doubleToLongBits(estudiante.getCalificacion())));
        return Math.abs(hash);
    }

    public int[] getCodigosHash() {
        return codigosHash;
    }

    public Alumno getEstudiante(int indice) {
        return estudiantes[indice];
    }

    public boolean esIgual(Acta otro) {
        if (otro == null || this.estudiantes.length != otro.estudiantes.length) {
            return false;
        }
        for (int i = 0; i < this.estudiantes.length; i++) {
            if (!this.estudiantes[i].equals(otro.estudiantes[i])) {
                return false;
            }
        }
        return true;
    }
}