package segundoEjercicio;

public class Buffer {
    private void mostrarFrameEscogido(Frame1 frame1, Frame2 frame2, ResultadoVisual resultado) {
        System.out.println("Mostrando Frame 1:");

        System.out.println("Mostrando Frame 2:");

        System.out.println("Mostrando Resultado Visual:");
        resultado.combinar(frame1, frame2);
    }
}