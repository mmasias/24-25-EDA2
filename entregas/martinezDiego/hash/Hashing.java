package entregas.martinezDiego.hash;

import java.util.Scanner;

public class Hashing {

    public static String generarHash(DatosAlumno[] alumnos) {

        StringBuilder datos = new StringBuilder();

        for (DatosAlumno alumno : alumnos) {
            String nombre = alumno.getNombreAlumno();
            String apellido = alumno.getApellidosAlumno();
            String id = String.valueOf(alumno.getIdAlumno());
            double notaFinal = alumno.getNotaFinal();

            char inicialNombre = (nombre != null && !nombre.isEmpty()) ? nombre.charAt(0) : '.';

            char inicialApellido = (apellido != null && !apellido.isEmpty()) ? apellido.charAt(0) : '.';

            char ultimoCharID = id.charAt(id.length() - 1);

            long notaRedondeada = Math.round(notaFinal);

            datos.append(inicialNombre)
                    .append(inicialApellido)
                    .append(ultimoCharID)
                    .append(notaRedondeada);
        }

        StringBuilder codigoHash = new StringBuilder();
        for (int i = 0; i < datos.length(); i++) {
            char caracter = datos.charAt(i);
            char cifradoCesar = (char) (caracter + 3);
            codigoHash.append(cifradoCesar);
        }

        return codigoHash.toString();
    }

    public static void comprobarHash(DatosAlumno[] alumnos){
        Scanner scanner = new Scanner(System.in);

        String hash = generarHash(alumnos);
        System.out.println("Código hash: " + hash);

        System.out.println("Introduce el código a comprobar");
        String hashUsuario = scanner.nextLine();

        if(hash.equals(hashUsuario)){
            System.out.println("El código hash coincide");
        } else {
            System.out.println("El código hash no coincide");
        }

        scanner.close();
    }
}
