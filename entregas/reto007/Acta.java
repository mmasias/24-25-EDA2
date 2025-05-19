public class Acta {
    private Alumno[] alumnos;
    private int[] hash;

    public Acta(Alumno[] alumnos) {
        this.alumnos = alumnos;
        hash = new int[alumnos.length];
        generar();
    }

    private void generar() {
        for (int i = 0; i < alumnos.length; i++) {
            hash[i] = calcularHash(alumnos[i]);
        }
    }

    private int calcularHash(Alumno alumno) {
        int hash = 17;
        hash = 31 * hash + Math.abs(alumno.getNombre().hashCode());
        hash = 31 * hash + Math.abs(alumno.getApellidos().hashCode());
        hash = 31 * hash + Math.abs(alumno.getDni().hashCode());
        hash = 31 * hash + Math.abs((int)(Double.doubleToLongBits(alumno.getNota())));
        return Math.abs(hash);
    }

    public int[] getHash() {
        return hash;
    }

    public Alumno getAlumnos(int i) {
        return alumnos[i];
    }

    public boolean equals(Acta other) {
        if (other == null || this.alumnos.length != other.alumnos.length) {
            return false;
        }
        for (int i = 0; i < this.alumnos.length; i++) {
            if (!this.alumnos[i].equals(other.alumnos[i])) {
                return false;
            }
        }
        return true;
    }
}