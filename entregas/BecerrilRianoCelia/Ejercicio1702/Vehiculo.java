package Ejercicio1702;

public abstract class Vehiculo {
    protected String marca;
    protected int velocidad;

    public Vehiculo(String marca, int velocidad) {
        this.marca = marca;
        this.velocidad = velocidad;
    }

    public abstract void acelerar();

    public void frenar() {
        if (velocidad > 0) {
            velocidad -= 10;
            System.out.println(marca + " frenando. Velocidad actual: " + velocidad + " km/h.");
        } else {
            System.out.println(marca + " ya está detenido.");
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", velocidad=" + velocidad +
                " km/h}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return velocidad == vehiculo.velocidad && marca.equals(vehiculo.marca);
    }

    @Override
    public int hashCode() {
        int result = marca.hashCode();
        result = 31 * result + velocidad;
        return result;
    }
}