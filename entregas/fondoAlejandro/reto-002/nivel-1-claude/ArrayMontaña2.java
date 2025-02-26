class ArrayMontaña2 {
    
    public static boolean esMontana(int[] array) {
        if (array.length < 3) {
            return false;
        }
        
        int cima = 0;
        while (cima < array.length - 1 && array[cima] < array[cima + 1]) {
            cima++;
        }
        
        if (cima == 0 || cima == array.length - 1) {
            return false;
        }
        
        for (int i = cima; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 2};
        boolean resultado = esMontana(array);
        System.out.println(resultado);
    }
}