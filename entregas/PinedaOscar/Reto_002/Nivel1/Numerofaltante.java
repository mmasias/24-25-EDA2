package entregas.PinedaOscar.Reto_002.Nivel1;

public class Numerofaltante {
    public static int encontrarFaltante(int[] numeros) {
        int n = numeros.length + 1;
        int sumaTotal = n * (n + 1) / 2;
        int sumaArray = 0;
        for (int num : numeros) {
            sumaArray += num;
        }
        return sumaTotal - sumaArray;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6, };
        int faltante = encontrarFaltante(numeros);
        System.out.println("Número faltante: " + faltante);
    }
    
}
