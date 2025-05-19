public class Main {
    public static void main(String[] args) {

        Alumno[] alumnos = {
            new Alumno("Pedro", "Gonzalez", "72286467L", 6.5),
            new Alumno("Rosa", "Garcia", "72270491Y", 8.5),
            new Alumno("Alvaro", "Martinez", "72573487J", 9),
            new Alumno("Beatriz", "Dominguez", "72200467L", 9.5),
            new Alumno("Cristina", "Rodriguez", "72265800N", 7.5),
            new Alumno("Felipe", "Sanchez", "70003487J", 8)
        };

        Alumno[] alumnos2 = {
            new Alumno("Ana", "Lopez", "72286467L", 7.5),
            new Alumno("Carlos", "Fernandez", "72270491Y", 9),
            new Alumno("David", "Perez", "72573487J", 8.5),
            new Alumno("Elena", "Hernandez", "72200467L", 9),
            new Alumno("Fernando", "Gomez", "72265800N", 8),
            new Alumno("Gema", "Torres", "70003487J", 7)
        };

        Acta actaOriginal = new Acta(alumnos);
        
        Acta acta2 = new Acta(alumnos2);

        System.out.println("\nHashes de la segunda acta:");
        for (int i = 0; i < acta2.getHash().length; i++) {
            System.out.println("Alumno: " + acta2.getAlumnos(i));
            System.out.println("Hash: " + acta2.getHash()[i]);
            System.out.println("------------------------");
        }

        System.out.println("\n¿Las actas son iguales? " + actaOriginal.equals(acta2));
    }
}