public class MedianaStreamAlternativa {
    
    private int[] numeros;
    private int tamaño;
    private int capacidad;
    
    public MedianaStreamAlternativa() {
        capacidad = 10;
        numeros = new int[capacidad];
        tamaño = 0;
    }
    
    public void agregarNumero(int num) {
        if (tamaño == capacidad) {
            expandirArray();
        }
        
        int i = tamaño - 1;
        while (i >= 0 && numeros[i] > num) {
            numeros[i + 1] = numeros[i];
            i--;
        }
        
        numeros[i + 1] = num;
        tamaño++;
    }
    
    public double encontrarMediana() {
        if (tamaño == 0) {
            throw new IllegalStateException("No hay números en el stream");
        }
        
        if (tamaño % 2 != 0) {
            return numeros[tamaño / 2];
        } 
        else {
            int indiceIzquierdo = tamaño / 2 - 1;
            int indiceDerecho = tamaño / 2;
            return (numeros[indiceIzquierdo] + numeros[indiceDerecho]) / 2.0;
        }
    }
    
    private void expandirArray() {
        int nuevaCapacidad = capacidad * 2;
        int[] nuevoArray = new int[nuevaCapacidad];
        
        for (int i = 0; i < tamaño; i++) {
            nuevoArray[i] = numeros[i];
        }
        
        numeros = nuevoArray;
        capacidad = nuevaCapacidad;
    }
    
    public void imprimirNumeros() {
        System.out.print("Números ordenados: ");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MedianaStreamAlternativa medianaStream = new MedianaStreamAlternativa();
        int[] flujo = {1, 3, 2, 4, 5};
        
        System.out.println("Medianas en cada paso:");
        for (int num : flujo) {
            medianaStream.agregarNumero(num);
            double mediana = medianaStream.encontrarMediana();
            System.out.println("Después de agregar " + num + ": " + mediana);
            medianaStream.imprimirNumeros();
        }
    }
}