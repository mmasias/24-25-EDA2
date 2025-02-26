public class NumeroFaltante {
    public static void main(String[] args) {
        int[] entrada = { 1, 2, 4, 5, 6 };
        int n = entrada.length + 1;

        int sumaTotal = n * (n + 1) / 2;
        int sumaArray = 0;

        for (int i = 0; i < entrada.length; i++) {
            sumaArray += entrada[i];
        }

        int numeroFaltante = sumaTotal - sumaArray;
        System.out.println("El número faltante es: " + numeroFaltante);
    }
}
