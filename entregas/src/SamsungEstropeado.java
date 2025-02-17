public class SamsungEstropeado extends Samsung{

    @Override
    public void abrirGalaxyStore(){
        super.abrirGalaxyStore();
        System.out.println("La aplicación ha crasheado");
    }
    
}
