class PixelConCoordenada {
    
    private Pixel pixel;
    private Coordenada coordenada;

    public PixelConCoordenada(Pixel pixel, Coordenada coordenada) {
        this.pixel = pixel;
        this.coordenada = coordenada;
    }

    public Pixel obtenerPixel() {
        return pixel;
    }

    public Coordenada obtenerCoordenada() {
        return coordenada;
    }
}