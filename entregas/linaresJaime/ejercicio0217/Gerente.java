
public class Gerente extends Programador {
    @Override
    public void trabajar() {
        super.trabajar();
        System.out.println("Supervisando el equipo de desarrollo");
    }
}