package entregas.lopezMartin.reto002.src;

public class Subconjuntos {
    
    public static int[][] generarSubconjuntos(int[] conjunto) {
        int n = conjunto.length;
        
        int totalSubconjuntos = 1;
        for (int i = 0; i < n; i++) {
            totalSubconjuntos *= 2;
        }
        
        int[][] resultado = new int[totalSubconjuntos][];
        
        resultado[0] = new int[0];
        
        if (n == 0) {
            return resultado;
        }
        
        int contadorResultados = 1;
        
        for (int i = 0; i < n; i++) {
            int elementoActual = conjunto[i];
            int tamanoActual = contadorResultados;
            
            for (int j = 0; j < tamanoActual; j++) {
                int[] subconjuntoExistente = resultado[j];
                int[] nuevoSubconjunto = new int[subconjuntoExistente.length + 1];
                
                for (int k = 0; k < subconjuntoExistente.length; k++) {
                    nuevoSubconjunto[k] = subconjuntoExistente[k];
                }
                
                nuevoSubconjunto[subconjuntoExistente.length] = elementoActual;
                
                resultado[contadorResultados++] = nuevoSubconjunto;
            }
        }
        
        return resultado;
    }
    
    public static void imprimirSubconjuntos(int[][] subconjuntos) {
        System.out.print("[");
        for (int i = 0; i < subconjuntos.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            
            System.out.print("[");
            for (int j = 0; j < subconjuntos[i].length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.print(subconjuntos[i][j]);
            }
            System.out.print("]");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        int[][] subconjuntos = generarSubconjuntos(conjunto);
        
        System.out.println("Conjunto original: [1, 2, 3]");
        System.out.println("Todos los subconjuntos:");
        imprimirSubconjuntos(subconjuntos);
        System.out.println("Total de subconjuntos: " + subconjuntos.length);
    }
}