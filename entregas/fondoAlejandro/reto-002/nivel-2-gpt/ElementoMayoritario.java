class ElementoMayoritario {
    public static int encontrarMayoritario(int[] numeros) {
        int cadena = numeros.length;
        int candidato = numeros[cadena / 2];
        int conteo = 0;
        
        for (int i : numeros) {
            if (i == candidato) {
                conteo++;
            }
        }
        
        return (conteo > cadena / 2) ? candidato : -1;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1, 2, 2, 3};
        System.out.println("El numero mayoritario es: " + encontrarMayoritario(numeros));
    }
}
