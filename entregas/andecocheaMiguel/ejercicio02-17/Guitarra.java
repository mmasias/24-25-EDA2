public class Guitarra extends InstrumentoMusical implements Instrumento {
    @Override
    public void tocar() {
        System.out.println("Guitarra rasgueando");
    }

    public void afinar() {
        System.out.println("Afinando guitarra");
    }
}