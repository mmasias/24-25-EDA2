import java.util.Scanner;
import java.util.Stack;

public class RellenoInundacion {

    final static boolean MODO_DEBUG = false;

    public static void main(String[] args) {
        char[][] imagen = inicializarImagen(PLANTILLA_001);

        imprimirImagen(imagen);
        System.out.println("Imagen original -- Presione Enter para iniciar el pintado");
        new Scanner(System.in).nextLine();

        aplicarRelleno(imagen);

        imprimirImagen(imagen);
        System.out.println("Imagen después del relleno automático");
    }

    public static void aplicarRelleno(char[][] imagen) {
        rellenarRecursivo(imagen, 0, 0, '?', '.');

        rellenarRecursivo(imagen, 3, 3, 'o', '.');
        rellenarRecursivo(imagen, 20, 3, 'o', '.');
        rellenarRecursivo(imagen, 37, 3, 'o', '.');

        rellenarRecursivo(imagen, 3, 10, 'x', '.');
        rellenarRecursivo(imagen, 15, 10, 'x', '.');
        rellenarRecursivo(imagen, 27, 10, 'x', '.');
        rellenarRecursivo(imagen, 39, 10, 'x', '.');

        rellenarRecursivo(imagen, 3, 15, '|', '.');
        rellenarRecursivo(imagen, 20, 15, '|', '.');
        rellenarRecursivo(imagen, 37, 15, '|', '.');

        limpiarMarcadores(imagen);
    }

    private static void limpiarMarcadores(char[][] imagen) {
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                if (imagen[y][x] == '?') {
                    imagen[y][x] = '.';
                }
            }
        }
    }

    private static String[] PLANTILLA_001 = {
            ".....................................................",
            ".....................................................",
            "..########........#########.......########...........",
            "..#......#........#.......#.......#......#...........",
            "..#......#........#.......#.......#......#...........",
            "..#......#........#.......#.......#......#...........",
            "..########........#########.......########...........",
            ".....................................................",
            "..########....########....########....########.......",
            "..#......#....#......#....#......#....#......#.......",
            "..#......#....#......#....#......#....#......#.......",
            "..########....########....########....########.......",
            ".....................................................",
            "..#######.........#######.........#######............",
            "..#.....#.........#.....#.........#.....#............",
            "..#.....#.........#.....#.........#.....#............",
            "..#######.........#######.........#######............",
            ".....................................................",
            ".....................................................",
            "....................................................."
    };

    private static char[][] inicializarImagen(String[] imagenOriginal) {
        int altura = imagenOriginal.length;
        int anchura = imagenOriginal[0].length();
        char[][] imagen = new char[altura][anchura];

        for (int y = 0; y < altura; y++) {
            imagen[y] = imagenOriginal[y].toCharArray();
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
        if (MODO_DEBUG) {
            imprimirImagen(imagen);
            new Scanner(System.in).nextLine();
        }

        rellenarRecursivo(imagen, x + 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x - 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y + 1, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y - 1, nuevoCaracter, caracterOriginal);
    }

    public static void imprimirImagen(char[][] imagen) {
        cleanScreen();
        for (char[] fila : imagen) {
            System.out.println(new String(fila));
        }
        System.out.println();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
