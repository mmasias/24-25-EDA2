public class Frame {
    private int anchura;
    private int altura;
    private Pixel[][] pixels;

    public Frame(int anchura, int altura) {
        this.anchura = anchura;
        this.altura = altura;
        this.pixels = new Pixel[altura][anchura];
        borrarTodo();
    }

    public void borrar(Coordenada coordenada) {

        this.pixels[coordenada.getY()][coordenada.getX()] = Pixel.NEGRO;

    }

    public void borrarTodo() {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {

                this.pixels[i][j] = Pixel.NEGRO;

            }
        }
    }

    public void establecerPixel(Coordenada coordenada, Pixel pixel) {
        if (validarCoordenada(coordenada)) {
            this.pixels[coordenada.getY()][coordenada.getX()] = pixel;
        }

    }
    public Pixel getPixel(Coordenada coordenada){
        
        return this.pixels[coordenada.getY()][coordenada.getX()];
    }

    public Pixel[][] getPixels() {
        return pixels;
    }

    public void pintar() {

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                System.out.print(pixels[i][j].getCaracter());
            }
            System.out.println();
        }

    }

    public boolean validarCoordenada(Coordenada coordenada) {
        if (coordenada.getX() >= 0 && coordenada.getX() < anchura && coordenada.getY() >= 0
                && coordenada.getY() < altura) {
            return true;
        }
        return false;
    }
}
