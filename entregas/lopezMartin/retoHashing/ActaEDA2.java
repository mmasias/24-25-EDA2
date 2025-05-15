package entregas.lopezMartin.retoHashing;

public class ActaEDA2 {

    private final Estudiante[] estudiantes;
    private final String codigoActa;

    public ActaEDA2(Estudiante[] estudiantes) {
        
        this.estudiantes = new Estudiante[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) {
            this.estudiantes[i] = estudiantes[i];
        }
        this.codigoActa = generarCodigoActa();
    }

    private String generarCodigoActa() {
        long hash = 7;
        for (Estudiante e : estudiantes) {
            String datos = e.getNombre() + e.getApellidos()
                + e.getNotaExParcial() + e.getNotaExFinal()
                + e.getNotaEvContinua() + e.getNotaProfesor() + e.getNotaFinal();
            for (int i = 0; i < datos.length(); i++) {
                hash = hash * 31 + datos.charAt(i);
            }
        }
        return Long.toHexString(hash);
    }

    public String getCodigoActa(){
        return this.codigoActa;
    }
    
}
