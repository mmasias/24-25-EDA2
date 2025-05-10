public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();
        Frame frame1 = new Frame(3, 7);
        pantalla.agregarFrame(frame1);
        pantalla.printIndividualFrame(0);
        Frame frame2 = new Frame(3, 7);
        pantalla.agregarFrame(frame2);
        pantalla.printIndividualFrame(1);
        pantalla.printFrame(0, 1);
    }

}
