package EjerciciosAlgoritmos;

public class PuntoEquilibrio {

    public static int encontrarPuntoEquilibrio(int[] numeros) {
        int sumaTotal = 0;
        for (int numero : numeros) {
            sumaTotal += numero;
        }

        int sumaIzquierda = 0;
        for (int indice = 0; indice < numeros.length; indice++) {
            sumaTotal -= numeros[indice]; 
            if (sumaIzquierda == sumaTotal) {
                return indice;
            }

            sumaIzquierda += numeros[indice];
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 6};
        int resultado = encontrarPuntoEquilibrio(numeros);
        if (resultado != -1) {
            System.out.println("El punto de equilibrio está en el índice: " + resultado + " (" + numeros[0] + "+" + numeros[1] + "+" + numeros[2] + " = " + numeros[4] + ")");
        } else {
            System.out.println("No se encontró un punto de equilibrio.");
        }
    }
}