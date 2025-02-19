package entregas.NevesKelvia.Ejercicio17_02;

class Saxofon extends Instrumento implements Soplar {
    @Override
    public void tocar() {
        System.out.println("🎷 Suena un solo de saxofón suave...");
    }

    @Override
    public void soplar() {
        System.out.println("🎷 Soplando aire en el saxofón...");
    }
}
