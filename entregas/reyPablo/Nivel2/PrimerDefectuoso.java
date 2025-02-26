public class PrimerDefectuoso {
    public static int encontrar(boolean[] productos) {
        int inicio = 0, fin = productos.length - 1;
        while (inicio < fin) {
            int mid = inicio + (fin - inicio) / 2;
            if (productos[mid]) {
                fin = mid;
            } else {
                inicio = mid + 1;
            }
        }
        return inicio;
    }
    
    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        System.out.println(encontrar(productos));
    }
}