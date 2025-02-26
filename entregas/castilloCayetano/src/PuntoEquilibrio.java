public class PuntoEquilibrio{
//Completado
    public static void main(String[] args) {
        imprimirPuntoEquilibrio();
    }
    public void mostrar(){
        imprimirPuntoEquilibrio();
    }   

    public static void imprimirPuntoEquilibrio(){
        int[] array = {1, 2, 3, 4, 6, 8};
        int indiceEquilibrio = encontrarPuntoEquilibrio(array);
        if (encontrarPuntoEquilibrio(array) == -1){
            System.out.println("No hay punto de equilibrio");
        }else{
            System.out.println("Índice de equilibrio: " + indiceEquilibrio);
        }
            
    }
    public static int encontrarPuntoEquilibrio(int[] array){
        int totalSuma = 0;
        for (int num: array){
            totalSuma += num;
        }
        
        int sumaIzquierda = 0;
        for (int i = 0; i < array.length; i++){
            totalSuma -= array[i];
            if (sumaIzquierda == totalSuma){
                return i;
            }
            sumaIzquierda += array[i];
        }
        return -1;
    }
}
