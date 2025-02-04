public class Rendimiento {
    private BufferPantalla bufferPantalla;
    private int[][] frameActual;
    private boolean usandoFrame1;  
   
    public Rendimiento(BufferPantalla bufferPantalla) {
        this.bufferPantalla = bufferPantalla;
        this.frameActual = bufferPantalla.getFrame1();
        this.usandoFrame1 = true;
    }
    
    public void renderizar() {
        bufferPantalla.combinarFrames();
        bufferPantalla.mostrarPantalla();
    }

    public void alternarFrame() {
        if (usandoFrame1) {
            frameActual = bufferPantalla.getFrame2();
        } else {
            frameActual = bufferPantalla.getFrame1();
        }
        usandoFrame1 = !usandoFrame1;
    }
}
