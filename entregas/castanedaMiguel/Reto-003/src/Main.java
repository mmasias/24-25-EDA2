public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //String[] s={"(","3","+","5",")","*","2"};
        String[] s={"3","+","5","*","2"};
        Clase c=new Clase();

        String[] salida=c.shuntinYard(s);
        String str = String.join(",", salida);
        System.out.println(str);






    }
}