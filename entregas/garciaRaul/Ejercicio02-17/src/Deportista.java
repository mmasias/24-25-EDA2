public abstract class Deportista {
    protected String nombre;
    protected int edad;

    public Deportista(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void entrenar();

    public void competir() {
        System.out.println(nombre + " está compitiendo.");
    }

    @Override
    public String toString() {
        return "Deportista{nombre='" + nombre + "', edad=" + edad + "}";
    }
}
