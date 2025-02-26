public class KElementosCercanos {
    public static int[] encontrarKMasCercanos(int[] numeros, int k, double objetivo) {
        if (k <= 0 || k > numeros.length) {
            return new int[0];
        }
        
        int izquierda = 0;
        int derecha = numeros.length - k;
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (comparar(numeros, medio, medio + k, objetivo) > 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = numeros[izquierda + i];
        }
        
        return resultado;
    }
    
    private static int comparar(int[] numeros, int i, int j, double objetivo) {
        double diff1 = Math.abs(numeros[i] - objetivo);
        double diff2 = Math.abs(numeros[j] - objetivo);
        
        if (diff1 < diff2) {
            return -1;
        } else if (diff1 > diff2) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public static int[] encontrarKMasCercanosAlt(int[] numeros, int k, double objetivo) {
        if (k <= 0 || k > numeros.length) {
            return new int[0];
        }
        
        int izquierda = 0;
        int derecha = numeros.length - 1;
        
        while (derecha - izquierda + 1 > k) {
            double diff1 = Math.abs(numeros[izquierda] - objetivo);
            double diff2 = Math.abs(numeros[derecha] - objetivo);
            
            if (diff1 > diff2) {
                izquierda++;
            } else {
                derecha--;
            }
        }
        
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = numeros[izquierda + i];
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int k = 2;
        double objetivo = 3.7;
        
        int[] resultado1 = encontrarKMasCercanos(numeros, k, objetivo);
        System.out.print("Método 1: ");
        for (int i = 0; i < resultado1.length; i++) {
            System.out.print(resultado1[i] + " ");
        }
        System.out.println();
        
        int[] resultado2 = encontrarKMasCercanosAlt(numeros, k, objetivo);
        System.out.print("Método 2: ");
        for (int i = 0; i < resultado2.length; i++) {
            System.out.print(resultado2[i] + " ");
        }
    }
}
