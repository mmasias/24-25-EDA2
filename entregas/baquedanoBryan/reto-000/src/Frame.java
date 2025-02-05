public class Frame {
    
    private Pixel[][] pixeles;
    
    public Frame(int filas, int columnas) {
        this.pixeles = new Pixel[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.pixeles[i][j] = new Pixel('#', '.', '+');
            }
        }
    }

    public Pixel obtenerPixel(int fila, int columna){
        return this.pixeles[fila][columna];
    }

    public Pixel buscarPixel(char caracter) {
        for (int i = 0; i < pixeles.length; i++) {
            for (int j = 0; j < pixeles[i].length; j++) {
                if (pixeles[i][j].getNumeral() == caracter || 
                    pixeles[i][j].getPunto() == caracter || 
                    pixeles[i][j].getMas() == caracter) {
                    return pixeles[i][j];
                }
            }
        }
        return null;
    }

    public void resetearFrame() {
        for (int i = 0; i < pixeles.length; i++) {
            for (int j = 0; j < pixeles[i].length; j++) {
                pixeles[i][j] = new Pixel('#', '.', '+');
            }
        }
    }

    public void actualizarPixel(int fila, int columna, Pixel nuevoPixel) {
        if (fila >= 0 && fila < pixeles.length && columna >= 0 && columna < pixeles[0].length) {
            pixeles[fila][columna] = nuevoPixel;
        } else {
            System.out.println("Error: Posición fuera de los límites del Frame.");
        }
    }
      
}
