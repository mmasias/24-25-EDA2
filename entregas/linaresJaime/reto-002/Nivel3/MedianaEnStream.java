public class MedianaEnStream {

    private int[] menores;
    private int[] mayores;
    private int tamMenores;
    private int tamMayores;

    public MedianaEnStream(int capacidad) {
        menores = new int[capacidad];
        mayores = new int[capacidad];
        tamMenores = 0;
        tamMayores = 0;
    }

    public void agregarNumero(int num) {
        if (tamMenores == 0 || num <= menores[0]) {
            insertarMaxHeap(menores, num, tamMenores++);
        } else {
            insertarMinHeap(mayores, num, tamMayores++);
        }
        balancearHeaps();
    }

    private void balancearHeaps() {
        if (tamMenores - tamMayores > 1) {
            int maxDeMenores = extraerMax(menores, --tamMenores);
            insertarMinHeap(mayores, maxDeMenores, tamMayores++);
        } else if (tamMayores - tamMenores > 1) {
            int minDeMayores = extraerMin(mayores, --tamMayores);
            insertarMaxHeap(menores, minDeMayores, tamMenores++);
        }
    }

    public double obtenerMediana() {
        if (tamMenores == tamMayores) {
            return (menores[0] + mayores[0]) / 2.0;
        }
        return tamMenores > tamMayores ? menores[0] : mayores[0];
    }

    private void insertarMaxHeap(int[] heap, int valor, int indice) {
        heap[indice] = valor;
        while (indice > 0 && heap[indice] > heap[(indice - 1) / 2]) {
            int temp = heap[indice];
            heap[indice] = heap[(indice - 1) / 2];
            heap[(indice - 1) / 2] = temp;
            indice = (indice - 1) / 2;
        }
    }

    private void insertarMinHeap(int[] heap, int valor, int indice) {
        heap[indice] = valor;
        while (indice > 0 && heap[indice] < heap[(indice - 1) / 2]) {
            int temp = heap[indice];
            heap[indice] = heap[(indice - 1) / 2];
            heap[(indice - 1) / 2] = temp;
            indice = (indice - 1) / 2;
        }
    }

    private int extraerMax(int[] heap, int indice) {
        int max = heap[0];
        heap[0] = heap[indice];
        ajustarMaxHeap(heap, 0, indice);
        return max;
    }

    private int extraerMin(int[] heap, int indice) {
        int min = heap[0];
        heap[0] = heap[indice];
        ajustarMinHeap(heap, 0, indice);
        return min;
    }

    private void ajustarMaxHeap(int[] heap, int i, int tam) {
        int mayor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;
        if (izquierda < tam && heap[izquierda] > heap[mayor]) mayor = izquierda;
        if (derecha < tam && heap[derecha] > heap[mayor]) mayor = derecha;
        if (mayor != i) {
            int temp = heap[i];
            heap[i] = heap[mayor];
            heap[mayor] = temp;
            ajustarMaxHeap(heap, mayor, tam);
        }
    }

    private void ajustarMinHeap(int[] heap, int i, int tam) {
        int menor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;
        if (izquierda < tam && heap[izquierda] < heap[menor]) menor = izquierda;
        if (derecha < tam && heap[derecha] < heap[menor]) menor = derecha;
        if (menor != i) {
            int temp = heap[i];
            heap[i] = heap[menor];
            heap[menor] = temp;
            ajustarMinHeap(heap, menor, tam);
        }
    }

    public static void main(String[] args) {
        int[] flujo = {1, 3, 2, 4, 5};
        MedianaEnStream mediana = new MedianaEnStream(flujo.length);
        for (int num : flujo) {
            mediana.agregarNumero(num);
            System.out.print(mediana.obtenerMediana() + " ");
        }
    }
}
