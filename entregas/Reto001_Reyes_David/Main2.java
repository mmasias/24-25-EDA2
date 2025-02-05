package entregas.Reto001_Reyes_David;

class Colores {
    public void colorBase() {}
}

class Pixel {
    private Colores colores;

    public Pixel(Colores colores) {
        this.colores = colores;
    }

    public void ActualizarPixel() {
        colores.colorBase();
    }
}

class Frame {
    public void mostrarPixeles() {}
    public void resolucion() {}
    public void tamaño() {}
}

class Frame1 extends Frame {
    private Pixel pixel;

    public Frame1(Pixel pixel) {
        this.pixel = pixel;
    }

    public void solicitarDatos() {
        pixel.ActualizarPixel();
    }
}

class Frame2 extends Frame {
    private Pixel pixel;

    public Frame2(Pixel pixel) {
        this.pixel = pixel;
    }

    public void solicitarDatos() {
        pixel.ActualizarPixel();
    }
}

class DobleBuffer {}

class Resultado {
    public void resultadosCombinado() {}
    public void mostrarResultados() {}
}

class Pantalla {
    private Resultado resultado;

    public Pantalla(Resultado resultado) {
        this.resultado = resultado;
    }

    public void alternarResultados() {
        resultado.mostrarResultados();
    }
}

public class Main2 {
    public static void main(String[] args) {
        Colores colores = new Colores();
        Pixel pixel = new Pixel(colores);
        Frame1 frame1 = new Frame1(pixel);
        Frame2 frame2 = new Frame2(pixel);
        DobleBuffer dobleBuffer = new DobleBuffer();
        Resultado resultado = new Resultado();
        Pantalla pantalla = new Pantalla(resultado);

        colores.colorBase();
        pixel.ActualizarPixel();
        frame1.solicitarDatos();
        frame2.solicitarDatos();
        resultado.resultadosCombinado();
        pantalla.alternarResultados();
    }
}