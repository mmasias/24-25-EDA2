    import java.util.Scanner;

    public class RellenoInundacion {

        public static void main(String[] args) {
            char[][] imagen = crearImagenEjemplo(PLANTILLA_001);
            
            
            rellenarRecursivo(imagen, 3, 3, 'o'); 
            rellenarRecursivo(imagen, 10, 10, 'x'); 
            rellenarRecursivo(imagen, 25, 14, '|'); 
            rellenarRecursivo(imagen, 0, 0, '\'');
            
            imprimirImagen(imagen);
            System.out.println("Imagen después del relleno por inundación");
        }

        private static String[] PLANTILLA_001 = {
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
                "''########''''''''#########'''''''########'''''''''''",
                "''#......#''''''''#.......#'''''''#......#'''''''''''",
                "''#......#''''''''#.......#'''''''#......#'''''''''''",
                "''#......#''''''''#.......#'''''''#......#'''''''''''",
                "''########''''''''#########'''''''########'''''''''''",
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
                "''########''''########''''########''''########'''''''",
                "''#......#''''#......#''''#......#''''#......#'''''''",
                "''#......#''''#......#''''#......#''''#......#'''''''",
                "''########''''########''''########''''########'''''''",
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
                "''#######'''''''''#######'''''''''#######''''''''''''",
                "''#.....#'''''''''#.....#'''''''''#.....#''''''''''''",
                "''#.....#'''''''''#.....#'''''''''#.....#''''''''''''",
                "''#######'''''''''#######'''''''''#######''''''''''''",
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
                "'''''''''''''''''''''''''''''''''''''''''''''''''''''",
        };

        private static int altura;
        private static int anchura;

        private static char[][] crearImagenEjemplo(String[] imagenOriginal) {
            altura = imagenOriginal.length;
            anchura = imagenOriginal[0].length();

            char[][] imagen = new char[altura][anchura];

            for (int y = 0; y < altura; y++) {
                imagen[y] = imagenOriginal[y].toCharArray();
            }
            return imagen;
        }

        public static void rellenarRecursivo(char[][] imagen, int x, int y, char nuevoCaracter) {
            char caracterOriginal = imagen[y][x];
            if (caracterOriginal == nuevoCaracter) {
                return;
            }
            floodFill(imagen, x, y, caracterOriginal, nuevoCaracter);
        }

        private static void floodFill(char[][] imagen, int x, int y, char caracterOriginal, char nuevoCaracter) {
            if (x < 0 || x >= anchura || y < 0 || y >= altura) {
                return;
            }
            if (imagen[y][x] != caracterOriginal) {
                return;
            }

            imagen[y][x] = nuevoCaracter;

            floodFill(imagen, x + 1, y, caracterOriginal, nuevoCaracter);
            floodFill(imagen, x - 1, y, caracterOriginal, nuevoCaracter);
            floodFill(imagen, x, y + 1, caracterOriginal, nuevoCaracter);
            floodFill(imagen, x, y - 1, caracterOriginal, nuevoCaracter);
        }

        public static void imprimirImagen(char[][] imagen) {
            for (char[] fila : imagen) {
                System.out.println(new String(fila));
            }
            System.out.println();
        }
    }