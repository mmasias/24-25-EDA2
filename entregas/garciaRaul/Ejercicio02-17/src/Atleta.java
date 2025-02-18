public class Atleta extends Deportista implements Profesional{
    private String especialidad;

    public Atleta(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " está entrenando en la especialidad de " + especialidad + ".");
    }
}