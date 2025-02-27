package entregas.lopezMartin.reto002.src;

public class MedianaEnStream {
    public static void encontrarMediana1(int[] flujo) {
        int n = flujo.length;
        int[] ordenado = new int[n]; 
        int size = 0;  

        for (int i = 0; i < n; i++) {
            insertarOrdenado(ordenado, size, flujo[i]); 
            size++;
            System.out.println(calcularMediana(ordenado, size)); 
        }
    }

    private static void insertarOrdenado(int[] arr, int size, int valor) {
        int i = size - 1;
        while (i >= 0 && arr[i] > valor) {
            arr[i + 1] = arr[i]; 
            i--;
        }
        arr[i + 1] = valor; 
    }

    private static double calcularMediana(int[] arr, int size) {
        if (size % 2 == 1) {
            return arr[size / 2];
        } else {
            return (arr[size / 2 - 1] + arr[size / 2]) / 2.0;
        }
    }

    public static void encontrarMediana2(int[] flujo) {
        int[] menores = new int[flujo.length];
        int[] mayores = new int[flujo.length];
        int sizeMenores = 0, sizeMayores = 0;

        for (int i = 0; i < flujo.length; i++) {
            insertarNumero(menores, mayores, flujo[i], sizeMenores, sizeMayores);
            sizeMenores = getSize(menores);
            sizeMayores = getSize(mayores);
            System.out.println(calcularMediana(menores, mayores, sizeMenores, sizeMayores));
        }
    }

    private static void insertarNumero(int[] menores, int[] mayores, int num, int sizeMenores, int sizeMayores) {
        if (sizeMenores == 0 || num <= menores[sizeMenores - 1]) {
            menores[sizeMenores++] = num;
            ordenar(menores, sizeMenores);
        } else {
            mayores[sizeMayores++] = num;
            ordenar(mayores, sizeMayores);
        }

        if (sizeMenores > sizeMayores + 1) {
            moverElemento(menores, mayores, sizeMenores, sizeMayores);
            sizeMenores--;
            sizeMayores++;
        } else if (sizeMayores > sizeMenores) {
            moverElemento(mayores, menores, sizeMayores, sizeMenores);
            sizeMayores--;
            sizeMenores++;
        }
    }

    private static void moverElemento(int[] source, int[] target, int sizeSource, int sizeTarget) {
        int element = source[sizeSource - 1];
        target[sizeTarget] = element;
        ordenar(target, sizeTarget + 1);
    }

    private static void ordenar(int[] arr, int size) {
        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static double calcularMediana(int[] menores, int[] mayores, int sizeMenores, int sizeMayores) {
        if (sizeMenores > sizeMayores) {
            return menores[sizeMenores - 1];
        } else {
            return (menores[sizeMenores - 1] + mayores[0]) / 2.0;
        }
    }

    private static int getSize(int[] arr) {
        int size = 0;
        while (arr[size] != 0) {
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] flujo = {1, 3, 2, 4, 5};
        encontrarMediana1(flujo);
    }
}
