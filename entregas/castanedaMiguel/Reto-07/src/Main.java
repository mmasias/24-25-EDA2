public class Main {
    public static void main(String[] args) {
        Estudiante Miguel=new Estudiante("Miguel");
        Acta actaMiguel= new Acta(8,Miguel);

        Acta actaMiguel2= actaMiguel.withNota(7);


        System.out.println("Nota real en actaMiguel2?: "+actaMiguel2.esOriginal());
        System.out.println("Nota real en actaMiguel?:"+actaMiguel.esOriginal());



        System.out.println("Hello world!");
    }
}