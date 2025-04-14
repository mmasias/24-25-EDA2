public class Frame {
    private int altura;
    private int anchura;
    private Pixel[][] pixeles;

    public Frame(int altura, int anchura) {
        this.altura = altura;
        this.anchura = anchura;
        this.pixeles = new Pixel[altura][anchura];

  
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                pixeles[y][x] = new Pixel(x, y, ' ');
            }
        }
    }

    public void setPixel(int x, int y, char color) {
        if (x >= 0 && x < anchura && y >= 0 && y < altura) {
            pixeles[y][x].setColor(color);
        }
    }

    public char getPixelColor(int x, int y) {
        if (x >= 0 && x < anchura && y >= 0 && y < altura) {
            return pixeles[y][x].getColor();
        }
        return ' ';
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public void renderizar() {
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                System.out.print(getPixelColor(x, y) + " - ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
