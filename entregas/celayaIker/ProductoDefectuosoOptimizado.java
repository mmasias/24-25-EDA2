package entregas.celayaIker;

public class ProductoDefectuosoOptimizado {
    public static int encontrarPrimerDefectuoso(boolean[] productos) {
        int inicio = 0, fin = productos.length - 1;

        while (inicio < fin) {
            int mid = inicio + (fin - inicio) / 2;

            if (productos[mid]) {
                fin = mid; 
            } else {
                inicio = mid + 1; 
            }
        }
        return productos[inicio] ? inicio : -1; 
    }

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        int indice = encontrarPrimerDefectuoso(productos);
        
        System.out.println("Primer producto defectuoso en índice: " + indice);
    }
}
