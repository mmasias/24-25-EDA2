public class NumeroFaltante {
    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1;
        int sumaEsperada = (n * (n + 1)) / 2;
        int sumaActual = 0;

        for (int num : numeros) {
            sumaActual += num;
        }

        return sumaEsperada - sumaActual;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        System.out.println("Número faltante: " + encontrarNumeroFaltante(numeros));
    }
}
