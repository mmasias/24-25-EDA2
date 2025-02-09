public class Frame {
    private int altura, anchura;
    private Pixel[][] pixeles;

    public Frame(int anchura, int altura) {
        this.anchura = anchura;
        this.altura = altura;
        this.pixeles = new Pixel[altura][anchura];

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                pixeles[i][j] = new Pixel(j, i, ' '); // Espacio vacío por defecto
            }
        }
    }

    public void setPixel(int x, int y, char color) {
        if (x >= 0 && x < anchura && y >= 0 && y < altura) {
            pixeles[y][x].setColor(color);
        }
    }

    public Pixel[][] getPixeles() {
        return pixeles;
    }

    public void renderizar() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                System.out.print(pixeles[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }
}
