class PicoMontana {
    public static int encontrarPico(int[] numeros) {
        int izquierda = 0, derecha = numeros.length - 1;
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (numeros[medio] > numeros[medio + 1]) {
                derecha = medio;
            } else {
                izquierda = medio + 1;
            }
        }
        return numeros[izquierda];
    }
    
    public static void main(String[] args) {
        int[] cadena = {1, 3, 5, 7, 6, 4, 2};
        System.out.println("El pico de la montaña es: " + encontrarPico(cadena));
    }
}