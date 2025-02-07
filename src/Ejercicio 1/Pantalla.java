class Pantalla {

    @SuppressWarnings("unused")
    private String nombre;
    
    public Pantalla(String nombre) {
        this.nombre = nombre;
    }
    
    public Frame1 getFrame1(char[][] contenido, Pixel posicion) {
        return new Frame1(contenido, posicion);
    }
    
    public Frame2 getFrame2(char[][] contenido, Pixel posicion) {
        return new Frame2(contenido, posicion);
    }
    
}