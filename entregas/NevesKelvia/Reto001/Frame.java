class Frame {
    Pixel[][] pixeles;
    int ancho, alto;
    
    public Frame(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pixeles = new Pixel[alto][ancho];
        for (int i = 0; i < alto; i++)
            for (int j = 0; j < ancho; j++)
                pixeles[i][j] = new Pixel();
    }
    
    public Pixel obtenerPixel(Coordenada coordenada) {
        return pixeles[coordenada.y][coordenada.x];
    }
    
    public void establecerPixel(Coordenada coordenada, int color) {
        pixeles[coordenada.y][coordenada.x].establecerColor(color);
    }
}