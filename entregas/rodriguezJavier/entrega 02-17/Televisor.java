public class Televisor extends Dispositivo {
    public Televisor(String marca) {
        super(marca);
    }

    @Override
    public void encender() {
        System.out.println("El televisor se ha encendido.");
    }
}
