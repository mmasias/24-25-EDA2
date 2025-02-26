class Permutaciones2 {
    public static void generarPermutaciones(String str) {
        char[] chars = str.toCharArray();
        
        int n = chars.length;
        int totalPermutaciones = factorial(n);
        
        String[] resultado = new String[totalPermutaciones];
        
        permutarRecursivo(chars, 0, resultado, new int[1]);
        
        System.out.print("[");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print("\"" + resultado[i] + "\"");
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    private static void permutarRecursivo(char[] chars, int indiceActual, String[] resultado, int[] indiceResultado) {
        if (indiceActual == chars.length - 1) {
            resultado[indiceResultado[0]] = new String(chars);
            indiceResultado[0]++;
            return;
        }
        
        for (int i = indiceActual; i < chars.length; i++) {
            intercambiar(chars, indiceActual, i);
            
            permutarRecursivo(chars, indiceActual + 1, resultado, indiceResultado);
            
            intercambiar(chars, indiceActual, i);
        }
    }
    
    private static void intercambiar(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
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
        generarPermutaciones(entrada);
    }
}