public class Main {
    public static void main(String[] args) {
        final int ALTO = 3, ANCHO = 7;
        GestorPantalla pantalla = new GestorPantalla(ANCHO,ALTO);

        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                int numeroAleatorio = ((int)(Math.random()*100))%4;
                pantalla.establecerPixel(new Coordenada(i, j), numeroAleatorio,0);
                numeroAleatorio = ((int)(Math.random()*100))%4;
                pantalla.establecerPixel(new Coordenada(i, j), numeroAleatorio,1);
            }
        }
        pantalla.renderizar();
    }
   
}
