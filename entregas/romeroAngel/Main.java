public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pokemon charmander = new Charmander("Tacuazin", 14);


        Entrenador rxmerx = new Entrenador(charmander);
        rxmerx.entrenar(10);
    }
}
