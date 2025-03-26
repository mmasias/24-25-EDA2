import java.util.Scanner;
import java.util.Stack;

public class InundacionRelleno {

    final static boolean DEBUG_MODE = false;

    private static String[] PATRON = {
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

    public static void main(String[] args) {
        char[][] matriz = generarMatrizEjemplo(PATRON);

        mostrarMatriz(matriz);
        System.out.println("Imagen original -- Pulse una tecla para comenzar");
        new Scanner(System.in).nextLine();

        procesarMatriz(matriz);
        mostrarMatriz(matriz);
        System.out.println("Imagen después del relleno por inundación automático");
    }

    private static void procesarMatriz(char[][] matriz) {
        aplicarRellenoRecursivo(matriz, 0, 0, '?', '.');

        aplicarRellenoRecursivo(matriz, 3, 3, 'o', '.');
        aplicarRellenoRecursivo(matriz, 20, 3, 'o', '.');
        aplicarRellenoRecursivo(matriz, 37, 3, 'o', '.');

        aplicarRellenoRecursivo(matriz, 3, 10, 'x', '.');
        aplicarRellenoRecursivo(matriz, 15, 10, 'x', '.');
        aplicarRellenoRecursivo(matriz, 27, 10, 'x', '.');
        aplicarRellenoRecursivo(matriz, 39, 10, 'x', '.');

        aplicarRellenoRecursivo(matriz, 3, 15, '|', '.');
        aplicarRellenoRecursivo(matriz, 20, 15, '|', '.');
        aplicarRellenoRecursivo(matriz, 37, 15, '|', '.');

        limpiarCaracteres(matriz, '?', '.');
    }

    private static char[][] generarMatrizEjemplo(String[] plantilla) {
        int filas = plantilla.length;
        int columnas = plantilla[0].length();
        char[][] matriz = new char[filas][columnas];

        for (int y = 0; y < filas; y++) {
            matriz[y] = plantilla[y].toCharArray();
        }
        return matriz;
    }

    private static void aplicarRellenoRecursivo(char[][] matriz, int x, int y, char nuevo, char original) {
        if (original == '\0') original = matriz[y][x];
        if (y < 0 || y >= matriz.length || x < 0 || x >= matriz[0].length) return;
        if (matriz[y][x] != original || original == nuevo) return;

        matriz[y][x] = nuevo;
        if (DEBUG_MODE) {
            mostrarMatriz(matriz);
            new Scanner(System.in).nextLine();
        }

        aplicarRellenoRecursivo(matriz, x + 1, y, nuevo, original);
        aplicarRellenoRecursivo(matriz, x - 1, y, nuevo, original);
        aplicarRellenoRecursivo(matriz, x, y + 1, nuevo, original);
        aplicarRellenoRecursivo(matriz, x, y - 1, nuevo, original);
    }

    private static void aplicarRellenoIterativo(char[][] matriz, int x, int y, char nuevo) {
        char original = matriz[y][x];
        if (original == nuevo) return;

        Stack<int[]> pila = new Stack<>();
        pila.push(new int[]{x, y});

        while (!pila.isEmpty()) {
            int[] coord = pila.pop();
            int px = coord[0], py = coord[1];

            if (py < 0 || py >= matriz.length || px < 0 || px >= matriz[0].length || matriz[py][px] != original) continue;

            matriz[py][px] = nuevo;
            pila.push(new int[]{px, py + 1});
            pila.push(new int[]{px, py - 1});
            pila.push(new int[]{px + 1, py});
            pila.push(new int[]{px - 1, py});
        }
    }

    private static void limpiarCaracteres(char[][] matriz, char objetivo, char reemplazo) {
        for (int y = 0; y < matriz.length; y++) {
            for (int x = 0; x < matriz[0].length; x++) {
                if (matriz[y][x] == objetivo) {
                    matriz[y][x] = reemplazo;
                }
            }
        }
    }

    private static void mostrarMatriz(char[][] matriz) {
        limpiarPantalla();
        for (char[] fila : matriz) {
            System.out.println(new String(fila));
        }
        System.out.println();
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

