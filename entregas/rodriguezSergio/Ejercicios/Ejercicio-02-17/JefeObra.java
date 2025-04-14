public class JefeDeObra extends Albañil {
    @Override
    public void trabajar() {
        super.trabajar();
        System.out.println("Jefe de Obra: Coordinando al equipo...");
    }

    @Override
    public void realizarTareaEspecial() {
        super.realizarTareaEspecial();
        System.out.println("Jefe de Obra: Revisando el progreso de la obra...");
    }
}