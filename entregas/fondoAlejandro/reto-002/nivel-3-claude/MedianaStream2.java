class MedianaStream2 {
    
    private int[] arrayMin;
    private int[] arrayMax;
    private int tamanoMin;
    private int tamanoMax;
    
    public MedianaStream2() {
        arrayMin = new int[1000];
        arrayMax = new int[1000];
        tamanoMin = 0;
        tamanoMax = 0;
    }
    
    public double agregarNumero(int numero) {
        if (tamanoMax == 0 || numero <= -arrayMax[0]) {
            agregarAlMaxHeap(numero);
        } else {
            agregarAlMinHeap(numero);
        }
        
        balancearHeaps();
        
        return calcularMediana();
    }
    
    private void agregarAlMinHeap(int valor) {
        arrayMin[tamanoMin] = valor;
        int indiceActual = tamanoMin;
        
        while (indiceActual > 0) {
            int indicePadre = (indiceActual - 1) / 2;
            if (arrayMin[indicePadre] <= arrayMin[indiceActual]) {
                break;
            }
            
            int temp = arrayMin[indicePadre];
            arrayMin[indicePadre] = arrayMin[indiceActual];
            arrayMin[indiceActual] = temp;
            
            indiceActual = indicePadre;
        }
        
        tamanoMin++;
    }
    
    private void agregarAlMaxHeap(int valor) {
        arrayMax[tamanoMax] = -valor;
        int indiceActual = tamanoMax;
        
        while (indiceActual > 0) {
            int indicePadre = (indiceActual - 1) / 2;
            if (arrayMax[indicePadre] <= arrayMax[indiceActual]) {
                break;
            }
            
            int temp = arrayMax[indicePadre];
            arrayMax[indicePadre] = arrayMax[indiceActual];
            arrayMax[indiceActual] = temp;
            
            indiceActual = indicePadre;
        }
        
        tamanoMax++;
    }
    
    private void balancearHeaps() {
        if (tamanoMax < tamanoMin) {
            int valorMinimo = extraerMinimo();
            agregarAlMaxHeap(valorMinimo);
        } else if (tamanoMax > tamanoMin + 1) {
            int valorMaximo = extraerMaximo();
            agregarAlMinHeap(valorMaximo);
        }
    }
    
    private int extraerMinimo() {
        int valorMinimo = arrayMin[0];
        
        arrayMin[0] = arrayMin[tamanoMin - 1];
        tamanoMin--;
        
        hundirMinHeap(0);
        
        return valorMinimo;
    }
    
    private int extraerMaximo() {
        int valorMaximo = -arrayMax[0];
        
        arrayMax[0] = arrayMax[tamanoMax - 1];
        tamanoMax--;
        
        hundirMaxHeap(0);
        
        return valorMaximo;
    }
    
    private void hundirMinHeap(int indice) {
        int indiceHijoIzq, indiceHijoDer, indiceMinimo;
        
        while (true) {
            indiceHijoIzq = 2 * indice + 1;
            indiceHijoDer = 2 * indice + 2;
            indiceMinimo = indice;
            
            if (indiceHijoIzq < tamanoMin && arrayMin[indiceHijoIzq] < arrayMin[indiceMinimo]) {
                indiceMinimo = indiceHijoIzq;
            }
            
            if (indiceHijoDer < tamanoMin && arrayMin[indiceHijoDer] < arrayMin[indiceMinimo]) {
                indiceMinimo = indiceHijoDer;
            }
            
            if (indiceMinimo == indice) {
                break;
            }
            
            int temp = arrayMin[indice];
            arrayMin[indice] = arrayMin[indiceMinimo];
            arrayMin[indiceMinimo] = temp;
            
            indice = indiceMinimo;
        }
    }
    
    private void hundirMaxHeap(int indice) {
        int indiceHijoIzq, indiceHijoDer, indiceMinimo;
        
        while (true) {
            indiceHijoIzq = 2 * indice + 1;
            indiceHijoDer = 2 * indice + 2;
            indiceMinimo = indice;
            
            if (indiceHijoIzq < tamanoMax && arrayMax[indiceHijoIzq] < arrayMax[indiceMinimo]) {
                indiceMinimo = indiceHijoIzq;
            }
            
            if (indiceHijoDer < tamanoMax && arrayMax[indiceHijoDer] < arrayMax[indiceMinimo]) {
                indiceMinimo = indiceHijoDer;
            }
            
            if (indiceMinimo == indice) {
                break;
            }
            
            int temp = arrayMax[indice];
            arrayMax[indice] = arrayMax[indiceMinimo];
            arrayMax[indiceMinimo] = temp;
            
            indice = indiceMinimo;
        }
    }
    
    private double calcularMediana() {
        if (tamanoMax > tamanoMin) {
            return -arrayMax[0];
        } else {
            return (-arrayMax[0] + arrayMin[0]) / 2.0;
        }
    }
    
    public static void main(String[] args) {
        MedianaStream2 mediaStream = new MedianaStream2();
        int[] flujo = {1, 3, 2, 4, 5};
        
        for (int numero : flujo) {
            double mediana = mediaStream.agregarNumero(numero);
            System.out.println("Después de agregar " + numero + ", la mediana es: " + mediana);
        }
    }
}