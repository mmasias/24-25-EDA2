package entregas.PinedaOscar.Reto_000.Ejercicio_1;
class Frame {
    private Pixel[][] pixeles;
    private int resolucion;
    
    public Frame(int ancho, int alto, int resolucion) {
   
     this.resolucion = resolucion;
        pixeles = new Pixel[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = new Pixel(0); 
            }
        }
    }
    
    public void actualizarPixel(int x, int y, int color) {
        pixeles[x][y].actualizarPixel(color);
    }
    
    public Pixel[][] getPixeles() {
        return pixeles;
    }
}