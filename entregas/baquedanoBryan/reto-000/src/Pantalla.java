public class Pantalla {
    
    public Nodo cabeza;
    public Nodo cola;
    private int timer;

    public Pantalla(int timer){
        this.cabeza = null;
        this.cola = null;
        this.timer = timer > 0 ? timer : 1000;
    }

    public void alternanciaImpresion() {
        if (cabeza == null || cola == null) {
            System.out.println("Error: No hay suficientes Frames para alternar.");
            return;
        }
    
        boolean mostrarPrimero = true;
    
        while (true) { 
            if (mostrarPrimero) {
                imprimirFrameIndividual(cabeza.dato);
            } else {
                imprimirFrameIndividual(cola.dato);
            }
    
            mostrarPrimero = !mostrarPrimero; 
    
            try {
                Thread.sleep(timer); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    private void imprimirFrameIndividual(Frame frame) {
        int filas = frame.pixeles.length;
        int columnas = frame.pixeles[0].length;
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Pixel p = frame.pixeles[i][j];
                System.out.print(String.valueOf(p.getNumeral()) + " ");
            }
            System.out.println(); 
        }
    
        System.out.println(); 
    }
    

    public Frame getFrame() {
        return (cabeza != null) ? cabeza.dato : null;
    }

    public void buffer() {
        System.out.println("Frame en cabeza:");
        imprimirFrameIndividual(cabeza.dato);
    
        System.out.println("Frame en cola:");
        imprimirFrameIndividual(cola.dato);
    }

    public void temporizador(int nuevoTimer) {
        if (nuevoTimer > 0) {
            this.timer = nuevoTimer;
            System.out.println("Temporizador actualizado a: " + nuevoTimer + "ms");
        } else {
            System.out.println("Error: El tiempo debe ser mayor que 0.");
        }
    }
    
  
}


