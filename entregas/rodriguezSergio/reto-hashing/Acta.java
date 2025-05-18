public class Acta {
    private Estudiante[] estudiantes;
    private String codigo;

    public Acta(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
        this.codigo = generarCodigoSimple();
    }

    private String generarCodigoSimple() {
        long hash = 7;
        for (Estudiante e : estudiantes) {
            String datos = e.getId() + e.getNombre() + e.getApellido() + e.getCurso() + e.getNota();
            for (int i = 0; i < datos.length(); i++) {
                hash = hash * 31 + datos.charAt(i);
            }
        }
        return Long.toHexString(hash);
    }

    public String getCodigo() { return codigo; }
}