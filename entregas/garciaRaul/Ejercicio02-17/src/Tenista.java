public class Tenista extends Deportista implements Profesional {
    private String ranking;

    public Tenista(String nombre, int edad, String ranking) {
        super(nombre, edad);
        this.ranking = ranking;
    }

    @Override
    public void entrenar() {
        System.out.println(nombre + " está entrenando para mejorar su ranking " + ranking + ".");
    }

    @Override
    public void recibirSueldo() {
        System.out.println(nombre + " ha recibido su sueldo como tenista.");
    }
}