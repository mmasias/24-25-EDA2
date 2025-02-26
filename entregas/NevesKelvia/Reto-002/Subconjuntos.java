public class Subconjuntos {
    
    public static void generarSubconjuntosDeTamañoK(int[] conjunto, int k) {
        int n = conjunto.length; 
        int numSubconjuntos = 1 << n; 
        
        for (int i = 0; i < numSubconjuntos; i++) {
            int contador = 0;  
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    contador++;
                }
            }
            if (contador == k) {
                System.out.print("[");
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        System.out.print(conjunto[j] + " ");
                    }
                }
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        int k = 2;  
        
        generarSubconjuntosDeTamañoK(conjunto, k);
    }
}
