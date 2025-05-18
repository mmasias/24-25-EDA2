package Actas;

class Alumno {
    private String nombre;
    private String apellido;
    private String dni;
    private double examenParcial;
    private double examenFinal;
    private double evaluacionContinua;

    public Alumno(String nombre, String apellido, String dni, 
                  double examenParcial, double examenFinal, double evaluacionContinua) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.examenParcial = examenParcial;
        this.examenFinal = examenFinal;
        this.evaluacionContinua = evaluacionContinua;
    }

    public String getNombre() { 
        return nombre;
    }
    public void setNombre(String nombre) {
         this.nombre = nombre;
        }

    public String getApellido() {
         return apellido; 
        }
    public void setApellido(String apellido) {
         this.apellido = apellido; 
        }

    public String getDni() {
         return dni; 
        }
    public void setDni(String dni) { 
        this.dni = dni; 
    }

    public double getExamenParcial() { 
        return examenParcial; 
    }
    public void setExamenParcial(double examenParcial) { 
        this.examenParcial = examenParcial; 
    }

    public double getExamenFinal() { 
        return examenFinal; 
    }
    public void setExamenFinal(double examenFinal) {
         this.examenFinal = examenFinal;
         }

    public double getEvaluacionContinua() { 
        return evaluacionContinua; 
    }
    public void setEvaluacionContinua(double evaluacionContinua) { 
        this.evaluacionContinua = evaluacionContinua; 
    }

    public double calcularNotaFinal() {
        return examenParcial * 0.25 + evaluacionContinua * 0.25 + examenFinal * 0.5;
    }
}