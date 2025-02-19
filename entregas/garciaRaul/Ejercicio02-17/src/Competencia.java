public class Competencia {
    public static void main(String[] args) {
        Futbolista futbolista = new Futbolista("Lionel", 34, "Delantero");
        Atleta atleta = new Atleta("Usain", 36, "Velocidad");
        Tenista tenista = new Tenista("Roger", 40, "N°1");

        Deportista[] deportistas = {futbolista, atleta, tenista};

        for (Deportista d : deportistas) {
            System.out.println(d);
            d.entrenar();
            d.competir();

            if (d instanceof Profesional) {
                ((Profesional) d).recibirSueldo();
            }
            System.out.println();
        }
    }
}