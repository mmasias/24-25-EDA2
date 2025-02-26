public class PantallaEntrelazada extends Pantalla {
    private Escena escena;

    public PantallaEntrelazada(int ancho, int alto) {
        super(ancho,alto);
        this.escena = new Escena(ancho, alto, 2);
    }
    public void renderizar(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho*escena.nFrames(); j++) {
                if (j==ancho) {
                    this.escena.siguiente();
                }
                
                
                System.out.print(this.escena.getFrame().getPixel(new Coordenada(j%ancho,i)).getCaracter());

            }
            this.escena.siguiente();
            System.out.println();
        }
    }
    public Escena getEscena() {
        return escena;
    }

}