public class Main {
    public static void main(String[] args) {
        AscensorRecursivo ascensor = new AscensorRecursivo(0);
        ascensor.pedirPlanta(5);
        System.out.println("Piden ascensor otra vez...");
        ascensor.pedirPlanta(-1);
    }
}
