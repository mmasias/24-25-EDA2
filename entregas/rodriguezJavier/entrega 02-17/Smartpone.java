public class Smartphone extends Dispositivo {
    public Smartphone(String marca) {
        super(marca);
    }

    @Override
    public void encender() {
        System.out.println("El smartphone se ha encendido.");
    }

    public void hacerLlamada() {
        System.out.println("Realizando una llamada...");
    }

    public void conectarInternet() {
        System.out.println("El smartphone está conectado a Internet.");
    }
}
