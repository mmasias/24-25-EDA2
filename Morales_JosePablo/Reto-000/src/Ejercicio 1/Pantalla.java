class Pantalla {
    @SuppressWarnings("unused")
    private String nombre;
    
    public Pantalla(String nombre) {
        this.nombre = nombre;
    }
    
    public Frame1 getFrame1(int width, int height) {
        return new Frame1(width, height);
    }
    
    public Frame2 getFrame2(int width, int height) {
        return new Frame2(width, height);
    }
}