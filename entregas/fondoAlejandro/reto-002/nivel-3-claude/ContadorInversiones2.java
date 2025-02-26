public class ContadorInversiones2 {
    
    private static int contarInversiones(int[] arreglo) {
        int contador = 0;
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    contador++;
                }
            }
        }
        
        return contador;
    }
    
    private static void mostrarInversiones(int[] arreglo) {
        System.out.print("Inversiones encontradas: ");
        
        boolean primeraInversion = true;
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    if (!primeraInversion) {
                        System.out.print(", ");
                    }
                    System.out.print("(" + arreglo[i] + "," + arreglo[j] + ")");
                    primeraInversion = false;
                }
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arreglo = {2, 4, 1, 3, 5};
        
        int totalInversiones = contarInversiones(arreglo);
        
        System.out.println("Total de inversiones: " + totalInversiones);
        mostrarInversiones(arreglo);
    }
}