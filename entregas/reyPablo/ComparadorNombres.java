import java.util.Comparator;

public class ComparadorNombres implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        int resultado;
        
        resultado= o1.getNombre().compareTo(o2.getNombre());

        return resultado;

    }
}

