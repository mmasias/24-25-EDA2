class ContadorInversiones {
    public int contarInversiones(int[] numeros) {
        int contador = 0;
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void mostrarInversiones(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    System.out.println("(" + numeros[i] + ", " + numeros[j] + ")");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 1, 3, 5};
        ContadorInversiones contador = new ContadorInversiones();
        int totalInversiones = contador.contarInversiones(numeros);
        System.out.println("Número de inversiones: " + totalInversiones);
        contador.mostrarInversiones(numeros);
    }
}