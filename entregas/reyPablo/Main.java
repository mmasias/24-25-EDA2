
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        ArrayList <Persona> personas=new ArrayList<>();

        Persona p1 =new Persona("Pablo", 20);
        Persona p2 =new Persona("Juan", 19);
        Persona p3 =new Persona("Mario", 20);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        
        Collections.sort(personas);
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).toString());
        }

        Collections.sort(personas, new ComparadorNombres());
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).toString());
        }



        TreeSet<Persona>persona =new TreeSet();
        persona.add(p1);
        persona.add(p2);
        persona.add(p3);
        for (Persona p : persona) {
            
            System.out.println(p.toString());
        }
    }

}