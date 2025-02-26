class ElementoUnico2 {
    
    public static int encontrarElementoUnico(int[] numeros) {
        if (numeros.length == 0) {
            return -1;
        }
        
        if (numeros.length == 1) {
            return numeros[0];
        }

        int resultado = 0;
        
        for (int numero : numeros) {
            resultado ^= numero;
        }
        
        return resultado;
    }
    
    public static int encontrarElementoUnicoConConteo(int[] numeros) {
        int maxValor = encontrarMaximo(numeros);
        int[] contadorOcurrencias = new int[maxValor + 1];
        
        for (int numero : numeros) {
            contadorOcurrencias[numero]++;
        }
        
        for (int i = 0; i < contadorOcurrencias.length; i++) {
            if (contadorOcurrencias[i] == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    private static int encontrarMaximo(int[] array) {
        int maximo = Integer.MIN_VALUE;
        for (int valor : array) {
            if (valor > maximo) {
                maximo = valor;
            }
        }
        return maximo;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 1, 3, 2};
        int elementoUnico = encontrarElementoUnico(numeros);
        
        System.out.println("El elemento único es: " + elementoUnico);
        
        System.out.println("Verificación con método de conteo: " + encontrarElementoUnicoConConteo(numeros));
    }
}