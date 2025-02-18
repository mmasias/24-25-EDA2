public class Dispositivo {
    String marca;

    public Dispositivo(String marca) {
        this.marca = marca;
    }

    public void encender() {
        System.out.println("El dispositivo está encendido.");
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
    }
}
