public class Pistola implements Arma {

    @Override
    public void disparar() {
        System.out.println("Pistola disparando: ¡Pum!");
    }

    public void recargar() {
        System.out.println("Recargando pistola...");
    }
}