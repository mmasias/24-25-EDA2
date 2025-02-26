package EjerciciosAlgoritmos;

public class CasiOrdenado {

    public static void ordenarCasiOrdenado(int[] array, int maxDistancia) {
        int longitudArray = array.length;
        int[] arrayOrdenado = new int[longitudArray];
        int[] minPila = new int[maxDistancia + 1];
        int tamanoPilaActual = 0;

        
        for (int indice = 0; indice <= maxDistancia && indice < longitudArray; indice++) {
            insertarEnPila(minPila, tamanoPilaActual++, array[indice]);
        }

        int indiceOrdenado = 0;
        for (int indice = maxDistancia + 1; indice < longitudArray; indice++) {
            arrayOrdenado[indiceOrdenado++] = extraerMinimo(minPila, tamanoPilaActual--);
            insertarEnPila(minPila, tamanoPilaActual++, array[indice]);
        }

        
        while (tamanoPilaActual > 0) {
            arrayOrdenado[indiceOrdenado++] = extraerMinimo(minPila, tamanoPilaActual--);
        }

    
        for (int indice = 0; indice < longitudArray; indice++) {
            array[indice] = arrayOrdenado[indice];
        }
    }

    private static void insertarEnPila(int[] pila, int tamanoPila, int valor) {
        pila[tamanoPila] = valor;
        int indiceActual = tamanoPila;
        while (indiceActual > 0 && pila[indiceActual] < pila[(indiceActual - 1) / 2]) {
            int temp = pila[indiceActual];
            pila[indiceActual] = pila[(indiceActual - 1) / 2];
            pila[(indiceActual - 1) / 2] = temp;
            indiceActual = (indiceActual - 1) / 2;
        }
    }

    private static int extraerMinimo(int[] pila, int tamanoPila) {
        int minimo = pila[0];
        pila[0] = pila[tamanoPila - 1];
        int indiceActual = 0;
        while (indiceActual * 2 + 1 < tamanoPila - 1) {
            int hijoIzquierdo = indiceActual * 2 + 1;
            int hijoDerecho = indiceActual * 2 + 2;
            int hijoMenor = hijoIzquierdo;
            if (hijoDerecho < tamanoPila - 1 && pila[hijoDerecho] < pila[hijoIzquierdo]) {
                hijoMenor = hijoDerecho;
            }
            if (pila[indiceActual] <= pila[hijoMenor]) {
                break;
            }
            int temp = pila[indiceActual];
            pila[indiceActual] = pila[hijoMenor];
            pila[hijoMenor] = temp;
            indiceActual = hijoMenor;
        }
        return minimo;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 4};
        int maxDistancia = 2;
        ordenarCasiOrdenado(array, maxDistancia);
        System.out.print("Array ordenado: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}