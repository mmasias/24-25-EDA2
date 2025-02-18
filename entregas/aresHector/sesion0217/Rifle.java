public class Rifle implements Arma {

    @Override
    public void disparar() {
        System.out.println("Rifle disparando: ¡Bang!");
    }

    public void apuntar() {
        System.out.println("Apuntando con el rifle...");
    }
}