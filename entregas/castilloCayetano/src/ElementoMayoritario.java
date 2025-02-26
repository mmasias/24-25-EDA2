public class ElementoMayoritario {
    //Completado
    public static void main(String[] args) {
        imprimirElementoMayoritario();
    }
    public void mostrar(){
        imprimirElementoMayoritario();
    }

    public static void imprimirElementoMayoritario() {
        int[] array = { 1, 1, 2, 2, 2};
        int elementoMayoritario = encontrarElementoMayoritario(array);
        if (elementoMayoritario == -1) {
            System.out.println("No hay elemento mayoritario");
        } else {
            System.out.println("Elemento mayoritario: " + elementoMayoritario);
        }

    }

    public static int encontrarElementoMayoritario(int[] array){
        int n = array.length;
        int candidato = array[n / 2];

        int primeraPosicion = encontrarPrimeraPosicion(array, candidato);
        int ultimaPosicion = encontrarUltimaPosicion(array, candidato);
        
        if (ultimaPosicion - primeraPosicion + 1 > n / 2) {
            return candidato;
        }else { 
            return -1;
        }


    }

    public static int encontrarPrimeraPosicion(int[] array, int objetivo){
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            int medio = (inicio + fin) / 2;
            if (array[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }

    public static int encontrarUltimaPosicion(int[] array, int objetivo){
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio < fin) {
            int medio = (inicio + fin + 1) / 2;
            if (array[medio] > objetivo) {
                fin = medio - 1;
            } else {
                inicio = medio;
            }
        }
        return inicio;
    }
}
