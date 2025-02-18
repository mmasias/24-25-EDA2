public class Profesor extends Curso {
    public Profesor(String nombre) {
        super(nombre);
    }

    @Override
    public void iniciar() {
        System.out.println("El profesor da inicio a su clase.");
    }
}