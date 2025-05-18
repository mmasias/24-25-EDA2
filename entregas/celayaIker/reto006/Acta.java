package entregas.celayaIker.reto006;

import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Acta {
    private List<Alumno> alumnos;
    private String hashActa;

    public Acta() {
        alumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void cerrarActa() {
        String datos = generarContenidoActa();
        hashActa = generarHash(datos);
        System.out.println("Acta cerrada. Hash generado:");
        System.out.println(hashActa);
    }

    public void verificarIntegridad() {
        String datos = generarContenidoActa();
        String nuevoHash = generarHash(datos);
        System.out.println("Verificando integridad...");

        if (hashActa.equals(nuevoHash)) {
            System.out.println("El acta NO ha sido modificada.");
        } else {
            System.out.println("El acta HA SIDO ALTERADA.");
            System.out.println("Hash original: " + hashActa);
            System.out.println("Hash actual:   " + nuevoHash);
        }
    }

    private String generarContenidoActa() {
        StringBuilder sb = new StringBuilder();
        for (Alumno a : alumnos) {
            sb.append(a.getDatosActa()).append("\n");
        }
        return sb.toString();
    }

    private String generarHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hashBytes) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash", e);
        }
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
}
