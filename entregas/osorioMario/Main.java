public class Main {
    public static void main(String[] args) {
        Piso piso0 = new Piso(0);
        Piso piso1 = new Piso(1);
        Piso piso2 = new Piso(2);
        Piso piso3 = new Piso(3);

        Ascensor ascensor = new Ascensor(piso0);

        ControladorAscensor controlador = new ControladorAscensor(ascensor);

        controlador.agregarSolicitud(piso0, piso2); 
        controlador.agregarSolicitud(piso2, piso1); 
        controlador.agregarSolicitud(piso3, piso1);  
        controlador.agregarSolicitud(piso0, piso2);
        controlador.agregarSolicitud(piso0, piso3);
        controlador.agregarSolicitud(piso1, piso1);
        controlador.agregarSolicitud(piso3, piso2);



        controlador.atenderSolicitudes();
    }
}
