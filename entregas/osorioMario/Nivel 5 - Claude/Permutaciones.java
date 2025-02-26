public class Permutaciones {
    public static String[] generarPermutaciones(String str) {
        // Calcular el factorial para conocer el número total de permutaciones
        int n = str.length();
        int total = factorial(n);
        
        // Crear array para almacenar todas las permutaciones
        String[] permutaciones = new String[total];
        
        // Llamar a la función recursiva
        char[] charArray = str.toCharArray();
        generarPermutacionesRecursivo(charArray, 0, permutaciones, new int[]{0});
        
        return permutaciones;
    }
    
    private static void generarPermutacionesRecursivo(char[] charArray, int inicio, String[] permutaciones, int[] index) {
        if (inicio == charArray.length - 1) {
            // Hemos llegado a una permutación completa
            permutaciones[index[0]] = new String(charArray);
            index[0]++;
            return;
        }
        
        // Para cada carácter a partir de la posición actual
        for (int i = inicio; i < charArray.length; i++) {
            // Intercambiar los caracteres
            swap(charArray, inicio, i);
            
            // Generar permutaciones para el resto de caracteres
            generarPermutacionesRecursivo(charArray, inicio + 1, permutaciones, index);
            
            // Restaurar el array (backtracking)
            swap(charArray, inicio, i);
        }
    }
    
    // Método para manejar caracteres duplicados
    public static String[] generarPermutacionesSinDuplicados(String str) {
        // Primero generamos todas las permutaciones
        String[] todasPermutaciones = generarPermutaciones(str);
        
        // Ahora eliminamos duplicados
        // Paso 1: Contar permutaciones únicas
        int uniqueCount = 0;
        boolean[] esDuplicado = new boolean[todasPermutaciones.length];
        
        for (int i = 0; i < todasPermutaciones.length; i++) {
            if (!esDuplicado[i]) {
                uniqueCount++;
                
                // Marcar todas las ocurrencias iguales como duplicados
                for (int j = i + 1; j < todasPermutaciones.length; j++) {
                    if (todasPermutaciones[i].equals(todasPermutaciones[j])) {
                        esDuplicado[j] = true;
                    }
                }
            }
        }
        
        // Paso 2: Crear un nuevo array solo con permutaciones únicas
        String[] permutacionesUnicas = new String[uniqueCount];
        int index = 0;
        
        for (int i = 0; i < todasPermutaciones.length; i++) {
            if (!esDuplicado[i]) {
                permutacionesUnicas[index] = todasPermutaciones[i];
                index++;
            }
        }
        
        return permutacionesUnicas;
    }
    
    // Método optimizado para manejar caracteres duplicados directamente durante la generación
    public static String[] generarPermutacionesSinDuplicadosOptimizado(String str) {
        char[] chars = str.toCharArray();
        
        // Ordenar el array para agrupar caracteres duplicados
        sort(chars);
        
        // Calcular cuántas permutaciones únicas habrá
        int total = contarPermutacionesUnicas(chars);
        
        String[] permutaciones = new String[total];
        generarPermutacionesUnicasRecursivo(chars, 0, permutaciones, new int[]{0});
        
        return permutaciones;
    }
    
    private static void generarPermutacionesUnicasRecursivo(char[] chars, int inicio, String[] permutaciones, int[] index) {
        if (inicio == chars.length - 1) {
            permutaciones[index[0]] = new String(chars);
            index[0]++;
            return;
        }
        
        // Usar un array para rastrear qué caracteres ya se usaron en esta posición
        boolean[] usado = new boolean[128]; // Asumiendo ASCII
        
        for (int i = inicio; i < chars.length; i++) {
            // Si este carácter ya fue usado en esta posición, saltar
            if (usado[chars[i]]) continue;
            
            // Marcar este carácter como usado en esta posición
            usado[chars[i]] = true;
            
            swap(chars, inicio, i);
            generarPermutacionesUnicasRecursivo(chars, inicio + 1, permutaciones, index);
            swap(chars, inicio, i);
        }
    }
    
    // Método simple para ordenar un array de caracteres (BubbleSort)
    private static void sort(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
    }
    
    // Método para contar permutaciones únicas teniendo en cuenta duplicados
    private static int contarPermutacionesUnicas(char[] chars) {
        // Calcular n! / (a! * b! * c! * ...) donde a, b, c son las frecuencias de cada carácter
        int[] frecuencia = new int[128]; // Asumiendo ASCII
        
        for (char c : chars) {
            frecuencia[c]++;
        }
        
        int numerador = factorial(chars.length);
        int denominador = 1;
        
        for (int i = 0; i < frecuencia.length; i++) {
            if (frecuencia[i] > 1) {
                denominador *= factorial(frecuencia[i]);
            }
        }
        
        return numerador / denominador;
    }
    
    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        String entrada = "abc";
        
        // Generar todas las permutaciones
        String[] permutaciones = generarPermutaciones(entrada);
        
        System.out.println("Permutaciones de '" + entrada + "':");
        for (String perm : permutaciones) {
            System.out.println(perm);
        }
        
        // Probar con caracteres duplicados
        String entradaDuplicados = "abb";
        System.out.println("\nPermutaciones únicas de '" + entradaDuplicados + "' (método simple):");
        
        String[] permutacionesSinDuplicados = generarPermutacionesSinDuplicados(entradaDuplicados);
        for (String perm : permutacionesSinDuplicados) {
            System.out.println(perm);
        }
        
        System.out.println("\nPermutaciones únicas de '" + entradaDuplicados + "' (método optimizado):");
        String[] permutacionesOptimizadas = generarPermutacionesSinDuplicadosOptimizado(entradaDuplicados);
        for (String perm : permutacionesOptimizadas) {
            System.out.println(perm);
        }
    }
}
