public class PuntoEquilibrio {
    public static int encontrarPuntoEquilibrio(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            int sumaIzquierda = 0;
            for (int j = 0; j < i; j++) {
                sumaIzquierda += numeros[j];
            }
            
            int sumaDerecha = 0;
            for (int j = i + 1; j < numeros.length; j++) {
                sumaDerecha += numeros[j];
            }
            
            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
        }
        
        return -1; 
    }
    
    public static int encontrarPuntoEquilibrioOptimizado(int[] numeros) {
        int sumaTotal = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumaTotal += numeros[i];
        }
        
        int sumaIzquierda = 0;
        for (int i = 0; i < numeros.length; i++) {
            int sumaDerecha = sumaTotal - sumaIzquierda - numeros[i];
            
            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
            
            sumaIzquierda += numeros[i];
        }
        
        return -1; 
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 6};
        
        int indice1 = encontrarPuntoEquilibrio(numeros);
        int indice2 = encontrarPuntoEquilibrioOptimizado(numeros);
        
        System.out.println("Punto de equilibrio (método 1): " + indice1);
        if (indice1 != -1) {
            int sumaIzquierda = 0;
            for (int i = 0; i < indice1; i++) {
                sumaIzquierda += numeros[i];
            }
            System.out.println("Suma izquierda: " + sumaIzquierda);
            
            int sumaDerecha = 0;
            for (int i = indice1 + 1; i < numeros.length; i++) {
                sumaDerecha += numeros[i];
            }
            System.out.println("Suma derecha: " + sumaDerecha);
        }
        
        System.out.println("Punto de equilibrio (método 2): " + indice2);
    }
}