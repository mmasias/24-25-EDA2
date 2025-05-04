package entregas.NevesKelvia.Ejercicio1;

class Alternancia extends Frames {
    Alternancia() {
        super();
    }

    void alternarHorizontal() {
        for (int i = 0; i < frames.length; i++) {
            for (int j = 0, k = frames[i].length - 1; j < k; j++, k--) {
                char temp = frames[i][j];
                frames[i][j] = frames[i][k];
                frames[i][k] = temp;
            }
        }
        System.out.println("Matriz alternada horizontalmente");
    }

    void frame1() {
        super.frame1();
    }

    void frame2() {
        super.frame2();
    }

    void siguiente() {
        char[] temp = frames[0];
        for (int i = 0; i < frames.length - 1; i++) {
            frames[i] = frames[i + 1];
        }
        frames[frames.length - 1] = temp;
        System.out.println("Cambiado al siguiente frame");
    }

    void timer() {
        try {
            Thread.sleep(1000); 
            System.out.println("Timer completado, cambiando frame");
        } catch (InterruptedException e) {
            System.out.println("Error en el temporizador");
        }
    }
}
