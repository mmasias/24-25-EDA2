public class Frame {
    private Pixel[][] datosPixel;
    private int altura;
    private int anchura;

    public Frame(Pixel[][] datosPixel, int altura, int anchura) {
        this.datosPixel = datosPixel;
        this.altura = altura;
        this.anchura = anchura;
    }

    public void setPixel(int x, int y, char color) {
        if (x >= 0 && x < anchura && y >= 0 && y < altura) {
            datosPixel[y][x].setColor(color);
        } else {
            System.out.println("Coordenadas fuera de rango");
        }
    }

    public char getPixel(int x, int y) {
        if (x >= 0 && x < anchura && y >= 0 && y < altura) {
            return datosPixel[y][x].getColor();
        } else {
            System.out.println("Coordenadas fuera de rango");
            return ' ';
        }
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void renderizar() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                System.out.print(datosPixel[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }

}
