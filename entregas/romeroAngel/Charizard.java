
public class Charizard extends Pokemon {

    public Charizard(String nombre, int nivel){
        super(nombre, nivel);
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ha usado Lanzallamas!");
    }

    @Override
    public Pokemon evolucionar() {
        System.out.println(nombre + " ya no puede evolucionar más.");
        return this;
    }
    
}
