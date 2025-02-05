class Frame2 {
    private char[][] contenido;
    
    public Frame2(int width, int height) {
        contenido = new char[height][width];
    }
    
    public char[][] getContenido() {
        return contenido;
    }
}