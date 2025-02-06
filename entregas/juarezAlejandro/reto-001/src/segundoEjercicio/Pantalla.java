package segundoEjercicio;

public class Pantalla {
    private String clase;

    public Pantalla(String clase) {
        this.clase = clase;
    }

    public void getFrame(Frame1 frame1, Frame2 frame2, ResultadoVisual resultado) {
        System.out.println("Mostrando Frame 1:");
        frame1.posicionFrame();

        System.out.println("Mostrando Frame 2:");
        frame2.posicionFrame();

        System.out.println("Mostrando Resultado Visual:");
        resultado.combinar(frame1, frame2);
    }
}
