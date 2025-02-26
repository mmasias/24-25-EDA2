package entregas.lopezMartin.reto002.src;

public class Permutaciones {
    
    public static String[] generarPermutaciones1(String entrada) {
        char[] caracteres = entrada.toCharArray();
        int n = caracteres.length;
        
        int totalPermutaciones = 1;
        for (int i = 2; i <= n; i++) {
            totalPermutaciones *= i;
        }
        
        String[] resultado = new String[totalPermutaciones];
        int indiceResultado = 0;
        
        resultado[indiceResultado++] = new String(caracteres);
        
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = 0;
        }
        
        int i = 0;
        
        while (i < n) {
            if (c[i] < i) {
                if (i % 2 == 0) {
                    char temp = caracteres[0];
                    caracteres[0] = caracteres[i];
                    caracteres[i] = temp;
                } else {
                    char temp = caracteres[c[i]];
                    caracteres[c[i]] = caracteres[i];
                    caracteres[i] = temp;
                }

                resultado[indiceResultado++] = new String(caracteres);

                c[i]++;
                i = 0;
            } else {
                c[i] = 0;
                i++;
            }
        }
        
        return resultado;
    }

    public static String[] generarPermutaciones2(String entrada) {
        char[] caracteres = entrada.toCharArray();
        int n = caracteres.length;
        int totalPermutaciones = factorial(n);
        String[] resultado = new String[totalPermutaciones];
        int indiceResultado = 0;

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = 0;
        }
        resultado[indiceResultado++] = new String(caracteres);

        int i = 0;
        while (i < n) {
            if (c[i] < i) {
                if (i % 2 == 0) {
                    intercambiar(caracteres, 0, i);
                } else {
                    intercambiar(caracteres, c[i], i);
                }

                resultado[indiceResultado++] = new String(caracteres);

                c[i]++;
                i = 0;
            } else {
                c[i] = 0;
                i++;
            }
        }

        return resultado;
    }

    private static void intercambiar(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int factorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    
    
    public static void main(String[] args) {
        String entrada = "abc";
        String[] permutaciones = generarPermutaciones1(entrada);
        
        System.out.println("Permutaciones de '" + entrada + "':");
        for (String perm : permutaciones) {
            System.out.println(perm);
        }
    }
}
