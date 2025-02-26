class MedianaStream {
    private static void calcularMedianaFlujo(int[] numeros) {
        int[] flujoOrdenado = new int[numeros.length];
        int cantidadElementos = 0;
        
        for (int numero : numeros) {
            insertarOrdenado(flujoOrdenado, cantidadElementos, numero);
            cantidadElementos++;
            System.out.println(calcularMediana(flujoOrdenado, cantidadElementos));
        }
    }
    
    private static void insertarOrdenado(int[] arreglo, int cantidad, int numero) {
        int i = cantidad - 1;
        while (i >= 0 && arreglo[i] > numero) {
            arreglo[i + 1] = arreglo[i];
            i--;
        }
        arreglo[i + 1] = numero;
    }
    
    private static double calcularMediana(int[] arreglo, int cantidad) {
        if (cantidad % 2 == 1) {
            return arreglo[cantidad / 2];
        } else {
            return (arreglo[cantidad / 2] + arreglo[(cantidad / 2) - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 3, 2, 4, 5};
        calcularMedianaFlujo(numeros);
    }
}
