
public class Charmeleon extends Pokemon{

    public Charmeleon(String nombre, int nivel){
        super(nombre, nivel);
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ha usado Llamarada!");
    }

    @Override
    public Pokemon evolucionar() {
        if (nivel >= 36) {
            System.out.println(nombre + " está evolucionando...");
            return new Charizard(nombre, nivel);
        }
        return this;
    }
    

}
