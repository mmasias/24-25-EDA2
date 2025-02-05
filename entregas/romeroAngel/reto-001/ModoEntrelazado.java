class Pixel {
    private char valor;

    public Pixel() {
        this.valor = ' ';
    }

    public Pixel(char valor){
        this.valor = valor;
    }

    
    public char getValor(){
        return valor;
    }

    public void setValor(char nuevoValor){
        this.valor = nuevoValor;
    }
}

class Frame {
    private Pixel[][] pixeles;

    public Frame(int filas, int columnas){
        this.pixeles = new Pixel[filas][columnas];

        for(int i = 0;i<filas;i++){
            for (int j = 0;j<columnas;j++){
                pixeles[i][j] = new Pixel();
            }
        }
    }

    public void actualizarPixel(int fila, int columna, char nuevoValor){
        if (estaEnRango(fila, columna)) {
            pixeles[fila][columna].setValor(nuevoValor);
        } else {
            System.out.println("Error: dimensiones fuera de rango.");
        }

    }

    private boolean estaEnRango(int fila, int columna){
        return fila >= 0 && fila < pixeles.length && columna >= 0 && columna < pixeles[0].length;
    }


    public void resetear(){
        for(int i = 0;i<pixeles.length;i++){
            for(int j = 0;j<pixeles[i].length;j++){
                pixeles[i][j].setValor(' ');
            }
        }
    }

    public Pixel buscarPixel(char valor){
        for(int i = 0;i<pixeles.length;i++){
            for(int j = 0;j<pixeles[i].length;j++){
                if(pixeles[i][j].getValor() == valor){
                    return pixeles[i][j];
                }
            }
        }
        return null;
    }

    public Pixel obtenerPixel(int fila, int columna){
        if(estaEnRango(fila, columna)){
            return pixeles[fila][columna];
        }
        return null;
    }

    public void mostrarFrame(){
        for(int i = 0;i<pixeles.length;i++){
            for(int j = 0;j<pixeles[i].length;j++){
                System.out.print(pixeles[i][j].getValor());
            }
            System.out.println();
        }
    }
}

class Nodo {
    private Frame dato;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Frame dato){
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public Nodo getNodo(){
        return this;
    }

    public Nodo getAnterior(){
        return this.anterior;
    }
    
    public Nodo getSiguiente(){
        return this.siguiente;
    }

    public Frame getFrame(){
        return this.dato;
    }
}

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

    

    public Frame getFrame(){}

    public void validarNodoRepetido(){}

    public void mostrarFrame(){}

}