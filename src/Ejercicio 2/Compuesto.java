class Compuesto {

    private static final char[] coloresBase = { '.', '#', '+', '*' };
    private static final char[][] tablaCombinacion = {
        { '.', '#', '+', '*' },
        { '#', '#', '+', '*' },
        { '+', '+', '+', '*' },
        { '*', '*', '*', '*' }
    };
    
    public static char combinar(char color1, char color2) {
        int index1 = obtenerIndice(color1);
        int index2 = obtenerIndice(color2);
        return tablaCombinacion[index1][index2];
    }
    
    private static int obtenerIndice(char color) {
        for (int i = 0; i < coloresBase.length; i++) {
            if (coloresBase[i] == color) {
                return i;
            }
        }
        return 0;
    }
    
}
