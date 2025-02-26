package entregas.Reyes_David.Reto_002.Nivel5;

public class Subconjuntos {

    public static void generarSubconjuntos(int[] conjunto) {
        int n = conjunto.length;
        
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                
                if ((i & (1 << j)) != 0) {
                    System.out.print(conjunto[j] + " ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[] conjunto = { 1, 2, 3 };
        System.out.println("Subconjuntos de [1, 2, 3]:");
        generarSubconjuntos(conjunto);
    }
}