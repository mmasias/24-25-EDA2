package entregas.celayaIker;

public class ProductoDefectuoso {
    public static int encontrarPrimerDefectuoso(boolean[] productos) {
        int inicio = 0, fin = productos.length - 1;
        int resultado = -1;

        while (inicio <= fin) {
            int mid = inicio + (fin - inicio) / 2;

            if (productos[mid]) {
                resultado = mid;
                fin = mid - 1;
            } else {
                inicio = mid + 1; 
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        int indice = encontrarPrimerDefectuoso(productos);
        
        System.out.println("Primer producto defectuoso en índice: " + indice);
    }
}
