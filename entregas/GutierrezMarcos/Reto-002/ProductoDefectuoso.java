public class ProductoDefectuoso {
    public static int encontrarPrimerDefectuosoLineal(boolean[] productos) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int encontrarPrimerDefectuosoBinario(boolean[] productos) {
        int izquierda = 0;
        int derecha = productos.length - 1;

        if (productos[izquierda]) {
            return izquierda;
        }

        if (!productos[derecha]) {
            return -1;
        }

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
        boolean[] productos = { false, false, false, true, true };

        int resultadoLineal = encontrarPrimerDefectuosoLineal(productos);
        System.out.println("Primer producto defectuoso (lineal): " + resultadoLineal);

        int resultadoBinario = encontrarPrimerDefectuosoBinario(productos);
        System.out.println("Primer producto defectuoso (binario): " + resultadoBinario);
    }
}