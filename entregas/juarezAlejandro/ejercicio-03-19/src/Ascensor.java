//if

public class Ascensor {

    public static void main(String[] args) {
        int nivelActual = 0;
        nivelActual = desplazar(nivelActual, 5);
        nivelActual = desplazar(nivelActual, 3);
        nivelActual = desplazar(nivelActual, 10);
        nivelActual = desplazar(nivelActual, 0);
    }

    public static int desplazar(int nivel, int destino) {
        System.out.println("Nivel actual: " + nivel);
        if (nivel == destino) {
            System.out.println("Has llegado al destino");
            return nivel;
        }
        return desplazar(nivel + (nivel < destino ? 1 : -1), destino);
    }
}

// sin if

/*
 * public static int desplazar(int nivel, int destino) {
 * System.out.println("Nivel actual: " + nivel);
 * System.out.println("Has llegado al destino".repeat(Math.abs(nivel - destino)
 * == 0 ? 1 : 0));
 * return (nivel - destino) * (nivel - destino) == 0
 * ? nivel
 * : desplazar(nivel + ((destino - nivel) / Math.max(1, Math.abs(destino -
 * nivel))), destino);
 * }
 * }
 */
