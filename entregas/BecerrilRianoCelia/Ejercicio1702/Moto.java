package Ejercicio1702;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, int velocidad, int cilindrada) {
        super(marca, velocidad);
        this.cilindrada = cilindrada;
    }

    @Override
    public void acelerar() {
        velocidad += 30;
        System.out.println(marca + " acelerando. Velocidad actual: " + velocidad + " km/h.");
    }

}
