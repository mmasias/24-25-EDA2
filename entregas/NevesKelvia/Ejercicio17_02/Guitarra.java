package entregas.NevesKelvia.Ejercicio17_02;

class Guitarra extends Instrumento {
    @Override
    public void tocar() {
        System.out.println("🎸 Tocando un solo de guitarra...");
    }

    public void afinar() {
        System.out.println("🎸 Afinando la guitarra...");
    }
}