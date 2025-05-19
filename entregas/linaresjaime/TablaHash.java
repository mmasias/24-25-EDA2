package entregas.linaresjaime;

public class TablaHash {
    static final int TAMANO_TABLA = 20;
    Alumno[] tabla = new Alumno[TAMANO_TABLA];

    private int funcionHash(String dni) {
        int suma = 0;
        for (char c : dni.toCharArray()) {
            suma += c;
        }
        return suma % TAMANO_TABLA;
    }

    public void insertar(Alumno alumno) {
        int hash = funcionHash(alumno.dni);
        int original = hash;

        while (tabla[hash] != null && !tabla[hash].dni.equals(alumno.dni)) {
            hash = (hash + 1) % TAMANO_TABLA;
            if (hash == original) {
                System.out.println("Tabla llena. No se pudo insertar al alumno.");
                return;
            }
        }
        tabla[hash] = alumno;
    }

    public Alumno buscar(String dni) {
        int hash = funcionHash(dni);
        int original = hash;

        while (tabla[hash] != null) {
            if (tabla[hash].dni.equals(dni)) {
                return tabla[hash];
            }
            hash = (hash + 1) % TAMANO_TABLA;
            if (hash == original) break;
        }
        return null;
    }

    public void mostrarTodos() {
        for (Alumno a : tabla) {
            if (a != null) {
                a.mostrarDatos();
            }
        }
    }
}

