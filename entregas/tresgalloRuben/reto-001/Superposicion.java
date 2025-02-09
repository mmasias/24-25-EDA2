public class Superposicion {
    private char[][] tablaColores;

    public Superposicion() {
        char[] colores = { 'N', 'B', 'C', 'M' }; // Negro, Blanco, Cian, Magenta
        tablaColores = new char[colores.length][colores.length];

        for (int i = 0; i < colores.length; i++) {
            for (int j = 0; j < colores.length; j++) {
                if (i == j) {
                    tablaColores[i][j] = colores[i]; // Mismo color
                } else {
                    tablaColores[i][j] = 'G'; // 'G' representa un color mezclado
                }
            }
        }
    }

    public char combinarColores(char color1, char color2) {
        int index1 = obtenerIndice(color1);
        int index2 = obtenerIndice(color2);
        if (index1 == -1 || index2 == -1) return ' ';
        return tablaColores[index1][index2];
    }

    private int obtenerIndice(char color) {
        switch (color) {
            case 'N': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'M': return 3;
            default: return -1;
        }
    }
}
