public class TripletesSumaCero {
    public static int[][] encontrarTripletesSumaCero(int[] numeros) {
        // Primero contamos cuántos tripletes suman cero
        int count = 0;
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (numeros[i] + numeros[j] + numeros[k] == 0) {
                        count++;
                    }
                }
            }
        }
        
        // Crear array para almacenar todos los tripletes
        int[][] tripletes = new int[count][3];
        int index = 0;
        
        // Llenar el array con los tripletes encontrados
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (numeros[i] + numeros[j] + numeros[k] == 0) {
                        tripletes[index][0] = numeros[i];
                        tripletes[index][1] = numeros[j];
                        tripletes[index][2] = numeros[k];
                        index++;
                    }
                }
            }
        }
        
        return tripletes;
    }
    
    // Función para evitar duplicados en el resultado
    public static int[][] eliminarDuplicados(int[][] tripletes) {
        // Esta implementación simplificada considera un triplete como 
        // duplicado solo si tiene exactamente los mismos valores en el mismo orden
        // Para una implementación más robusta, habría que ordenar cada triplete
        if (tripletes.length <= 1) return tripletes;
        
        boolean[] duplicados = new boolean[tripletes.length];
        int uniqueCount = tripletes.length;
        
        for (int i = 0; i < tripletes.length - 1; i++) {
            if (duplicados[i]) continue;
            
            for (int j = i + 1; j < tripletes.length; j++) {
                if (duplicados[j]) continue;
                
                if (sonIguales(tripletes[i], tripletes[j])) {
                    duplicados[j] = true;
                    uniqueCount--;
                }
            }
        }
        
        int[][] resultado = new int[uniqueCount][3];
        int index = 0;
        
        for (int i = 0; i < tripletes.length; i++) {
            if (!duplicados[i]) {
                resultado[index][0] = tripletes[i][0];
                resultado[index][1] = tripletes[i][1];
                resultado[index][2] = tripletes[i][2];
                index++;
            }
        }
        
        return resultado;
    }
    
    private static boolean sonIguales(int[] a, int[] b) {
        // Verificar si dos tripletes tienen los mismos elementos sin importar el orden
        // Esta implementación básica sirve para este problema específico
        return (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) || 
               (a[0] == b[0] && a[1] == b[2] && a[2] == b[1]) ||
               (a[0] == b[1] && a[1] == b[0] && a[2] == b[2]) ||
               (a[0] == b[1] && a[1] == b[2] && a[2] == b[0]) ||
               (a[0] == b[2] && a[1] == b[0] && a[2] == b[1]) ||
               (a[0] == b[2] && a[1] == b[1] && a[2] == b[0]);
    }
    
    public static void main(String[] args) {
        int[] entrada = {-1, 0, 1, 2, -1, -4};
        
        int[][] tripletes = encontrarTripletesSumaCero(entrada);
        
        // Como el arreglo puede tener duplicados, filtramos los tripletes duplicados
        int[][] tripletesUnicos = eliminarDuplicados(tripletes);
        
        System.out.println("Tripletes que suman cero:");
        for (int i = 0; i < tripletesUnicos.length; i++) {
            System.out.println("[" + tripletesUnicos[i][0] + ", " + 
                              tripletesUnicos[i][1] + ", " + 
                              tripletesUnicos[i][2] + "]");
        }
    }
}
