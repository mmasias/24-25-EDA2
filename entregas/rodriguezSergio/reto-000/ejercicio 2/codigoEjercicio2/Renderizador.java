public class Renderizador {
    private BufferPantalla bufferPantalla;

    public Renderizador(BufferPantalla bufferPantalla) {
        this.bufferPantalla = bufferPantalla;
    }

    public void renderizar() {
        SuperposicionTemporal superposicionTemporal = new SuperposicionTemporal();
        bufferPantalla.aplicarSuperposicionTemporal(superposicionTemporal);
    }
}
