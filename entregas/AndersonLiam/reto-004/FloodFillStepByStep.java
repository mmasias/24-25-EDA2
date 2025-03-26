import java.util.concurrent.TimeUnit;

public class FloodFillStepByStep {

    public static void main(String[] args) throws InterruptedException {
        char[][] imagen = crearImagenEjemplo(PLANTILLA_001);

        System.out.println("Imagen original:");
        imprimirImagen(imagen);

        // Paso 1: Pintar el fondo con comillas simples
        System.out.println("Paso 1: Pintar el fondo con comillas simples (')");
        rellenarRecursivo(imagen, 0, 0, '\'', '.');
        imprimirImagenConRetraso(imagen);

        // Paso 2: Pintar la primera fila de rectángulos con 'o'
        System.out.println("Paso 2: Pintar la primera fila de rectángulos con 'o'");
        rellenarRecursivo(imagen, 3, 3, 'o', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 19, 3, 'o', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 35, 3, 'o', ' ');
        imprimirImagenConRetraso(imagen);

        // Paso 3: Pintar la segunda fila de rectángulos con 'x'
        System.out.println("Paso 3: Pintar la segunda fila de rectángulos con 'x'");
        rellenarRecursivo(imagen, 3, 10, 'x', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 13, 10, 'x', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 25, 10, 'x', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 37, 10, 'x', ' ');
        imprimirImagenConRetraso(imagen);

        // Paso 4: Pintar la tercera fila de rectángulos con '|'
        System.out.println("Paso 4: Pintar la tercera fila de rectángulos con '|'");
        rellenarRecursivo(imagen, 3, 15, '|', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 19, 15, '|', ' ');
        imprimirImagenConRetraso(imagen);
        rellenarRecursivo(imagen, 35, 15, '|', ' ');
        imprimirImagenConRetraso(imagen);

        System.out.println("Imagen final:");
        imprimirImagen(imagen);
    }

    private static String[] PLANTILLA_001 = {
            ".....................................................",
            ".....................................................",
            "..########........#########.......########...........",
            "..#      #........#       #.......#      #...........",
            "..#      #........#       #.......#      #...........",
            "..#      #........#       #.......#      #...........",
            "..########........#########.......########...........",
            ".....................................................",
            "..########....########....########....########.......",
            "..#      #....#      #....#      #....#      #.......",
            "..#      #....#      #....#      #....#      #.......",
            "..########....########....########....########.......",
            ".....................................................",
            "..#######.........#######.........#######............",
            "..#     #.........#     #.........#     #............",
            "..#     #.........#     #.........#     #............",
            "..#######.........#######.........#######............",
            ".....................................................",
            ".....................................................",
            "....................................................."
    };

    private static int altura;
    private static int anchura;

    private static char[][] crearImagenEjemplo(String[] imagenOriginal) {
        altura = imagenOriginal.length;
        anchura = imagenOriginal[0].length();

        char[][] imagen = new char[altura][anchura];

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                imagen[y][x] = '.';
            }
        }

        for (int y = 0; y < imagenOriginal.length; y++) {
            char[] fila = imagenOriginal[y].toCharArray();
            for (int x = 0; x < fila.length; x++) {
                imagen[y][x] = fila[x];
            }
        }

        return imagen;
    }

    public static void rellenarRecursivo(char[][] imagen, int x, int y, char nuevoCaracter, char caracterOriginal) {
        if (caracterOriginal == '\0') {
            caracterOriginal = imagen[y][x];
        }

        if (y < 0 || y >= imagen.length || x < 0 || x >= imagen[0].length) {
            return;
        }

        if (imagen[y][x] != caracterOriginal || caracterOriginal == nuevoCaracter) {
            return;
        }

        imagen[y][x] = nuevoCaracter;

        rellenarRecursivo(imagen, x + 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x - 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y + 1, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y - 1, nuevoCaracter, caracterOriginal);
    }

    public static void imprimirImagen(char[][] imagen) {
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                System.out.print(imagen[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void imprimirImagenConRetraso(char[][] imagen) throws InterruptedException {
        imprimirImagen(imagen);
        TimeUnit.MILLISECONDS.sleep(500); // Retraso de 500 ms entre cada paso
    }
}