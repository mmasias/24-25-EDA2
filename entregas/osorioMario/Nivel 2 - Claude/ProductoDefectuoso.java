public class ProductoDefectuoso {
    public static int encontrarPrimerDefectuoso(boolean[] productos) {
        return busquedaBinaria(productos, 0, productos.length - 1);
    }
    
    private static int busquedaBinaria(boolean[] productos, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1; // No hay productos defectuosos
        }
        
        if (izquierda == derecha) {
            return productos[izquierda] ? izquierda : -1;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        
        // Si el producto del medio es defectuoso, busca a la izquierda
        if (productos[medio]) {
            // Si es el primero o el anterior no es defectuoso, encontramos el primero
            if (medio == 0 || !productos[medio - 1]) {
                return medio;
            }
            return busquedaBinaria(productos, izquierda, medio - 1);
        } else {
            // Si no es defectuoso, busca a la derecha
            return busquedaBinaria(productos, medio + 1, derecha);
        }
    }
    
    // Versión iterativa para minimizar comparaciones
    public static int encontrarPrimerDefectuosoIterativo(boolean[] productos) {
        int izquierda = 0;
        int derecha = productos.length - 1;
        int resultado = -1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (productos[medio]) {
                resultado = medio;
                derecha = medio - 1; // Seguimos buscando a la izquierda
            } else {
                izquierda = medio + 1;
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        boolean[] productos = {false, false, false, true, true};
        
        int indice1 = encontrarPrimerDefectuoso(productos);
        int indice2 = encontrarPrimerDefectuosoIterativo(productos);
        
        System.out.println("Primer producto defectuoso (recursivo): " + indice1);
        System.out.println("Primer producto defectuoso (iterativo): " + indice2);
    }
}
