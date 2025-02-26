package EjerciciosAlgoritmos;

public class ProductoDefectuoso {

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

    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        int resultado = encontrarPrimerDefectuoso(productos);
        System.out.println("El primer producto defectuoso está en el índice: " + resultado);
    }
}