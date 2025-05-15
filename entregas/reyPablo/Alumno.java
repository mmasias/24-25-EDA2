public class Alumno{

private String nombre;
private String apellido;
private String dni;
private float nota;
public Alumno(String nombre, String apellido, String dni,float nota) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.nota=nota;

}

public String getNombre() {
    return nombre;
}

public String getApellido() {
    return apellido;
}

public String getDni() {
    return dni;
}

public float getNota() {
    return nota;
}


@Override
public String toString() {
    return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", nota=" + nota + "]";
}

@Override
public int hashCode() {
   return dni.hashCode() + nombre.hashCode() + apellido.hashCode() + String.valueOf(nota).hashCode();
}

} 