public class ProductoDefectuoso {
    public static int encontrarPrimerDefectuoso(boolean[] productos) {
        int izquierda = 0;
        int derecha = productos.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (productos[medio]) {
                derecha = medio;
            } else {
                izquierda = medio + 1;
            }
        }
        return productos[izquierda] ? izquierda : -1;
    }

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        int indice = encontrarPrimerDefectuoso(productos);
        System.out.println("Primer producto defectuoso en el índice: " + indice);
    }
}