import java.util.Scanner;
import java.util.Stack;

public class FloodFill {

    private static final boolean DEPURACION = false;

    private static int dimensionVertical;
    private static int dimensionHorizontal;

    public static void main(String[] args) {
        char[][] mapa = generarMapaEjemplo(DISEÑO_BASE);
        ejecutarProcesoDeRelleno(mapa);
    }

    private static String[] DISEÑO_BASE = {
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

    private static void ejecutarProcesoDeRelleno(char[][] mapa) {

        mostrarMapa(mapa);
        System.out.println("Mapa original - Pulse una tecla para comenzar el relleno");
        new Scanner(System.in).nextLine();

        procesarZonas(mapa);

        mostrarMapa(mapa);
        System.out.println("Mapa después del relleno automático");
    }

    public static void procesarZonas(char[][] mapa) {
        char[] colores = { 'o', 'x', '|', '*' };
        int indiceColor = 0;

        rellenarRecursivo(mapa, 0, 0, '?', '.');

        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[0].length; columna++) {
                if (mapa[fila][columna] == '.') {
                    rellenarRecursivo(mapa, columna, fila, colores[indiceColor % colores.length], '.');
                    indiceColor++;
                }
            }
        }

        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[0].length; columna++) {
                if (mapa[fila][columna] == '?') {
                    mapa[fila][columna] = '.';
                }
            }
        }
    }

    private static char[][] generarMapaEjemplo(String[] imagenOriginal) {
        dimensionVertical = imagenOriginal.length;
        dimensionHorizontal = imagenOriginal[0].length();

        char[][] mapa = inicializarMapaVacio();

        copiarImagenOriginal(mapa, imagenOriginal);

        return mapa;
    }

    private static char[][] inicializarMapaVacio() {
        char[][] mapa = new char[dimensionVertical][dimensionHorizontal];
        for (int fila = 0; fila < dimensionVertical; fila++) {
            for (int columna = 0; columna < dimensionHorizontal; columna++) {
                mapa[fila][columna] = '.';
            }
        }
        return mapa;
    }

    private static void copiarImagenOriginal(char[][] mapa, String[] imagenOriginal) {
        for (int fila = 0; fila < imagenOriginal.length; fila++) {
            char[] lineaActual = imagenOriginal[fila].toCharArray();
            for (int columna = 0; columna < lineaActual.length; columna++) {
                mapa[fila][columna] = lineaActual[columna];
            }
        }
    }

    public static void rellenarRecursivo(char[][] mapa, int x, int y, char nuevoCaracter, char caracterOriginal) {
        if (caracterOriginal == '\0') {
            caracterOriginal = mapa[y][x];
        }
        if (y < 0 || y >= mapa.length || x < 0 || x >= mapa[0].length) {
            return;
        }
        if (mapa[y][x] != caracterOriginal || caracterOriginal == nuevoCaracter) {
            return;
        }
        mapa[y][x] = nuevoCaracter;

        if (DEPURACION) {
            mostrarMapa(mapa);
            new Scanner(System.in).nextLine();
        }

        rellenarRecursivo(mapa, x + 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(mapa, x - 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(mapa, x, y + 1, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(mapa, x, y - 1, nuevoCaracter, caracterOriginal);
    }

    public static void rellenarIterativo(char[][] mapa, int x, int y, char nuevoCaracter) {
        char caracterOriginal = mapa[y][x];
        if (caracterOriginal == nuevoCaracter) {
            return;
        }

        Stack<int[]> pila = new Stack<>();
        pila.push(new int[] { x, y });

        while (!pila.isEmpty()) {
            int[] coordenada = pila.pop();
            int actualX = coordenada[0];
            int actualY = coordenada[1];

            if (DEPURACION) {
                mostrarMapa(mapa);
                new Scanner(System.in).nextLine();
            }

            if (actualY < 0 || actualY >= mapa.length ||
                    actualX < 0 || actualX >= mapa[0].length ||
                    mapa[actualY][actualX] != caracterOriginal) {
                continue;
            }

            mapa[actualY][actualX] = nuevoCaracter;

            pila.push(new int[] { actualX, actualY + 1 });
            pila.push(new int[] { actualX, actualY - 1 });
            pila.push(new int[] { actualX + 1, actualY });
            pila.push(new int[] { actualX - 1, actualY });
        }
    }

    public static int contarZonas(char[][] mapa) {
        char[][] copia = crearCopiaMapa(mapa);
        int contador = 0;

        for (int fila = 0; fila < copia.length; fila++) {
            for (int columna = 0; columna < copia[0].length; columna++) {
                if (copia[fila][columna] == '.') {
                    contador++;
                    rellenarRecursivo(copia, columna, fila, 'o', '.');
                }
            }
        }

        return contador;
    }

    private static char[][] crearCopiaMapa(char[][] mapa) {
        char[][] copia = new char[mapa.length][mapa[0].length];
        for (int fila = 0; fila < mapa.length; fila++) {
            System.arraycopy(mapa[fila], 0, copia[fila], 0, mapa[0].length);
        }
        return copia;
    }

    public static void mostrarMapa(char[][] mapa) {
        limpiarPantalla();
        for (int fila = 0; fila < mapa.length; fila++) {
            for (int columna = 0; columna < mapa[0].length; columna++) {
                System.out.print(mapa[fila][columna]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}