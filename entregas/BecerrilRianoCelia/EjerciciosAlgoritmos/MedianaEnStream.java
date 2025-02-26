package EjerciciosAlgoritmos;

public class MedianaEnStream {
    private int[] maxPila;
    private int[] minPila;
    private int maxPilaTamano;
    private int minPilaTamano;

    public MedianaEnStream(int capacidad) {
        maxPila = new int[capacidad];
        minPila = new int[capacidad];
        maxPilaTamano = 0;
        minPilaTamano = 0;
    }

    public void anadirNumber(int num) {
        if (maxPilaTamano == 0 || num <= maxPila[0]) {
            insertarMaxPila(num);
        } else {
            insertarMinPila(num);
        }

        if (maxPilaTamano > minPilaTamano + 1) {
            insertarMinPila(extraerMaxPila());
        } else if (minPilaTamano > maxPilaTamano) {
            insertarMaxPila(extraerMinPila());
        }
    }

    public double encontrarMedian() {
        if (maxPilaTamano == minPilaTamano) {
            return (maxPila[0] + minPila[0]) / 2.0;
        } else {
            return maxPila[0];
        }
    }

    private void insertarMaxPila(int num) {
        maxPila[maxPilaTamano] = num;
        int i = maxPilaTamano;
        while (i > 0 && maxPila[i] > maxPila[(i - 1) / 2]) {
            int temp = maxPila[i];
            maxPila[i] = maxPila[(i - 1) / 2];
            maxPila[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        maxPilaTamano++;
    }

    private int extraerMaxPila() {
        int max = maxPila[0];
        maxPila[0] = maxPila[--maxPilaTamano];
        int i = 0;
        while (i * 2 + 1 < maxPilaTamano) {
            int izquierda = i * 2 + 1;
            int derecha = i * 2 + 2;
            int mayor = izquierda;
            if (derecha < maxPilaTamano && maxPila[derecha] > maxPila[izquierda]) {
                mayor = derecha;
            }
            if (maxPila[i] >= maxPila[mayor]) {
                break;
            }
            int temp = maxPila[i];
            maxPila[i] = maxPila[mayor];
            maxPila[mayor] = temp;
            i = mayor;
        }
        return max;
    }

    private void insertarMinPila(int num) {
        minPila[minPilaTamano] = num;
        int i = minPilaTamano;
        while (i > 0 && minPila[i] < minPila[(i - 1) / 2]) {
            int temp = minPila[i];
            minPila[i] = minPila[(i - 1) / 2];
            minPila[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        minPilaTamano++;
    }

    private int extraerMinPila() {
        int min = minPila[0];
        minPila[0] = minPila[--minPilaTamano];
        int i = 0;
        while (i * 2 + 1 < minPilaTamano) {
            int izquierda = i * 2 + 1;
            int derecha = i * 2 + 2;
            int menor = izquierda;
            if (derecha < minPilaTamano && minPila[derecha] < minPila[izquierda]) {
                menor = derecha;
            }
            if (minPila[i] <= minPila[menor]) {
                break;
            }
            int temp = minPila[i];
            minPila[i] = minPila[menor];
            minPila[menor] = temp;
            i = menor;
        }
        return min;
    }

    public static void main(String[] args) {
        MedianaEnStream medianaEnStream = new MedianaEnStream(100);
        int[] numeros = {1, 3, 2, 4, 5};
        for (int num : numeros) {
            medianaEnStream.anadirNumber(num);
            System.out.println("Mediana actual: " + medianaEnStream.encontrarMedian());
        }
    }
}