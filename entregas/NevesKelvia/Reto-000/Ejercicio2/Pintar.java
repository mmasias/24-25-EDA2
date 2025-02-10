package entregas.NevesKelvia.Ejercicio2;

class Pintar {
    public char[][] combinar(char[][] frame1, char[][] frame2) {
        char[][] result = new char[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = (frame1[i][j] == frame2[i][j]) ? frame1[i][j] : '*';
            }
        }
        return result;
    }
    
    public void imprimirCombo(char[][] frame) {
        ImprimirPantalla imprimir = new ImprimirPantalla();
        imprimir.imprimirTodo(frame);
    }
}