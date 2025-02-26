class ArrayRotado2 {
    
    public static int encontrarPuntoRotacion(int[] numerosRotados) {
        if (numerosRotados.length == 0) {
            return -1;
        }
        
        if (numerosRotados.length == 1 || numerosRotados[0] < numerosRotados[numerosRotados.length - 1]) {
            return 0;
        }
        
        int inicioRango = 0;
        int finRango = numerosRotados.length - 1;
        
        while (inicioRango <= finRango) {
            int puntoMedio = inicioRango + (finRango - inicioRango) / 2;
            
            if (puntoMedio < numerosRotados.length - 1 && 
                numerosRotados[puntoMedio] > numerosRotados[puntoMedio + 1]) {
                return puntoMedio + 1;
            }
            
            if (puntoMedio > 0 && 
                numerosRotados[puntoMedio - 1] > numerosRotados[puntoMedio]) {
                return puntoMedio;
            }
            
            if (numerosRotados[inicioRango] < numerosRotados[puntoMedio]) {
                inicioRango = puntoMedio + 1;
            } else {
                finRango = puntoMedio - 1;
            }
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        int[] arrayRotado = {4, 5, 6, 1, 2, 3};
        int puntoRotacion = encontrarPuntoRotacion(arrayRotado);
        
        System.out.println("El punto de rotación está en el índice: " + puntoRotacion);
        
        if (puntoRotacion != -1 && puntoRotacion != 0) {
            System.out.println("Array original ordenado antes de la rotación:");
            int[] arrayOriginal = new int[arrayRotado.length];
            int indice = 0;
            
            for (int i = puntoRotacion; i < arrayRotado.length; i++) {
                arrayOriginal[indice++] = arrayRotado[i];
            }
            for (int i = 0; i < puntoRotacion; i++) {
                arrayOriginal[indice++] = arrayRotado[i];
            }
            
            System.out.print("[");
            for (int i = 0; i < arrayOriginal.length; i++) {
                System.out.print(arrayOriginal[i]);
                if (i < arrayOriginal.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}