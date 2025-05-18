class PantallaEntrelazada {
    int ancho, alto;
    ListaCircularFrames listaFrames;
    
    public PantallaEntrelazada(int ancho, int alto) {
        this.ancho = ancho / 2;
        this.alto = alto;
        this.listaFrames = new ListaCircularFrames(this.ancho, this.alto, 2);
    }
    
    public void establecerPixel(Coordenada coordenada, int color) {
        listaFrames.obtenerActual().establecerPixel(coordenada, color);
    }
    
    public void renderizar() {
        Frame frame = listaFrames.obtenerActual();
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < this.ancho; j++) { 
                System.out.print(frame.pixeles[i][j].obtenerColor() + " ");
            }
            System.out.println();
        }
    }
}