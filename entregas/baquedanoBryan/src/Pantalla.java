public class Pantalla {
    public static void mostrarFrames(Frame frame1, Frame frame2) {
        int filas = frame1.pixeles.length;
        int columnas = frame1.pixeles[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(frame1.getPixel(i, j).getSimbolo() + " ");
            }

            System.out.print("   ");

            for (int j = 0; j < columnas; j++) {
                System.out.print(frame2.getPixel(i, j).getSimbolo() + " ");
            }

            System.out.println();
        }

        System.out.println(); 
    }

    public static String ajustarLongitud(String linea, int longitud) {
        if (linea.length() > longitud) {
            return linea.substring(0, longitud); 
        } else if (linea.length() < longitud) {
            return linea + " ".repeat(longitud - linea.length()); 
        }
        return linea;
    }
}
