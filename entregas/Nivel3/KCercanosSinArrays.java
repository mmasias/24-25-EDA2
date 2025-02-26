package Nivel3;

public class KCercanosSinArrays {
    public static void main(String[] args) {

        double target = 3.7;
        int k = 2;

        encontrarKCercanos(1, target, k);
        encontrarKCercanos(2, target, k);
        encontrarKCercanos(3, target, k);
        encontrarKCercanos(4, target, k);
        encontrarKCercanos(5, target, k);
    }

    static int mejor1 = Integer.MAX_VALUE, mejor2 = Integer.MAX_VALUE;
    static double dist1 = Double.MAX_VALUE, dist2 = Double.MAX_VALUE;

    public static void encontrarKCercanos(int numero, double target, int k) {
        double distancia = Math.abs(numero - target);

        if (distancia < dist1) {

            mejor2 = mejor1;
            dist2 = dist1;
            mejor1 = numero;
            dist1 = distancia;
        } else if (distancia < dist2) {
            mejor2 = numero;
            dist2 = distancia;
        }

        if (numero == 5) {
            System.out.println(mejor1 + " " + mejor2);
        }
    }
}
