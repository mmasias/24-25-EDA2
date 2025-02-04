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

    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla("Pantalla");

        Frame1 frame1 = new Frame1(3, 4);
        Frame2 frame2 = new Frame2(3, 4);
        ResultadoVisual resultado = new ResultadoVisual(3, 4);

        pantalla.getFrame(frame1, frame2, resultado);
    }
}