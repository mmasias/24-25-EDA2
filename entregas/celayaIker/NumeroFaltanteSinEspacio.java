package entregas.celayaIker;

public class NumeroFaltanteSinEspacio {
    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1; 
        int xorTotal = 0;
        int xorArray = 0;

        for (int i = 1; i <= n; i++) {
            xorTotal ^= i;
        }

        for (int num : numeros) {
            xorArray ^= num;
        }

        return xorTotal ^ xorArray; 
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6}; 
        int faltante = encontrarNumeroFaltante(numeros);
        
        System.out.println("Número faltante: " + faltante);
    }
}
