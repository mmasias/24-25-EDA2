public class Main {
    public static void main(String[] args) {
        InstrumentoMusical instr1 = new InstrumentoMusical();
        instr1.tocar();

        InstrumentoMusical instr2 = new Guitarra();
        instr2.tocar();

        Guitarra guitarra = new Guitarra();
        guitarra.tocar();
        guitarra.afinar();

        Instrumento electrica = new GuitarraElectrica();
        electrica.tocar();

        if (instr2 instanceof Guitarra) {
            Guitarra guitarraCast = (Guitarra) instr2;
            guitarraCast.afinar();
        }

        

        GuitarraElectrica electrica1 = new GuitarraElectrica();
        GuitarraElectrica electrica2 = new GuitarraElectrica();
        System.out.println(electrica1.equals(electrica2));
    }
}

