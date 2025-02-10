public class Resolucion {

    private int ancho;
    private int alto;

    public Resolucion(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAncho(){
        return this.ancho;
    }

    public int getAlto(){
        return this.alto;
    }

    public int getMitadAncho(){
        return this.ancho/2;
    }

}