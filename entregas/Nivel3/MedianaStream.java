package Nivel3;

public class MedianaStream {
    public static void main(String[] args) {
        double mediana = 0;
        int count = 0;
        int[] stream = { 1, 3, 2, 4, 5 };

        for (int num : stream) {
            mediana = calcularMediana(num, count++);
            System.out.println(mediana);
        }
    }

    static int menor1 = Integer.MIN_VALUE, menor2 = Integer.MIN_VALUE;
    static int mayor1 = Integer.MAX_VALUE, mayor2 = Integer.MAX_VALUE;

    public static double calcularMediana(int num, int count) {
        if (num < mayor1) {
            menor2 = menor1;
            menor1 = num;
        } else if (num < mayor2) {
            mayor2 = mayor1;
            mayor1 = num;
        }

        if ((count + 1) % 2 == 1) {
            return menor1;
        } else {
            return (menor1 + mayor1) / 2.0;
        }
    }
}
