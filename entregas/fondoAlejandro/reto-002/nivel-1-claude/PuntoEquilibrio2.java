class PuntoEquilibrio2 {
    
    public static int encontrarPuntoEquilibrio(int[] array) {
        if (array.length <= 1) {
            return -1;
        }
        
        int sumaTotal = 0;
        for (int i = 0; i < array.length; i++) {
            sumaTotal += array[i];
        }
        
        int sumaIzquierda = 0;
        for (int i = 0; i < array.length; i++) {
            int sumaDerecha = sumaTotal - sumaIzquierda - array[i];
            
            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
            
            sumaIzquierda += array[i];
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6};
        int resultado = encontrarPuntoEquilibrio(array);
        
        if (resultado != -1) {
            System.out.println(resultado);
            
            int sumaIzquierda = 0;
            for (int i = 0; i < resultado; i++) {
                sumaIzquierda += array[i];
            }
            
            int sumaDerecha = 0;
            for (int i = resultado + 1; i < array.length; i++) {
                sumaDerecha += array[i];
            }
            
            System.out.println("Suma izquierda: " + sumaIzquierda);
            System.out.println("Suma derecha: " + sumaDerecha);
        } else {
            System.out.println("No se encontró punto de equilibrio");
        }
    }
}