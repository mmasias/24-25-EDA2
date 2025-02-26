class ElementoUnico {
    public static int encontrarElementoUnico(int[] numeros) {
        int unico = 0;
        for (int elemento : numeros) {
            unico ^= elemento;
        }
        return unico;
    }
    
    public static void main(String[] args) {
        int[] cadena = {1, 2, 1, 3, 2};
        System.out.println("El elemento unico es: " + encontrarElementoUnico(cadena));
    }
}
