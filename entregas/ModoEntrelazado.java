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

    public void actualizarPixel(){}

    public void resetear(){}

    public Pixel buscarPixel(){}

    public Pixel obtenerPixel(){}
}

class Nodo {
    private Frame dato;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo getNodo(){}

}

class Pantalla {
    private Nodo[] datos;
    private Nodo cabeza;

    public void asignarSiguienteFrame(){}

    public Frame getFrame(){}

    public void validarNodoRepetido(){}

    public void mostrarFrame(){}

}