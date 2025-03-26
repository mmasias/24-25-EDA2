import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImagenLogger {
  private FileWriter fileWriter;
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public ImagenLogger(String nombreArchivo) {
    try {
      this.fileWriter = new FileWriter(nombreArchivo, true);
    } catch (IOException e) {
      System.err.println("Error al crear el archivo de log: " + e.getMessage());
    }
  }

  public void registrarCambio(char[][] imagen, String accion) {
    try {
      fileWriter.write("\n=== " + LocalDateTime.now().format(formatter) + " ===\n");
      fileWriter.write("Acción: " + accion + "\n");
      fileWriter.write("Estado de la imagen:\n");

      for (int y = 0; y < imagen.length; y++) {
        for (int x = 0; x < imagen[0].length; x++) {
          fileWriter.write(imagen[y][x]);
        }
        fileWriter.write("\n");
      }
      fileWriter.write("\n");
      fileWriter.flush();
    } catch (IOException e) {
      System.err.println("Error al escribir en el log: " + e.getMessage());
    }
  }

  public void close() {
    try {
      fileWriter.close();
    } catch (IOException e) {
      System.err.println("Error al cerrar el archivo de log: " + e.getMessage());
    }
  }
}