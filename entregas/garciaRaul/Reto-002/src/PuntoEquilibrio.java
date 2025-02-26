public class PuntoEquilibrio {
    public static int encontrarEquilibrioOptimizado(int[] array) {
        int sumaTotal = 0;
        for (int num : array) {
            sumaTotal += num;
        }
        
        int sumaIzquierda = 0;
        
        for (int i = 0; i < array.length; i++) {
            int sumaDerecha = sumaTotal - array[i] - sumaIzquierda;
            
            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
            
            sumaIzquierda += array[i];
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6};

        int resultado = encontrarEquilibrioOptimizado(array);
        System.out.println("Punto de equilibrio: " + resultado);
    }
}