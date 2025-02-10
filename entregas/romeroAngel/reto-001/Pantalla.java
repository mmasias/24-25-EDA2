class Pantalla {
    private Nodo cabeza;

    public Pantalla(){
        this.cabeza = null;
    }

    public void asignarSiguienteFrame(){
        if (cabeza != null) {
            cabeza = cabeza.getSiguiente();
        }
    }

    
    
    public void agregarFrame(Frame nuevoFrame){
        Nodo nuevoNodo = new Nodo(nuevoFrame);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.enlazarSiguiente(cabeza);
            cabeza.enlazarAnterior(cabeza);
        } else {
            Nodo ultimo = cabeza.getAnterior();
        
            ultimo.enlazarSiguiente(nuevoNodo);
            nuevoNodo.enlazarAnterior(ultimo);

            cabeza.enlazarAnterior(nuevoNodo);
            nuevoNodo.enlazarSiguiente(cabeza);
        }
    }

    public Frame getFrame(){
        return (cabeza != null) ? cabeza.getFrame() : null;
    }

    public boolean validarNodoRepetido(Frame frame){
        if (cabeza == null) return false;

        Nodo actual = cabeza;
        do {
            if (actual.getFrame() == frame){
            return true;
            }
            actual = actual.getSiguiente();
        } while (actual!=cabeza);

        return false;
    }

    public void mostrarFrame(){
        if (cabeza == null || cabeza.getFrame()== null) {
            System.out.println("No hay un frame para mostrar");
            return;
        }
        cabeza.getFrame().mostrarFrame();
    }

    public void mostrarTodosLosFrames(){
        if (cabeza==null) {
            System.out.println("Lista vacia.");
            return;
        }

        Nodo actual = cabeza;
        do {
            actual.getFrame().mostrarFrame();
            actual = actual.getSiguiente();
        } while (actual!=cabeza);
    }

    public void imprimirPantalla(){
        if (cabeza == null || cabeza.getSiguiente() == null) {
            System.out.println("No hay suficientes Frames para imprimir.");
            return;
        }

        Frame frame1 =  cabeza.getFrame();
        Frame frame2 = cabeza.getSiguiente().getFrame();

        int filas = frame1.getPixeles().length;
        int columnas = frame1.getPixeles()[0].length;

        for(int i = 0;i<filas;i++){
            StringBuilder linea = new StringBuilder();
            for(int j = 0;j<columnas;j++){
                linea.append(frame1.getPixel(i,j).getValor()).append(" ");
            }

            linea.append(" ");

            for(int j = 0;j<columnas;j++){
                linea.append(frame2.getPixel(i,j).getValor()).append(" ");
            }
            
            System.out.println(linea.toString());
        }
    }

}