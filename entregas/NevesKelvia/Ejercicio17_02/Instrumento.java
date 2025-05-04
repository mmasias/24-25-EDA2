package entregas.NevesKelvia.Ejercicio17_02;

abstract class Instrumento {
    public abstract void tocar();

   
    @Override
    public boolean equals(Object objecto) {
        return objecto != null && objecto.getClass() == this.getClass();
    }
}
