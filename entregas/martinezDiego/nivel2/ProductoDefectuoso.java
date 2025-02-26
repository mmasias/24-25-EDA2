package entregas.martinezDiego.nivel2;

public class ProductoDefectuoso {
    public static int encontrarPrimerProductoDefectuoso(boolean[] productos) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};

        System.out.print("Entrada: [");
        for (int i = 0; i < productos.length; i++) {
            System.out.print(productos[i]);
            if (i < productos.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int resultado = encontrarPrimerProductoDefectuoso(productos);
        System.out.println("Salida: " + resultado);
    }
}

