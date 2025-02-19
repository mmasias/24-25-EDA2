public class ResultadoVisual {

    private char[][] contenido;
    
    public ResultadoVisual(int width, int height) {
        contenido = new char[height][width * 2];
    }
    
    public void combinar(Frame1 f1, Frame2 f2) {
        @SuppressWarnings("unused")
        char[][] c1 = f1.getContenido();
        @SuppressWarnings("unused")
        char[][] c2 = f2.getContenido();
        @SuppressWarnings("unused")
        Pixel p1 = f1.getPosicion();
        @SuppressWarnings("unused")
        Pixel p2 = f2.getPosicion();
    }
    
    public void mostrarResultado() {
        for (char[] row : contenido) {
            System.out.println(new String(row));
        }
    }
    
    public static void main(String[] args) {
        int width = 7, height = 3;
        Pixel p1 = new Pixel(2, 2);
        Pixel p2 = new Pixel(3, 3);
        
        Frame1 f1 = new Frame1(new char[][] {
            { '.', '.', '.', '#', '#', '.', '.' },
            { '+', '+', '.', '.', '.', '.', '.' },
            { '#', '#', '#', '.', '.', '.', '.' }
        }, p1);
        
        Frame2 f2 = new Frame2(new char[][] {
            { '.', '.', '.', '#', '#', '.', '.' },
            { '+', '+', '.', '.', '.', '.', '.' },
            { '#', '#', '#', '.', '.', '.', '.' }
        }, p2);
        
        ResultadoVisual rv = new ResultadoVisual(width, height);
        rv.combinar(f1, f2);
        rv.mostrarResultado();
    }
    
}