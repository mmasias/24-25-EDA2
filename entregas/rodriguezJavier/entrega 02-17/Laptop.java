public class Laptop extends Dispositivo {
    public Laptop(String marca) {
        super(marca);
    }

    @Override
    public void encender() {
        System.out.println("La laptop se ha encendido.");
    }

    public void conectarInternet() {
        System.out.println("La laptop está conectada a Internet.");
    }
}
