/*class Esclavo {
    public void trabajar() {
        System.out.println("Trabajando sin descanso");
    }
}*/

/* abstract class Esclavo {
    public void trabajar() {
        System.out.println("Trabajando sin descanso");
    }

    public abstract void quejarse();
} */

/* class Esclavo {
    public void descansar(int minutos) {
    }

    public void descansar(String lugar) {
    }

    public void descansar(int horas) {
    } // ❌ Error de compilación: Se repite el tipo de parámetro (int)
} */

class Esclavo {
    public void descansar(int minutos) {
        System.out.println("Descansando " + minutos + " minutos");
    }

    public void descansar(String lugar) {
        System.out.println("Descansando en " + lugar);
    }

    public void descansar(int horas, String lugar) {
        System.out.println("Descansando " + horas + " horas en " + lugar);
    } // ✅ Correcto, los parámetros son diferentes
}
