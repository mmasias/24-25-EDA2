class Pixel {
    private char valor;

    public Pixel() {
        this.valor = '.';
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