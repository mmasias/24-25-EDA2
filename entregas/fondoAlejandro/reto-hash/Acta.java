public class Acta {
    private Estudiante[] listaEstudiantes;
    private int[] codigosHash;

    public Acta(Estudiante[] estudiantes) {
        this.listaEstudiantes = estudiantes;
        this.codigosHash = new int[estudiantes.length];
        calcularHash();
    }

    private void calcularHash() {
        for (int i = 0; i < listaEstudiantes.length; i++) {
            codigosHash[i] = listaEstudiantes[i].hashCode();
        }
    }

    public int[] obtenerHashes() {
        return codigosHash;
    }

    public Estudiante obtenerEstudiante(int indice) {
        return listaEstudiantes[indice];
    }
}
