public class Frame {
    private Resolucion resolucion;
    private Pixel[][] pixels;

    public Frame(Resolucion resolucion) {
        this.resolucion = resolucion;
        this.pixels = new Pixel[resolucion.getAlto()][resolucion.getAncho()];
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
        if (coordenada.getX() >= 0 && coordenada.getX() < resolucion.getAncho() && coordenada.getY() >= 0
                && coordenada.getY() < resolucion.getAlto()) {
            return true;
        }
        return false;
    }
}
