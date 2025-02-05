class Pixel {
    private char[][] elementos;
    
    public Pixel(int width, int height) {
        elementos = new char[height][width];
    }
    
    public char[][] listaElementos() {
        return elementos;
    }
}