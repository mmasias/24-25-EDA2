public class Demo {
    public static void main(String[] args) {
        Resolucion resolucion = new Resolucion(8, 3);
        
        resolucion.setPixel(new Coordenada(7, 2), 2);
        resolucion.setPixel(new Coordenada(6, 1), 2);
        resolucion.setPixel(new Coordenada(5, 0), 2);
        resolucion.renderizar();
    }
}