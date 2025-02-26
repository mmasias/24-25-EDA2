public class ArrayRotado {
    
    public static int encontrarPuntoRotacion(int[] numeros) {
        int izquierda = 0, derecha = numeros.length - 1;
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (numeros[medio] > numeros[derecha]) {
                izquierda = medio + 1; 
            } else {
                derecha = medio; 
            }
        }
        
        return izquierda; 
    }
    
    public static void main(String[] args) {
        int[] numeros = {4, 5, 6, 1, 2, 3};
        System.out.println("Punto de rotación: " + encontrarPuntoRotacion(numeros));
    }
}
