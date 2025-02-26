import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int []entrada={3,2,9,8};
        int objetivo=10;

        Ejercicios e=new Ejercicios();

        e.sumaObjetivo(entrada,objetivo);

        char[] entrada2= {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra="dia";

        e.busquedaPalabra(entrada2,palabra);


        int[] entrada3= {1,2,4,5,6};

        e.numeroFaltante(entrada3);


        int[] entrada4= {1, 3, 5, 4, 2};
        System.out.println(e.montana(entrada4));


        int [] entrada6= {1,1,1,1,2,2,3};

        System.out.println(e.elementoMayoritario(entrada6));

        int [] a={7,2,4,8,3,9,1,5,10,6};

        e.casiOrdenado(a,2);


        System.out.println(Arrays.toString(a));


    }


}