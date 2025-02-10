public class Dimension {
    private int ancho;
    private int alto;
    private int tamaño;

    public Dimension(int ancho, int alto, int tamaño) {
        this.ancho = ancho;
        this.alto = alto;
        this.tamaño = tamaño;
    }

    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }

    public int getTamaño(){
        return tamaño;
    }
}
