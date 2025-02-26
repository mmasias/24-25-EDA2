public class ElementoUnico {
    //Completado
    public static void main(String[] args) {
        imprimirElementoUnico();
    }
    public void mostrar(){
        imprimirElementoUnico();
    }

    public static void imprimirElementoUnico() {
        int[] array = {1, 2, 1, 4, 2};
        int elementoUnico = encontrarElementoUnico(array);
        System.out.println("Elemento único: " + elementoUnico);
    }

    public static int encontrarElementoUnico(int[] array) {
        int elementoUnico = 0;
        for (int i = 0; i < array.length; i++) {
            elementoUnico ^= array[i];
        }
        return elementoUnico;
    }
}