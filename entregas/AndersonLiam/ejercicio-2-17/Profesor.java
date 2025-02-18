public class Profesor extends Curso {
    public Profesor(String nombre) {
        super(nombre);
    }

    @Override
    public void empezar() {
        System.out.println("El profesor inicia su jornada de clases.");
    }

    public void enseñar() {
        System.out.println("El profesor está enseñando el tema.");
    }
}
