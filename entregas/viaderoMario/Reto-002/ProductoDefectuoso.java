public class ProductoDefectuoso {
    public static int encontrarDefectuoso(boolean[] productos) {
        int izquierda = 0, derecha = productos.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (productos[medio]) {
                derecha = medio;
            } else {
                izquierda = medio + 1;
            }
        }
        return izquierda;
    }

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        System.out.println("Primer producto defectuoso en índice: " + encontrarDefectuoso(productos));
    }
}