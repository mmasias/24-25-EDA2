public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        ascensor.subir(0, 10);
        ascensor.bajar(10, 0);
        System.out.println("-------------------");
        ascensor.bajar(0, 10);
        ascensor.subir(10, 0);
        System.out.println("-------------------");
        ascensor.subir(0, 0);
        System.out.println("-------------------");
        ascensor.bajar(0, -4);
        ascensor.subir(10, 13);
    }
}
