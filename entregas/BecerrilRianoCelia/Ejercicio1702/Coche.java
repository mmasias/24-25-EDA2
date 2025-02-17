package Ejercicio1702;

public class Coche extends Vehiculo implements Electrico {
    private int numPuertas;

    public Coche(String marca, int velocidad, int numPuertas) {
        super(marca, velocidad);
        this.numPuertas = numPuertas;
    }

    @Override
    public void acelerar() {
        velocidad += 20;
        System.out.println(marca + " acelerando. Velocidad actual: " + velocidad + " km/h.");
    }

    @Override
    public void cargarBateria() {
        System.out.println(marca + " cargando batería.");
    }
}