package entregas.lopezMartin.reto002.src;

public class NumeroFaltante {
    
    public static int encontrarNumeroFaltante1(int[] numeros) {
        int n = numeros.length + 1;
        
        int sumaEsperada = (n * (n + 1)) / 2;
        
        int sumaActual = 0;
        for (int numero : numeros) {
            sumaActual += numero;
        }
        
        return sumaEsperada - sumaActual;
    }

    public static int encontrarNumeroFaltante2(int[] numeros) {
        int n = numeros.length + 1;

        for (int i = 1; i < numeros.length; i++) {
            int clave = numeros[i];
            int j = i - 1;

            while (j >= 0 && numeros[j] > clave) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = clave;
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] != i + 1) {
                return i + 1;
            }
        }

        return n;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        
        int faltante = encontrarNumeroFaltante1(numeros);
        
        System.out.println("El número faltante es: " + faltante);
        
    }
}
