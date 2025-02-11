public class PantallaSuperpuesta extends Pantalla {
    private Escena escena;

    public PantallaSuperpuesta(int ancho, int alto) {
        super(ancho,alto);
        this.escena = new Escena(ancho, alto, 2);
    }
    public void renderizar(){
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {         
                Coordenada cordenada = new Coordenada(j, i);    
                Pixel p1 = escena.getFrame().getPixel(cordenada);
                escena.siguiente();
                Pixel p2 = escena.getFrame().getPixel(cordenada);

                Pixel pixel = aritmeticaColores(p1, p2);


                System.out.print(pixel.getCaracter());

            }
            System.out.println();
        }
    }
    public Escena getEscena() {
        return escena;
    }
        public Pixel aritmeticaColores(Pixel pixel1, Pixel pixel2){
        Pixel[][]paleta ={
            {Pixel.NEGRO,Pixel.GRIS,Pixel.CYAN_TENUE,Pixel.MAGENTA_TENUE},
            {Pixel.GRIS,Pixel.BLANCO,Pixel.CYAN_BRILLANTE,Pixel.MAGENTA_BRILLANTE},
            {Pixel.CYAN_TENUE,Pixel.CYAN_BRILLANTE,Pixel.CYAN,Pixel.BLANCO_TENUE},
            {Pixel.MAGENTA_TENUE,Pixel.MAGENTA_BRILLANTE,Pixel.BLANCO_TENUE,Pixel.MAGENTA}
        };

        return paleta[pixel1.getColor()][pixel2.getColor()];

    

    }
}

