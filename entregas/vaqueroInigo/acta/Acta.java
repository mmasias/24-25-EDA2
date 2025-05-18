public class Acta {
    private Alumno[] alumnos;

    public Acta(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public int[] getHash() {
        int[] hashes = new int[alumnos.length];
        for (int i = 0; i < alumnos.length; i++) {
            hashes[i] = alumnos[i].getHash();
        }
        return hashes;
    }

    public Alumno getAlumno(int i) {
        return alumnos[i];
    }
}
