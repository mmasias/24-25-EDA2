package Actas;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;

class Acta {
    private final String codigoVerificacion;
    private final String asignatura;
    private final String curso;
    private final String convocatoria;
    private final List<DatosAlumno> datosAlumnos;
    private final Profesor profesor;
    private final String hash;

    public static class DatosAlumno {
        private final String dni;
        private final String nombre;
        private final String apellido;
        private final double notaFinal;
        private final double examenParcial;
        private final double examenFinal;
        private final double evaluacionContinua;

        public DatosAlumno(Alumno persona) {
            this.dni = persona.getDni();
            this.nombre = persona.getNombre();
            this.apellido = persona.getApellido();
            this.examenParcial = persona.getExamenParcial();
            this.examenFinal = persona.getExamenFinal();
            this.evaluacionContinua = persona.getEvaluacionContinua();
            this.notaFinal = persona.calcularNotaFinal();
        }

        @Override
        public String toString() {
            return "DatosAlumno{" +
                    "dni='" + dni + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", notaFinal=" + notaFinal +
                    '}';
        }
        
        public String getDni() {
            return dni;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public String getApellido() {
            return apellido;
        }
        
        public double getNotaFinal() {
            return notaFinal;
        }
        
        public double getExamenParcial() {
            return examenParcial;
        }
        
        public double getExamenFinal() {
            return examenFinal;
        }
        
        public double getEvaluacionContinua() {
            return evaluacionContinua;
        }
        
       
        public String getDataForHash() {
            return dni + nombre + apellido + examenParcial + examenFinal + 
                   evaluacionContinua + notaFinal;
        }
    }

    public Acta(String asignatura, String curso, String convocatoria, 
                List<Alumno> alumnos, Profesor profesor) {
        this.asignatura = asignatura;
        this.curso = curso;
        this.convocatoria = convocatoria;
        this.codigoVerificacion = generarCodigoVerificacion(asignatura, curso, convocatoria);
        this.profesor = profesor;
        
       
        this.datosAlumnos = new ArrayList<>();
        if (alumnos != null) {
            for (Alumno alumno : alumnos) {
                if (alumno != null) {
                    this.datosAlumnos.add(new DatosAlumno(alumno));
                }
            }
        }
        

        this.hash = generarHash();
    }
    
    private String generarCodigoVerificacion(String asignatura, String curso, String convocatoria) {
        
        String asignaturaStr = asignatura != null ? asignatura.toUpperCase() : "UNKNOWN";
        String cursoStr = curso != null ? curso : "UNKNOWN";
        String convocatoriaStr = convocatoria != null ? convocatoria : "UNKNOWN";
        
        return asignaturaStr + "-" + cursoStr + "-" + convocatoriaStr;
    }
    
    private String generarHash() {
        try {
            StringBuilder data = new StringBuilder();
            

            data.append(codigoVerificacion).append(asignatura).append(curso).append(convocatoria);
            

            for (DatosAlumno alumno : datosAlumnos) {
                data.append(alumno.getDataForHash());
            }
            

            if (profesor != null) {
                data.append(profesor.getNombre()).append(profesor.getApellido()).append(profesor.getDepartamento());
            }
            

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.toString().getBytes());
            

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (Exception e) {
        
            return "ERROR_HASH_GENERATION";
        }
    }
    
    public boolean verificarIntegridad() {
      
        String hashActual = generarHash();
        return hashActual.equals(this.hash) && !hashActual.equals("ERROR_HASH_GENERATION");
    }
    
    public double calcularPromedio() {
        if (datosAlumnos.isEmpty()) {
            return 0;
        }
        
        double sumaNotas = 0;
        for (DatosAlumno alumno : datosAlumnos) {
            sumaNotas += alumno.getNotaFinal();
        }
        
        return sumaNotas / datosAlumnos.size();
    }
    
   
    public double obtenerNotaAlumno(String dni) {
        if (dni == null) {
            return -1;
        }
        
        for (DatosAlumno alumno : datosAlumnos) {
            if (dni.equals(alumno.getDni())) {
                return alumno.getNotaFinal();
            }
        }
        
       
        return -1;
    }
    
    
    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }
    
    public String getAsignatura() {
        return asignatura;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public String getConvocatoria() {
        return convocatoria;
    }
    
    public List<DatosAlumno> getDatosAlumnos() {
        
        return new ArrayList<>(datosAlumnos);
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    public String getHash() {
        return hash;
    }
}
