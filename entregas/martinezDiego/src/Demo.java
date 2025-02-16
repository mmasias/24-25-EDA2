public class Demo {
    public static void main(String[] args) {
        BufferDoble buffer = new BufferDoble();
        Frame frame1 = buffer.getFrameActivo();
        frame1.setPixel(1, 1, '#');
        
        buffer.alternarFrame();
        Frame frame2 = buffer.getFrameActivo();
        frame2.setPixel(2, 1, '#');
        
        Renderizador.renderizar(frame1, frame2);
    }
}
