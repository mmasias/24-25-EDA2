public class PantallaEntrelazada extends Pantalla {
    private Escena escena;

    public PantallaEntrelazada(Resolucion resolucion) {
        super(resolucion);
        this.escena = new Escena(resolucion, 2);
    }
    public void renderizar(){
        for (int i = 0; i < resolucion.getAlto(); i++) {
            for (int j = 0; j < resolucion.getAncho()*escena.nFrames(); j++) {
                if (j==resolucion.getAncho()) {
                    this.escena.siguiente();
                }
                
                
                System.out.print(this.escena.getFrame().getPixel(new Coordenada(j%resolucion.getAncho(),i)).getCaracter());

            }
            this.escena.siguiente();
            System.out.println();
        }
    }
    public Escena getEscena() {
        return escena;
    }

}
