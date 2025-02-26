public class NumeroFaltante {
    //Completado
    public static void main(String[] args) {
        buscarNumeroFaltante();
    }
    public void mostrar(){
        buscarNumeroFaltante();
    }

    public static void buscarNumeroFaltante() {
        int[] numeros = {1, 2, 3, 5, 6, 7, 9, 10, 12};
        int n = numeros[numeros.length - 1];

        System.out.println("Numéros faltantes:");
        int numeroEsperado = 1;
        for (int i = 0; i < numeros.length; i++) {
           while(numeroEsperado < numeros[i]) {
               System.out.println(numeroEsperado);
               numeroEsperado++;
           }
           numeroEsperado++;
        }
        while (numeroEsperado <= n) {
            System.out.println(numeroEsperado);
            numeroEsperado++;
        }
    }

}
