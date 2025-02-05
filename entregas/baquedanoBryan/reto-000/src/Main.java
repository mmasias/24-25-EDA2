public class Main {
    public static void main(String[] args) {
        int size = 5; 

        Frame frame1 = new Frame(size, size);
        Frame frame2 = new Frame(size, size);

        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == size / 2 - i || j == size / 2 + i || i == size - 1) {
                    frame1.pixeles[i][j] = new Pixel('#', '.', '+'); 
                } else {
                    frame2.pixeles[i][j] = new Pixel('.', '+', '#'); 
                }
            }
        }

        
        Nodo nodo1 = new Nodo(frame1, null, null);
        Nodo nodo2 = new Nodo(frame2, null, nodo1);
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;

        Pantalla pantalla = new Pantalla(500);
        pantalla.cabeza = nodo1;
        pantalla.cola = nodo2;

        pantalla.buffer();
        pantalla.alternanciaImpresion();
    }
}
