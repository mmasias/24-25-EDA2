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