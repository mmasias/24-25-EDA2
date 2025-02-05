import java.util.HashMap;
import java.util.Map;

public class SuperposicionTemporal {
    private Map<String, String> tablaColores;

    public SuperposicionTemporal() {
        this.tablaColores = new HashMap<>();
        inicializarColores();
    }

    private void inicializarColores() {
        agregarColor("Negro");
        agregarColor("Blanco");
        agregarColor("Rojo");
        agregarColor("Azul");
        agregarColor("Amarillo");

        agregarReglaColor("Negro", "Blanco", "Gris");
        agregarReglaColor("Rojo", "Azul", "Morado");
        agregarReglaColor("Rojo", "Amarillo", "Naranja");
        agregarReglaColor("Azul", "Amarillo", "Verde");
        agregarReglaColor("Negro", "Rojo", "Marrón Oscuro");
        agregarReglaColor("Blanco", "Azul", "Celeste");
    }

    public void agregarColor(String color) {
        System.out.println("Color agregado: " + color);
    }

    public void agregarReglaColor(String color1, String color2, String colorCompuesto) {
        tablaColores.put(color1 + "+" + color2, colorCompuesto);
        tablaColores.put(color2 + "+" + color1, colorCompuesto);
    }

    public String obtenerColorResultado(String color1, String color2) {
        if (color1.equals(color2)) return color1;
        return tablaColores.getOrDefault(color1 + "+" + color2, "Sin combinación");
    }

    public String[][] superposicionTemporal(String[][] frame1, String[][] frame2) {
        int filas = frame1.length;
        int columnas = frame1[0].length;
        String[][] resultado = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = obtenerColorResultado(frame1[i][j], frame2[i][j]);
            }
        }
        return resultado;
    }
}
