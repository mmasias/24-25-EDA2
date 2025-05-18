package entregas.NevesKelvia.Ejercicio17_02;

class Violin extends InstrumentoDeCuerda {
    @Override
    public void tocar() {
        System.out.println("🎻 Tocando una melodía clásica con el violín...");
    }

    @Override
    public void rasguear() {
        System.out.println("🎻 Rasgueando suavemente las cuerdas...");
    }
}