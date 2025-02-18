public class RifleDePrecision extends Rifle {

    @Override
    public void apuntar() {
        super.apuntar();
        System.out.println("Usando mira telescópica para apuntar con precisión...");
    }
}
