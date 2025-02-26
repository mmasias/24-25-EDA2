public class ProductoDefectuoso {
    //Completado
    public static void main(String[] args) {
        imprimirProductoDefectuoso();
    }
    public void mostrar(){
        imprimirProductoDefectuoso();
    }
    public static void imprimirProductoDefectuoso() {
        boolean[] productos = {true, true, true, false, false};
        int productoDefectuoso = encontrarProductoDefectuoso(productos);
        System.out.println("Producto defectuoso: " + productoDefectuoso);
    }
    public static int encontrarProductoDefectuoso(boolean[] productos){
        int inicio = 0;
        int fin = productos.length - 1;
        while (inicio < fin) {
            int medio = (inicio + fin) / 2;
            if (productos[medio]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }
}
