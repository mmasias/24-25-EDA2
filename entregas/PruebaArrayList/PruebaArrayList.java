package entregas.PruebaArrayList;
import java.util.ArrayList;
import java.util.Iterator;

public class PruebaArrayList {
    static ArrayList<String> textos = new ArrayList<>();

    public static void main(String[] args) {
        
        textos.add("Mario");
        textos.add("Alfredo");
        textos.add("Pablo");
        mostrar1();
        System.out.println();
        mostrar2();
        System.out.println();
        mostrar3();
        System.out.println();
        textos.set(textos.indexOf("Alfredo"),"Ana");
        mostrar1();
        System.out.println();
        textos.remove("Pablo");
        mostrar1();
        if(textos.contains("Pablo")){
            System.out.println("Pablo esta");
        }else{
            System.out.println("Pablo no esta");
        }
        System.out.println();
        textos.add("Mario");
        mostrar1();
        System.out.println();
        ArrayList nombre=new ArrayList<>();
        nombre.add("Alfredo");
        nombre.add("Ana");
        textos.removeAll(nombre);
        mostrar1();
        System.out.println();
        textos.addFirst("Pablo");
        mostrar1();
        System.out.println();
        textos.addAll(nombre);
        mostrar1();
        System.out.println();
        if(!textos.contains("Mario")&& !textos.contains("mario")){
            textos.add("Mario");
        }
        mostrar1();
    }

    public static void mostrar1(){
        for (String cadena : textos) {
            System.out.println(cadena);
        }
    }
    public static void mostrar2(){
        for (int i = 0; i < textos.size(); i++) {
            System.out.println(textos.get(i));
        }
    }
    public static void mostrar3(){
        Iterator<String>iterator = textos.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
