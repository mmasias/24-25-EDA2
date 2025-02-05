package entregas.Reto001_Reyes_David;

class Pixel {
    public void ActualizarPixel() {

    }
}

class Frame {
    public void mostrarPixeles() {

    }

    public void resolucion() {

    }

    public void tamaño() {

    }
}

class Frame1 extends Frame {

}

class Frame2 extends Frame {

}

class DobleBuffer {

}

class Resultado {
    public void resultadosCombinado() {

    }

    public void mostrarResultados() {

    }
}

class Pantalla {
    public void alternarResultados() {

    }
}

public class Main {
    public static void main(String[] args) {
        Pixel pixel = new Pixel();
        Frame1 frame1 = new Frame1();
        Frame2 frame2 = new Frame2();
        DobleBuffer dobleBuffer = new DobleBuffer();
        Resultado resultado = new Resultado();
        Pantalla pantalla = new Pantalla();

        pixel.ActualizarPixel();
        frame1.mostrarPixeles();
        frame2.mostrarPixeles();
        dobleBuffer = new DobleBuffer();
        resultado.resultadosCombinado();
        resultado.mostrarResultados();
        pantalla.alternarResultados();
    }
}