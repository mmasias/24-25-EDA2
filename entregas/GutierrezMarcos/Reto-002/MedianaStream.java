public class MedianaStream {
    
    static class MedianaSimple {
        private int[] numeros;
        private int tamanio;
        
        public MedianaSimple(int capacidad) {
            numeros = new int[capacidad];
            tamanio = 0;
        }
        
        public void agregarNumero(int num) {
            numeros[tamanio++] = num;
            ordenar();
        }
        
        private void ordenar() {
            for (int i = tamanio - 1; i > 0; i--) {
                if (numeros[i] < numeros[i - 1]) {
                    int temp = numeros[i];
                    numeros[i] = numeros[i - 1];
                    numeros[i - 1] = temp;
                } else {
                    break;
                }
            }
        }
        
        public double obtenerMediana() {
            if (tamanio == 0) {
                return 0;
            }
            
            if (tamanio % 2 == 1) {
                return numeros[tamanio / 2];
            } else {
                return (numeros[tamanio / 2 - 1] + numeros[tamanio / 2]) / 2.0;
            }
        }
    }
    
    static class MedianaHeap {
        private int[] maxHeap;
        private int[] minHeap;
        private int tamanioMaxHeap;
        private int tamanioMinHeap;
        
        public MedianaHeap(int capacidad) {
            maxHeap = new int[capacidad / 2 + 1];
            minHeap = new int[capacidad / 2 + 1];
            tamanioMaxHeap = 0;
            tamanioMinHeap = 0;
        }
        
        public void agregarNumero(int num) {
            if (tamanioMaxHeap == 0 || num <= maxHeap[0]) {
                insertarMaxHeap(num);
            } else {
                insertarMinHeap(num);
            }
            
            balancearHeaps();
        }
        
        private void balancearHeaps() {
            if (tamanioMaxHeap > tamanioMinHeap + 1) {
                insertarMinHeap(extraerMaxHeap());
            } else if (tamanioMaxHeap < tamanioMinHeap) {
                insertarMaxHeap(extraerMinHeap());
            }
        }
        
        private void insertarMaxHeap(int num) {
            maxHeap[tamanioMaxHeap++] = num;
            int i = tamanioMaxHeap - 1;
            
            while (i > 0) {
                int padre = (i - 1) / 2;
                if (maxHeap[i] <= maxHeap[padre]) {
                    break;
                }
                
                int temp = maxHeap[i];
                maxHeap[i] = maxHeap[padre];
                maxHeap[padre] = temp;
                
                i = padre;
            }
        }
        
        private void insertarMinHeap(int num) {
            minHeap[tamanioMinHeap++] = num;
            int i = tamanioMinHeap - 1;
            
            while (i > 0) {
                int padre = (i - 1) / 2;
                if (minHeap[i] >= minHeap[padre]) {
                    break;
                }
                
                int temp = minHeap[i];
                minHeap[i] = minHeap[padre];
                minHeap[padre] = temp;
                
                i = padre;
            }
        }
        
        private int extraerMaxHeap() {
            int resultado = maxHeap[0];
            maxHeap[0] = maxHeap[--tamanioMaxHeap];
            
            int i = 0;
            while (true) {
                int izquierda = 2 * i + 1;
                int derecha = 2 * i + 2;
                int mayor = i;
                
                if (izquierda < tamanioMaxHeap && maxHeap[izquierda] > maxHeap[mayor]) {
                    mayor = izquierda;
                }
                
                if (derecha < tamanioMaxHeap && maxHeap[derecha] > maxHeap[mayor]) {
                    mayor = derecha;
                }
                
                if (mayor == i) {
                    break;
                }
                
                int temp = maxHeap[i];
                maxHeap[i] = maxHeap[mayor];
                maxHeap[mayor] = temp;
                
                i = mayor;
            }
            
            return resultado;
        }
        
        private int extraerMinHeap() {
            int resultado = minHeap[0];
            minHeap[0] = minHeap[--tamanioMinHeap];
            
            int i = 0;
            while (true) {
                int izquierda = 2 * i + 1;
                int derecha = 2 * i + 2;
                int menor = i;
                
                if (izquierda < tamanioMinHeap && minHeap[izquierda] < minHeap[menor]) {
                    menor = izquierda;
                }
                
                if (derecha < tamanioMinHeap && minHeap[derecha] < minHeap[menor]) {
                    menor = derecha;
                }
                
                if (menor == i) {
                    break;
                }
                
                int temp = minHeap[i];
                minHeap[i] = minHeap[menor];
                minHeap[menor] = temp;
                
                i = menor;
            }
            
            return resultado;
        }
        
        public double obtenerMediana() {
            if (tamanioMaxHeap == 0) {
                return 0;
            }
            
            if (tamanioMaxHeap == tamanioMinHeap) {
                return (maxHeap[0] + minHeap[0]) / 2.0;
            } else {
                return maxHeap[0];
            }
        }
    }
    
    public static void main(String[] args) {
        int[] stream = {1, 3, 2, 4, 5};
        
        MedianaSimple medianaSimple = new MedianaSimple(stream.length);
        System.out.print("Medianas (simple): ");
        for (int num : stream) {
            medianaSimple.agregarNumero(num);
            System.out.print(medianaSimple.obtenerMediana() + " ");
        }
        System.out.println();
        
        MedianaHeap medianaHeap = new MedianaHeap(stream.length);
        System.out.print("Medianas (heap): ");
        for (int num : stream) {
            medianaHeap.agregarNumero(num);
            System.out.print(medianaHeap.obtenerMediana() + " ");
        }
        System.out.println();
    }
}