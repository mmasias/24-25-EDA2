public class Montaña {
    //Completado
    public static void main(String[] args) {
        imprimirMontaña();
    }
    public void mostrar(){
        imprimirMontaña();
    }

    public static void imprimirMontaña() {
        int[] montaña = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        boolean esMontaña = esMontaña(montaña);
        System.out.println("Es montaña: " + esMontaña);
    }
    
    public static boolean esMontaña(int[] array){
        if (array.length < 3) {
            return false;
        }
        int i = 0;
        while (i< array.length - 1 && array[i] < array[i + 1]) {
            i++;
        }
        if( i == 0 || i == array.length -1 ) {
            return false;
        }
        while (i < array.length - 1 && array[i] > array[i + 1]) {
            i++;
        }
        return i == array.length -1;
    }
}
