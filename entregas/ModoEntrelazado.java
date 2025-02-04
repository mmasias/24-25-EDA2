class Pixel {
    private char numeral;
    private char punto;
    private char mas;

    
    public char getValor(){}
}

class Frame {
    private Pixel[][] pixeles;

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