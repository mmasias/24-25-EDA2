package nivel2;

public class ProductoDefectuoso {
    public static void main(String[] args) {
        boolean[] productos = { false, false, false, true, true };
        int primerDefectuoso = encontrarPrimerDefectuoso(productos);
        System.out.println("El primer producto defectuoso está en el índice: " + primerDefectuoso);
    }

    public static int encontrarPrimerDefectuoso(boolean[] productos) {
        int inicio = 0;
        int fin = productos.length - 1;

        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (productos[medio]) {
                fin = medio;
            } else {
                inicio = medio + 1;
            }
        }

        return inicio;
    }
}
