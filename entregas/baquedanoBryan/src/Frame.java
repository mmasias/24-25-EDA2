public class Frame {
    public Pixel[][] pixeles;

    public Frame(int filas, int columnas) {
        pixeles = new Pixel[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                pixeles[i][j] = new Pixel(' '); 
            }
        }
    }

    public void setPixel(int x, int y, char simbolo) {
        if (x >= 0 && x < pixeles.length && y >= 0 && y < pixeles[0].length) {
            pixeles[x][y].setSimbolo(simbolo);
        }
    }

    public Pixel getPixel(int x, int y) {
        if (x >= 0 && x < pixeles.length && y >= 0 && y < pixeles[0].length) {
            return pixeles[x][y];
        }
        return null;
    }

    public void imprimir() {
        for (int i = 0; i < pixeles.length; i++) {
            for (int j = 0; j < pixeles[i].length; j++) {
                System.out.print(pixeles[i][j].getSimbolo() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    




}

