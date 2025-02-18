public class Charmander extends Pokemon {
    public Charmander (String nombre, int nivel){
        super(nombre, nivel);
    }

    @Override
    public void atacar(){
        System.out.println(nombre + " ha usado Ascuas!");
    }

    @Override
    public Pokemon evolucionar() {
        if(nivel>=16) {
            System.out.println(nombre + " está evolucionando...");
            return new Charmeleon(nombre, nivel);
        }
        return this;
    }

}
