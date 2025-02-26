public class MedianaStream {
    private int[] numeros;
    private int count;
    
    public MedianaStream(int capacidad) {
        numeros = new int[capacidad];
        count = 0;
    }
    
    public void agregarNumero(int num) {
        int i = count - 1;
        while (i >= 0 && numeros[i] > num) {
            numeros[i + 1] = numeros[i];
            i--;
        }
        numeros[i + 1] = num;
        count++;
    }
    
    public double obtenerMediana() {
        if (count % 2 == 1) {
            return numeros[count / 2];
        } else {
            return (numeros[(count / 2) - 1] + numeros[count / 2]) / 2.0;
        }
    }
    
    public static void main(String[] args) {
        MedianaStream medianaStream = new MedianaStream(10);
        int[] entrada = {1, 3, 2, 4, 5};
        
        for (int num : entrada) {
            medianaStream.agregarNumero(num);
            System.out.println("Mediana actual: " + medianaStream.obtenerMediana());
        }
    }
}
