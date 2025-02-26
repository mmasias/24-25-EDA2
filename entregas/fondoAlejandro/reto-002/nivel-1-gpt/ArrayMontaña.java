class ArrayMontaña {
    public static boolean esMontaña(int[] montaña) {
        int numero = montaña.length;
        int i = 0;
        
        if (numero < 3) {
            return false;
        }

        while (i + 1 < numero && montaña[i] < montaña[i + 1]) {
            i++;
        }

        if (i == 0 || i == numero - 1) {
            return false;
        }

        while (i + 1 < numero && montaña[i] > montaña[i + 1]) {
            i++;
        }

        return i == numero - 1;
    }

    public static void main(String[] args) {
        int[] montaña = {1, 3, 5, 4, 2};
        boolean resultado = esMontaña(montaña);
        System.out.println("¿Es una Montaña?: " + resultado);
    }
}
