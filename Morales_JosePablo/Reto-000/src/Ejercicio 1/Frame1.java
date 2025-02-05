class Frame1 {
    private char[][] contenido;
    
    public Frame1(int width, int height) {
        contenido = new char[height][width];
    }
    
    public char[][] getContenido() {
        return contenido;
    }
}