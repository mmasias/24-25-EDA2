public class Main {
    public static void main(String[] args) {
        int filas = 14;
        int columnas = 30;
        Animacion animacion = new Animacion(500);

        Frame frame1 = new Frame(filas, columnas);
        Frame frame2 = new Frame(filas, columnas);

        String[] mundoParteIzquierda = {
            " ########################### ",
            " ~~~~~~      ^^^^^^^^        ",
            " ~~~~~~      ^^^^^^^^  TT    ",
            "   TT            TT          ",
            "                  TT         ",
            "       @         ######      ",
            "                 #    #      ",
            "     @  ##       #    #  @   ",
            "        ##       ######      ",
            "                  TT         ",
            "         TT       TT         ",
            "     @         @             ",
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~  ",
            " ###########################"
        };

        String[] mundoParteDerecha = {
            " ############################# ",
            " ~~~~~~      ^^^^^^^^         ",
            " ~~~~~~      ^^^^^^^^  TT     ",
            "                  TT          ",
            "   TT            TT           ",
            "       @         ######       ",
            "     @           #    #       ",
            "        ##       #    #  @    ",
            "     @  ##       ######       ",
            "                  TT          ",
            "         TT       TT          ",
            "                 @            ",
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~   ",
            " ###########################"
        };

        for (int i = 0; i < filas; i++) {
            mundoParteIzquierda[i] = Pantalla.ajustarLongitud(mundoParteIzquierda[i], columnas);
            mundoParteDerecha[i] = Pantalla.ajustarLongitud(mundoParteDerecha[i], columnas);
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                frame1.setPixel(i, j, mundoParteIzquierda[i].charAt(j));
                frame2.setPixel(i, j, mundoParteDerecha[i].charAt(j));
            }
        }

        animacion.agregarFrame(frame1);
        animacion.agregarFrame(frame2);
        animacion.reproducir();
    }
}
