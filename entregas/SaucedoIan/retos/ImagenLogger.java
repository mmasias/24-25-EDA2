import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ImagenLogger {
  private FileWriter fileWriter;
  private final String logFile;
  private final DateTimeFormatter formatter;
  private static final String SEPARATOR = "=== ";
  private static final String END_SEPARATOR = " ===";

  public ImagenLogger(String nombreArchivo) {
    this.logFile = nombreArchivo;
    this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    try {
      this.fileWriter = new FileWriter(nombreArchivo, true);
    } catch (IOException e) {
      System.err.println("Error al crear el archivo de log: " + e.getMessage());
    }
  }

  public void registrarCambio(char[][] imagen, String accion) {
    try {
      fileWriter.write("\n" + SEPARATOR + LocalDateTime.now().format(formatter) + END_SEPARATOR + "\n");
      fileWriter.write("Acción: " + accion + "\n");
      fileWriter.write("Estado de la imagen:\n");

      for (char[] fila : imagen) {
        fileWriter.write(new String(fila) + "\n");
      }
      fileWriter.write("\n");
      fileWriter.flush();
    } catch (IOException e) {
      System.err.println("Error al escribir en el log: " + e.getMessage());
    }
  }

  public List<String> listarObrasAnteriores() {
    List<String> obras = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
      String linea;
      while ((linea = reader.readLine()) != null) {
        if (linea.startsWith(SEPARATOR)) {
          obras.add(linea.substring(SEPARATOR.length(),
              linea.length() - END_SEPARATOR.length()));
        }
      }
    } catch (IOException e) {
      System.err.println("Error al leer el log: " + e.getMessage());
    }
    return obras;
  }

  public char[][] cargarObra(int indice) {
    char[][] imagen = null;
    try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
      String linea;
      int obraActual = -1;
      boolean leyendoImagen = false;
      List<String> imagenLineas = new ArrayList<>();

      while ((linea = reader.readLine()) != null) {
        if (linea.startsWith(SEPARATOR)) {
          if (leyendoImagen)
            break;
          obraActual++;
          if (obraActual == indice) {
            leyendoImagen = true;
            continue;
          }
        }

        if (leyendoImagen && !linea.trim().isEmpty() &&
            !linea.startsWith("Acción:") && !linea.startsWith("Estado")) {
          imagenLineas.add(linea);
        }
      }

      if (!imagenLineas.isEmpty()) {
        imagen = new char[imagenLineas.size()][imagenLineas.get(0).length()];
        for (int i = 0; i < imagenLineas.size(); i++) {
          imagen[i] = imagenLineas.get(i).toCharArray();
        }
      }
    } catch (IOException e) {
      System.err.println("Error al cargar la obra: " + e.getMessage());
    }
    return imagen;
  }

  public void close() {
    try {
      if (fileWriter != null) {
        fileWriter.close();
      }
    } catch (IOException e) {
      System.err.println("Error al cerrar el archivo de log: " + e.getMessage());
    }
  }
}