import java.util.Scanner;
import java.util.Stack;

public class RellenoInundacion {

    final static boolean MODO_DEBUG = true; // Activar para ver el proceso paso a paso

    public static void main(String[] args) {
        char[][] imagen = crearImagenEjemplo(PLANTILLA_001);

        imprimirImagen(imagen);
        System.out.println("Imagen original -- Pulse Enter para empezar a pintar");
        new Scanner(System.in).nextLine();

        rellenarAreasCerradas(imagen);
        imprimirImagen(imagen);
        System.out.println("Imagen después de rellenar áreas cerradas");
    }

    private static String[] PLANTILLA_001 = {
            "................................",
            "..#########......#########......",
            "..#.......#......#.......#......",
            "..#.......#......#.......#......",
            "..#########......#########......",
            "................................",
            "..####....####....####....####..",
            "..#..#....#..#....#..#....#..#..",
            "..#..#....#..#....#..#....#..#..",
            "..####....####....####....####..",
            "................................"
    };

    private static int altura, anchura;

    private static char[][] crearImagenEjemplo(String[] imagenOriginal) {
        altura = imagenOriginal.length;
        anchura = imagenOriginal[0].length();
        char[][] imagen = new char[altura][anchura];

        for (int y = 0; y < altura; y++) {
            imagen[y] = imagenOriginal[y].toCharArray();
        }
        return imagen;
    }

    public static void rellenarAreasCerradas(char[][] imagen) {
        char[] simbolos = {'o', 'x', '|'};
        int simboloIndex = 0;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                if (imagen[y][x] == '.' && esAreaCerrada(imagen, x, y)) {
                    rellenarArea(imagen, x, y, simbolos[simboloIndex % simbolos.length]);
                    simboloIndex++;
                }
            }
        }
    }

    public static boolean esAreaCerrada(char[][] imagen, int x, int y) {
        Stack<int[]> pila = new Stack<>();
        boolean[][] visitado = new boolean[altura][anchura];
        pila.push(new int[]{x, y});
        visitado[y][x] = true;

        while (!pila.isEmpty()) {
            int[] coord = pila.pop();
            int actualX = coord[0];
            int actualY = coord[1];

            if (actualX < 0 || actualY < 0 || actualX >= anchura || actualY >= altura || imagen[actualY][actualX] == '#') {
                return false;
            }

            if (!visitado[actualY][actualX]) {
                visitado[actualY][actualX] = true;
                pila.push(new int[]{actualX + 1, actualY});
                pila.push(new int[]{actualX - 1, actualY});
                pila.push(new int[]{actualX, actualY + 1});
                pila.push(new int[]{actualX, actualY - 1});
            }
        }

        return true;
    }

    public static void rellenarArea(char[][] imagen, int x, int y, char simbolo) {
        Stack<int[]> pila = new Stack<>();
        pila.push(new int[]{x, y});

        while (!pila.isEmpty()) {
            int[] coord = pila.pop();
            int actualX = coord[0];
            int actualY = coord[1];

            if (actualX < 0 || actualY < 0 || actualX >= anchura || actualY >= altura || imagen[actualY][actualX] != '.') {
                continue;
            }

            imagen[actualY][actualX] = simbolo;
            imprimirImagen(imagen);
            esperar(200);

            pila.push(new int[]{actualX + 1, actualY});
            pila.push(new int[]{actualX - 1, actualY});
            pila.push(new int[]{actualX, actualY + 1});
            pila.push(new int[]{actualX, actualY - 1});
        }
    }

    public static void imprimirImagen(char[][] imagen) {
        cleanScreen();
        for (char[] fila : imagen) {
            System.out.println(fila);
        }
        System.out.println();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
