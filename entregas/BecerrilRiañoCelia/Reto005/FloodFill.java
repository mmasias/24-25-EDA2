import java.util.Scanner;

public class FloodFill {
    final static boolean MODO_DEBUG = true;

    public static void main(String[] args) {
        char[][] imagenOriginal = {
            ".....................................................".toCharArray(),
            ".....................................................".toCharArray(),
            "..########........#########.......########...........".toCharArray(),
            "..#......#........#.......#.......#......#...........".toCharArray(),
            "..#......#........#.......#.......#......#...........".toCharArray(),
            "..#......#........#.......#.......#......#...........".toCharArray(),
            "..########........#########.......########...........".toCharArray(),
            ".....................................................".toCharArray(),
            "..########....########....########....########.......".toCharArray(),
            "..#......#....#......#....#......#....#......#.......".toCharArray(),
            "..#......#....#......#....#......#....#......#.......".toCharArray(),
            "..########....########....########....########.......".toCharArray(),
            ".....................................................".toCharArray(),
            "..#######.........#######.........#######............".toCharArray(),
            "..#.....#.........#.....#.........#.....#............".toCharArray(),
            "..#.....#.........#.....#.........#.....#............".toCharArray(),
            "..#######.........#######.........#######............".toCharArray(),
            ".....................................................".toCharArray(),
            ".....................................................".toCharArray(),
            ".....................................................".toCharArray()
        };

        char[][] imagenTransformada = transformarImagen(imagenOriginal);
        imprimirImagen(imagenTransformada);
    }

    public static char[][] transformarImagen(char[][] imagen) {
        int altura = imagen.length;
        int anchura = imagen[0].length;
        char[][] nuevaImagen = new char[altura][anchura];
        
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                nuevaImagen[y][x] = imagen[y][x];
            }
        }

        rellenarRecursivo(nuevaImagen, 3, 3, 'o', '\0');
        rellenarRecursivo(nuevaImagen, 19, 3, 'o', '\0');
        rellenarRecursivo(nuevaImagen, 35, 3, 'o', '\0');

        rellenarRecursivo(nuevaImagen, 3, 9, 'x', '\0');
        rellenarRecursivo(nuevaImagen, 15, 9, 'x', '\0');
        rellenarRecursivo(nuevaImagen, 27, 9, 'x', '\0');
        rellenarRecursivo(nuevaImagen, 39, 9, 'x', '\0');

        rellenarRecursivo(nuevaImagen, 3, 15, '|', '\0');
        rellenarRecursivo(nuevaImagen, 19, 15, '|', '\0');
        rellenarRecursivo(nuevaImagen, 35, 15, '|', '\0');

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                if (nuevaImagen[y][x] == '.') {
                    nuevaImagen[y][x] = '\'';
                }
            }
        }

        return nuevaImagen;
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
        for (char[] fila : imagen) {
            System.out.println(fila);
        }
    }
}