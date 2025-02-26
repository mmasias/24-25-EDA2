public class Montana {
    
        public static boolean esMontana(int[] numeros) {
        if (numeros.length < 3) return false; 
        
        int i = 0;
        int n = numeros.length;
        
        while (i < n - 1 && numeros[i] < numeros[i + 1]) {
            i++;
        }
        
        
        if (i == 0 || i == n - 1) return false;
        
        
        while (i < n - 1 && numeros[i] > numeros[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 3, 5, 4, 2};
        System.out.println("Es montaña: " + esMontana(numeros));
    }
}
