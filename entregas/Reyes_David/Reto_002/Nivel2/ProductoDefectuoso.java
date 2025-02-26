package entregas.Reyes_David.Reto_002.Nivel2;

public class ProductoDefectuoso {
    public static int encontrarPrimerDefectuoso(boolean[] productos) {
        int izquierda = 0;
        int derecha = productos.length - 1;
        int resultado = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (productos[medio]) {
                resultado = medio;
                derecha = medio - 1; 
            } else {
                izquierda = medio + 1;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        int indice = encontrarPrimerDefectuoso(productos);
        System.out.println("Primer producto defectuoso en el índice: " + indice);
    }
}
