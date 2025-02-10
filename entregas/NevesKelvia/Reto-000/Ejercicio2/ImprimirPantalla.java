package entregas.NevesKelvia.Ejercicio2;

class ImprimirPantalla {
    public void imprimirTodo(char[][] frame) {
        for (char[] row : frame) {
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}