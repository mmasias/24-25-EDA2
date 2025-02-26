public class Subsecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        if (s.length() == 0) return true; // Una cadena vacía es subsecuencia de cualquier cadena
        
        int indexS = 0;
        int indexT = 0;
        
        while (indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                if (indexS == s.length()) {
                    return true; // Hemos encontrado todos los caracteres de s en t
                }
            }
            indexT++;
        }
        
        return false; // No se encontraron todos los caracteres de s en t
    }
    
    // Reto adicional: verificar múltiples strings
    public static boolean[] sonSubsecuencias(String[] strings, String t) {
        boolean[] resultados = new boolean[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
            resultados[i] = esSubsecuencia(strings[i], t);
        }
        
        return resultados;
    }
    
    // Solución más eficiente para múltiples strings
    public static boolean[] sonSubsecuenciasOptimizado(String[] strings, String t) {
        boolean[] resultados = new boolean[strings.length];
        
        // Preprocesar t para encontrar la próxima ocurrencia de cada carácter
        // Para cada posición en t y cada posible carácter, almacenamos la siguiente posición donde aparece
        int[][] siguienteIndice = new int[t.length() + 1][26]; // Asumimos solo letras minúsculas a-z
        
        // Inicializar con -1 indicando que no hay más ocurrencias
        for (int i = 0; i <= t.length(); i++) {
            for (int j = 0; j < 26; j++) {
                siguienteIndice[i][j] = -1;
            }
        }
        
        // Rellenar desde el final hacia el principio
        for (int i = t.length() - 1; i >= 0; i--) {
            // Copiar valores del siguiente índice
            for (int j = 0; j < 26; j++) {
                siguienteIndice[i][j] = siguienteIndice[i + 1][j];
            }
            // Actualizar el índice del carácter actual
            char c = t.charAt(i);
            siguienteIndice[i][c - 'a'] = i;
        }
        
        // Verificar cada string
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int posicionActual = 0; // Comenzamos al principio de t
            boolean esSubsec = true;
            
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                // Si ya estamos al final de t o no hay más ocurrencias de c
                if (posicionActual == t.length() || siguienteIndice[posicionActual][c - 'a'] == -1) {
                    esSubsec = false;
                    break;
                }
                
                // Avanzar a la siguiente ocurrencia
                posicionActual = siguienteIndice[posicionActual][c - 'a'] + 1;
            }
            
            resultados[i] = esSubsec;
        }
        
        return resultados;
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        
        boolean resultado = esSubsecuencia(s, t);
        System.out.println("¿'" + s + "' es subsecuencia de '" + t + "'? " + resultado);
        
        // Probar con múltiples strings
        String[] strings = {"abc", "axc", "ahbgdc", "z"};
        System.out.println("\nVerificando múltiples strings:");
        
        boolean[] resultados = sonSubsecuencias(strings, t);
        for (int i = 0; i < strings.length; i++) {
            System.out.println("¿'" + strings[i] + "' es subsecuencia? " + resultados[i]);
        }
        
        System.out.println("\nUsando algoritmo optimizado:");
        boolean[] resultadosOpt = sonSubsecuenciasOptimizado(strings, t);
        for (int i = 0; i < strings.length; i++) {
            System.out.println("¿'" + strings[i] + "' es subsecuencia? " + resultadosOpt[i]);
        }
    }
}
