
public class Futbolista extends Deportista implements Profesional {
    private String posicion;

    public Futbolista(String nombre, int edad, String posicion) {
        super(nombre, edad);
        this.posicion = posicion;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " está entrenando en la posición de " + posicion + ".");
    }

    @Override
    public void recibirSueldo() {
        System.out.println(nombre + " ha recibido su sueldo como futbolista.");
    }
}