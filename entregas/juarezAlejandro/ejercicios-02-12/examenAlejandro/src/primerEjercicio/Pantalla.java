package primerEjercicio;

public class Pantalla {
    private String clase;

    public Pantalla(String clase) {
        this.clase = clase;
    }

    public void getFrame(Frame frame1, Frame frame2, ResultadoCombinado resultado) {
        System.out.println("Mostrando Frame 1:");
        frame1.posicionFrame();

        System.out.println("Mostrando Frame 2:");
        frame2.posicionFrame();

        System.out.println("Mostrando Resultado Combinado:");
        resultado.combinar(frame1, frame2);
    }
}