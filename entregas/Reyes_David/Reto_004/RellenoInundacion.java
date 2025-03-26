package entregas.Reyes_David.Reto_004;

import java.util.Scanner;

public class RellenoInundacion {

    final static boolean MODO_DEBUG = false;
    private static int altura;
    private static int anchura;
    private static final char[] COLORES = { '*', 'o', 'x', '|' };

    public static void main(String[] args) {
        char[][] imagen = crearImagenEjemplo(PLANTILLA_001);
        imprimirImagen(imagen);

        System.out.println("Imagen original -- Pulse ENTER para empezar a pintarla");
        esperarEnter();

        rellenarRecursivo(imagen, 0, 0, COLORES[0], imagen[0][0]);
        imprimirImagen(imagen);
        System.out.println("Fondo rellenado, presiona ENTER para continuar...");
        esperarEnter();

        rellenarZona(imagen, 2, 2, COLORES[1]);
        rellenarZona(imagen, 4, 4, COLORES[1]);
        rellenarZona(imagen, 4, 36, COLORES[1]);
        imprimirImagen(imagen);
        System.out.println("Zona superior rellenada, presiona ENTER para continuar...");
        esperarEnter();

        rellenarZona(imagen, 10, 4, COLORES[2]);
        rellenarZona(imagen, 10, 15, COLORES[2]);
        rellenarZona(imagen, 10, 26, COLORES[2]);
        rellenarZona(imagen, 10, 40, COLORES[2]);
        imprimirImagen(imagen);
        System.out.println("Zona media rellenada, presiona ENTER para continuar...");
        esperarEnter();

        rellenarZona(imagen, 15, 4, COLORES[3]);
        rellenarZona(imagen, 15, 20, COLORES[3]);
        rellenarZona(imagen, 15, 36, COLORES[3]);
        imprimirImagen(imagen);
        System.out.println("Zona inferior rellenada, presiona ENTER para finalizar...");
        esperarEnter();

        System.out.println("Imagen completamente rellenada.");
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

    private static char[][] crearImagenEjemplo(String[] imagenOriginal) {
        altura = imagenOriginal.length;
        anchura = imagenOriginal[0].length();
        char[][] imagen = new char[altura][anchura];

        for (int y = 0; y < altura; y++) {
            imagen[y] = imagenOriginal[y].toCharArray();
        }

        return imagen;
    }

    private static void rellenarZona(char[][] imagen, int startY, int startX, char color) {
        for (int y = startY; y < altura; y++) {
            for (int x = startX; x < anchura; x++) {
                if (esPuntoDeRelleno(imagen, x, y)) {
                    rellenarRecursivo(imagen, x, y, color, imagen[y][x]);
                    imprimirImagen(imagen);
                    System.out.println("Presiona ENTER para continuar...");
                    esperarEnter();
                    return;
                }
            }
        }
    }

    private static boolean esPuntoDeRelleno(char[][] imagen, int x, int y) {
        if (imagen[y][x] != '.')
            return false;

        return (x > 0 && imagen[y][x - 1] == '#') ||
                (x < anchura - 1 && imagen[y][x + 1] == '#') ||
                (y > 0 && imagen[y - 1][x] == '#') ||
                (y < altura - 1 && imagen[y + 1][x] == '#');
    }

    public static void rellenarRecursivo(char[][] imagen, int x, int y, char nuevoCaracter, char caracterOriginal) {
        if (y < 0 || y >= imagen.length || x < 0 || x >= imagen[0].length)
            return;
        if (imagen[y][x] != caracterOriginal || imagen[y][x] == nuevoCaracter)
            return;

        imagen[y][x] = nuevoCaracter;

        if (MODO_DEBUG) {
            imprimirImagen(imagen);
            esperarEnter();
        }

        rellenarRecursivo(imagen, x + 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x - 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y + 1, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y - 1, nuevoCaracter, caracterOriginal);
    }

    public static void imprimirImagen(char[][] imagen) {
        cleanScreen();
        for (char[] fila : imagen) {
            System.out.println(fila);
        }
        System.out.println();
    }

    private static void esperarEnter() {
        new Scanner(System.in).nextLine();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
