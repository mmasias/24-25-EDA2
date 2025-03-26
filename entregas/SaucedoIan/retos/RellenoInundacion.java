import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RellenoInundacion {

    final static boolean MODO_DEBUG = false;
    private static Stack<char[][]> historialDeshacer = new Stack<>();
    private static Stack<char[][]> historialRehacer = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] imagen = crearImagenEjemplo(PLANTILLA_001);
        ImagenLogger logger = new ImagenLogger("log_relleno.txt");

        System.out.println("1. Nueva imagen");
        System.out.println("2. Cargar obra anterior");
        String opcion = scanner.nextLine();

        if (opcion.equals("2")) {
            List<String> obras = logger.listarObrasAnteriores();
            if (!obras.isEmpty()) {
                System.out.println("\nObras disponibles:");
                for (int i = 0; i < obras.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, obras.get(i));
                }
                System.out.print("Seleccione una obra (1-" + obras.size() + "): ");
                int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
                char[][] imagenCargada = logger.cargarObra(seleccion);
                if (imagenCargada != null) {
                    imagen = imagenCargada;
                }
            }
        }

        guardarEstado(imagen);

        while (true) {
            imprimirImagen(imagen);
            System.out.println("Comandos disponibles:");
            System.out.println("- x y [caracter] : Rellenar en posición");
            System.out.println("- deshacer : Ctrl+Z");
            System.out.println("- rehacer : Ctrl+Y");
            System.out.println("- cargar : Cargar obra anterior");
            System.out.println("- salir : Terminar programa");

            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir"))
                break;

            if (entrada.equalsIgnoreCase("deshacer")) {
                if (deshacer(imagen)) {
                    logger.registrarCambio(imagen, "Acción deshecha");
                }
                continue;
            }

            if (entrada.equalsIgnoreCase("rehacer")) {
                if (rehacer(imagen)) {
                    logger.registrarCambio(imagen, "Acción rehecha");
                }
                continue;
            }

            if (entrada.equalsIgnoreCase("cargar")) {
                List<String> obras = logger.listarObrasAnteriores();
                if (!obras.isEmpty()) {
                    System.out.println("\nObras disponibles:");
                    for (int i = 0; i < obras.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, obras.get(i));
                    }
                    System.out.print("Seleccione una obra (1-" + obras.size() + "): ");
                    int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
                    char[][] imagenCargada = logger.cargarObra(seleccion);
                    if (imagenCargada != null) {
                        imagen = imagenCargada;
                        historialDeshacer.clear();
                        historialRehacer.clear();
                        guardarEstado(imagen);
                        logger.registrarCambio(imagen, "Obra cargada");
                    }
                }
                continue;
            }

            try {
                String[] partes = entrada.split(" ");
                int x = Integer.parseInt(partes[0]);
                int y = Integer.parseInt(partes[1]);
                char relleno = partes.length > 2 ? partes[2].charAt(0) : 'x';

                if (x >= 0 && x < anchura && y >= 0 && y < altura) {
                    guardarEstado(imagen);
                    historialRehacer.clear();
                    rellenarRecursivo(imagen, x, y, relleno, '\0');
                    logger.registrarCambio(imagen, String.format("Relleno en (%d,%d) con '%c'", x, y, relleno));
                } else {
                    System.out.println("Coordenadas inválidas. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Formato: x y [caracter]");
            }
        }
        scanner.close();
        logger.close();
    }

    private static void guardarEstado(char[][] imagen) {
        char[][] copia = new char[imagen.length][imagen[0].length];
        for (int i = 0; i < imagen.length; i++) {
            copia[i] = imagen[i].clone();
        }
        historialDeshacer.push(copia);
    }

    private static boolean deshacer(char[][] imagen) {
        if (historialDeshacer.size() <= 1) {
            System.out.println("No hay más acciones para deshacer");
            return false;
        }

        char[][] estadoActual = historialDeshacer.pop();
        historialRehacer.push(estadoActual);
        char[][] estadoAnterior = historialDeshacer.peek();

        for (int i = 0; i < imagen.length; i++) {
            System.arraycopy(estadoAnterior[i], 0, imagen[i], 0, imagen[i].length);
        }
        return true;
    }

    private static boolean rehacer(char[][] imagen) {
        if (historialRehacer.isEmpty()) {
            System.out.println("No hay acciones para rehacer");
            return false;
        }

        char[][] estadoSiguiente = historialRehacer.pop();
        historialDeshacer.push(estadoSiguiente);

        for (int i = 0; i < imagen.length; i++) {
            System.arraycopy(estadoSiguiente[i], 0, imagen[i], 0, imagen[i].length);
        }
        return true;
    }

    private static String[] PLANTILLA_000 = {
            ".....................................",
            ".....................................",
            "..########################...........",
            "..#......................#...#####...",
            "..#..........########....#####...#...",
            "..#..........#......#............#...",
            "..#..........########.........####...",
            "..######......................#......",
            ".......#..#####.....###########......",
            "..######.................#...#####...",
            "..#..........########....#####...#...",
            "..#..........#......#............#...",
            "..#..........########.........####...",
            "..######......................#......",
            ".......#..#####.....###########......",
            ".......####...#######................",
            ".....................................",
            "....................................."
    };

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

    private static String[] PLANTILLA_002 = {
            " ############################################+##################################################### ",
            " ++------------++---+++---++++----+##############################-+++++++++--------++--------++++++ ",
            "                              -###########+-###-----+-++++###########+                              ",
            "                           -#######+-++-+#++###+++++++++#++--+--########-                           ",
            "                         +#####+-+-+##+-+#-++--+#++####-#++-+#+++++-######+                         ",
            "                       +#####+#+-++--#+-+#####+#+++-+##++-+-##--+#++#++#####+                       ",
            "                     +#####+-+#--#-  -+++---####+++++##+#+-+#+  -++--#+ +####+-                     ",
            "                    +#####+  ####+  --##+---###-+++++##+-+-+#+-  -++--#++######-                    ",
            "                  -+##+--##++#+-+----##+++-###+-++++-#####--##--- -+++####+--###+-                  ",
            "                  +##+   -####++ --+##-+--####- ++++-+###+++-###--  #+-##+   -+##+-                 ",
            "                 +##+     +##-+#+-###--+-##+#+- ++++--#####++-###-- +++##-     +##+-                ",
            "                +##+-     +##-+#-### +-+##-+#-  ++++--+####++#++##--++-##-      +##+                ",
            "               +##+---    +##-####+ +-#-#+-#++++#####+-##-###+#++##++++#+        +##+               ",
            "              -##+-+##--  -##-###+---#-######+##############-#+#++##++#+       ---+##-              ",
            "              +##--+++#++--#+##-- ++#-##+++#+####+-+#####+-## #+#--#####-----++++-++#+              ",
            "              ##--+-#+#++-+###+- -++###++##################### #+#++++###----+###+--##+             ",
            "             -##--+-#+#++###+   +#+#+#+++##-############+#+--##-#+#-   +##+++-+##+-+-##-            ",
            "             +#+---+#-#-##+-   -#+#+##- ##--            -## +-##+#+++   +##++++####++##-            ",
            "             ##---####-##+    +#+####---##-             -##+ -##++#+#+   -###-+####--##+            ",
            "             ##-----#+##--   +#+#-###+ +#+-   -+#+-     --##-- ##++#++-   -###+###+- +##            ",
            "            -##- --+-##+--  +#+##+##- -##-    +###+      -+#+ --##++#+++  --#++-#++- -##            ",
            "            +## --#####+-- +#+#++##-- +#+-    ##+##       -##  --## +#++- --+#++#+--  ##            ",
            "            ##+-+#####+-  -++#+-##--  ##-     #####       -##-  -### +#+++  -+##### - ##            ",
            "            ##-###+      +++#+ ##+-  +##      #+###       --##  --##+ +#+++     -###--##            ",
            "           -#####-      -++#+ +##-  -##-      +++--         ##+  +-##  +#++-     -+##+##-           ",
            "           +###+       +++#+ -##--  +#+-      ---           -##   -##+ -+#+++      -####+           ",
            "           ###+       -++#+ -##+-   ##-                     -##-  --##+  +#++-      -+###           ",
            "           ###-------++-#+  ###----+##-----------------------+#+-----##+  +#-++-------###           ",
            " #+        ##########################+++++++++++++++++++++++++###########################           ",
            " -+        +########################+++++++++++++++++++++++++++#########################+           ",
            " #+                                                                                                 ",
            "                                                                                                    ",
            "                                                                                                    "
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
        if (MODO_DEBUG) {
            imprimirImagen(imagen);
            new Scanner(System.in).nextLine();
        }

        rellenarRecursivo(imagen, x + 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x - 1, y, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y + 1, nuevoCaracter, caracterOriginal);
        rellenarRecursivo(imagen, x, y - 1, nuevoCaracter, caracterOriginal);
    }

    public static void rellenarIterativo(char[][] imagen, int x, int y, char nuevoCaracter) {
        char caracterOriginal = imagen[y][x];

        if (caracterOriginal == nuevoCaracter) {
            return;
        }

        Stack<int[]> pila = new Stack<>();
        pila.push(new int[] { x, y });

        while (!pila.isEmpty()) {
            int[] coordenada = pila.pop();
            int actualX = coordenada[0];
            int actualY = coordenada[1];

            if (MODO_DEBUG) {
                imprimirImagen(imagen);
                new Scanner(System.in).nextLine();
            }

            if (actualY < 0
                    || actualY >= imagen.length
                    || actualX < 0
                    || actualX >= imagen[0].length
                    || imagen[actualY][actualX] != caracterOriginal) {
                continue;
            }

            imagen[actualY][actualX] = nuevoCaracter;

            pila.push(new int[] { actualX, actualY + 1 });
            pila.push(new int[] { actualX, actualY - 1 });
            pila.push(new int[] { actualX + 1, actualY });
            pila.push(new int[] { actualX - 1, actualY });
        }
    }

    public static int contarHabitaciones(char[][] imagen) {
        char[][] copia = new char[imagen.length][imagen[0].length];
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                copia[y][x] = imagen[y][x];
            }
        }

        int contador = 0;

        for (int y = 0; y < copia.length; y++) {
            for (int x = 0; x < copia[0].length; x++) {
                if (copia[y][x] == '.') {
                    contador++;
                    rellenarRecursivo(copia, x, y, 'o', '.');
                }
            }
        }

        return contador;
    }

    public static void imprimirImagen(char[][] imagen) {
        cleanScreen();
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                System.out.print(imagen[y][x]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}