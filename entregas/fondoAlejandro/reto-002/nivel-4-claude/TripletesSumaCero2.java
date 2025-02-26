class TripletesSumaCero2 {
    
    private static void encontrarTripletes(int[] arreglo) {
        System.out.println("Tripletes que suman cero:");
        
        boolean encontrado = false;
        
        for (int i = 0; i < arreglo.length - 2; i++) {
            for (int j = i + 1; j < arreglo.length - 1; j++) {
                for (int k = j + 1; k < arreglo.length; k++) {
                    if (arreglo[i] + arreglo[j] + arreglo[k] == 0) {
                        System.out.println("[" + arreglo[i] + "," + arreglo[j] + "," + arreglo[k] + "]");
                        encontrado = true;
                    }
                }
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontraron tripletes que sumen cero.");
        }
    }
    
    public static void main(String[] args) {
        int[] arreglo = {-1, 0, 1, 2, -1, -4};
        
        encontrarTripletes(arreglo);
    }
}