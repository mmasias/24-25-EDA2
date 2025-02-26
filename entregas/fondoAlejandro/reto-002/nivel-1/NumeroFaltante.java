class NumeroFaltante {

    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1;
        int sumaTeorica = n * (n + 1) / 2;
        int sumaReal = 0;

        for (int i = 0; i < numeros.length; i++) {
            sumaReal += numeros[i];
        }

        return sumaTeorica - sumaReal;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 7};
        int resultado = encontrarNumeroFaltante(numeros);
        System.out.println("El número faltante es: " + resultado);
    }
}