public class Acta {
    private Alumno[] alumnos;
    private int[] hash;

    public Acta(Alumno[]alumnos){
        this.alumnos= alumnos;
        hash = new int[alumnos.length];
        generar();

    }

    private void generar(){

        for (int i = 0; i < alumnos.length; i++) {
            hash[i]= alumnos[i].hashCode();
        }
    }

    public int[] getHash() {
        return hash;
    }

    public Alumno getAlumnos(int i) {
        return alumnos[i];
    }
