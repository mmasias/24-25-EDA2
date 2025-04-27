package v000;

public class Cliente {
   public static void main(String[] args) {
      GestorCSV gestor = new GestorCSV(100, 4);

      cargarDatos(gestor);

      System.out.println("> ESTUDIANTES DE PROGRAMACIÓN 2");
      imprimirDataset(gestor.buscarPorIndice("Asignatura", "Programación 2"));

      System.out.println("> ESTUDIANTE CON ID 1003");
      imprimirDataset(gestor.buscarPorIndice("ID", "1003"));

      System.out.println("> ASIGNATURAS DISPONIBLES");
      imprimirDataset(gestor.obtenerValoresUnicos("Asignatura"));
   }

   private static void cargarDatos(GestorCSV gestor) {
      String[] cabeceras = { "ID", "Nombre", "Asignatura", "Calificacion" };

      String[][] datosEjemplo = {
            { "1075", "Olivia Miranda", "Redes de Computadoras", "88" },
            { "1096", "Salvador Cárdenas", "Arquitectura de Computadoras", "75" },
            { "1061", "Antonia Romero", "Programación 3", "96" },
            { "1048", "Maximiliano Reyes", "Bases de Datos 2", "83" },
            { "1079", "Emilia Cortés", "Bases de Datos 2", "87" },
            { "1056", "Tomás Quintero", "Estructuras de Datos y Algoritmos 3", "73" },
            { "1093", "Isidora Álvarez", "Redes de Computadoras", "98" },
            { "1065", "Cristóbal Montero", "Arquitectura de Computadoras", "84" },
            { "1089", "Florencia Leiva", "Bases de Datos 2", "91" },
            { "1050", "Vicente Lagos", "Programación 3", "77" },
            { "1081", "Paloma Salgado", "Estructuras de Datos y Algoritmos 3", "89" },
            { "1044", "Gaspar Orellana", "Bases de Datos 2", "81" },
            { "1097", "Amanda Zamora", "Redes de Computadoras", "94" },
            { "1059", "Simón Carvajal", "Programación 1", "86" },
            { "1071", "Trinidad Parra", "Teoría de la Computación", "90" },
            { "1086", "Bruno Poblete", "Bases de Datos 2", "74" },
            { "1042", "Magdalena Vidal", "Programación 4", "97" },
            { "1092", "Rafael Riquelme", "Teoría de la Computación", "85" },
            { "1054", "Elisa Toledo", "Programación 4", "82" },
            { "1078", "Santiago Baeza", "Estructuras de Datos y Algoritmos 3", "92" },
            { "1063", "Julieta Vergara", "Redes de Computadoras", "79" },
            { "1098", "Nicolás Tapia", "Teoría de la Computación", "88" },
            { "1045", "Elena Maldonado", "Programación 4", "76" },
            { "1080", "Joaquín Ibáñez", "Bases de Datos 2", "95" },
            { "1055", "Sebastián Ramírez", "Teoría de la Computación", "83" },
            { "1094", "Agustina Venegas", "Programación 4", "89" },
            { "1068", "Leonor Garrido", "Arquitectura de Computadoras", "78" },
            { "1087", "Augusto Peralta", "Teoría de la Computación", "93" },
            { "1057", "Aurora Henríquez", "Programación 4", "81" },
            { "1090", "Iván Pereira", "Bases de Datos 2", "86" },
            { "1074", "Regina Jara", "Arquitectura de Computadoras", "72" },
            { "1049", "Baltazar Toro", "Teoría de la Computación", "99" },
            { "1060", "Violeta Navarrete", "Programación 4", "84" },
            { "1032", "Arturo Medina", "Ingeniería de Software 2", "81" },
            { "1017", "Isabel Vargas", "Estructuras de Datos y Algoritmos 2", "93" },
            { "1018", "Héctor Mendoza", "Ingeniería de Software 1", "85" },
            { "1010", "Daniel Morales", "Programación 2", "83" },
            { "1011", "Carolina Navarro", "Ingeniería de Software 2", "87" },
            { "1012", "Eduardo Vega", "Estructuras de Datos y Algoritmos 2", "79" },
            { "1013", "Gabriela Ruiz", "Ingeniería de Software 1", "94" },
            { "1019", "Patricia Flores", "Estructuras de Datos y Algoritmos 1", "91" },
            { "1020", "Raúl Herrera", "Ingeniería de Software 2", "80" },
            { "1021", "Lucía Ramos", "Programación 2", "88" },
            { "1022", "Fernando Silva", "Estructuras de Datos y Algoritmos 2", "75" },
            { "1023", "Adriana Paz", "Ingeniería de Software 1", "96" },
            { "1024", "Gustavo Luna", "Estructuras de Datos y Algoritmos 1", "83" },
            { "1001", "Ana García", "Programación 2", "85" },
            { "1002", "Javier López", "Estructuras de Datos y Algoritmos 1", "90" },
            { "1003", "María Rodríguez", "Programación 2", "78" },
            { "1014", "Alejandro Castro", "Estructuras de Datos y Algoritmos 1", "82" },
            { "1015", "Natalia Jiménez", "Ingeniería de Software 2", "89" },
            { "1016", "Roberto Ortega", "Programación 2", "77" },
            { "1004", "Carlos Sánchez", "Estructuras de Datos y Algoritmos 2", "95" },
            { "1005", "Laura Martínez", "Estructuras de Datos y Algoritmos 1", "88" },
            { "1006", "Pedro Díaz", "Programación 2", "91" },
            { "1007", "Sofía Fernández", "Estructuras de Datos y Algoritmos 2", "84" },
            { "1008", "Miguel González", "Estructuras de Datos y Algoritmos 1", "76" },
            { "1009", "Valentina Torres", "Ingeniería de Software 1", "92" },
            { "1025", "Marcela Ríos", "Ingeniería de Software 2", "91" },
            { "1026", "Jorge Rojas", "Programación 1", "87" },
            { "1027", "Daniela Acosta", "Programación 2", "84" },
            { "1028", "Ricardo Pinto", "Programación 1", "92" },
            { "1029", "Mónica Bravo", "Ingeniería de Software 1", "78" },
            { "1030", "Samuel Cordero", "Estructuras de Datos y Algoritmos 1", "89" },
            { "1031", "Cecilia Soto", "Programación 1", "95" },
            { "1033", "Valeria Campos", "Programación 1", "90" },
            { "1034", "Diego Mora", "Programación 2", "76" },
            { "1035", "Camila Durán", "Programación 1", "94" },
            { "1036", "Martín Estrada", "Estructuras de Datos y Algoritmos 2", "82" },
            { "1037", "Julia Pacheco", "Ingeniería de Software 1", "88" },
            { "1038", "Esteban Fuentes", "Programación 1", "79" },
            { "1039", "Victoria Núñez", "Programación 1", "93" },
            { "1040", "Felipe Aguilar", "Estructuras de Datos y Algoritmos 1", "86" },
            { "1058", "Mariana Orozco", "Arquitectura de Computadoras", "88" },
            { "1073", "Ernesto Paredes", "Programación 3", "91" },
            { "1047", "Catalina Muñoz", "Bases de Datos 1", "87" },
            { "1099", "Ignacio Villanueva", "Estructuras de Datos y Algoritmos 3", "84" },
            { "1062", "Alicia Guzmán", "Programación 3", "92" },
            { "1051", "Benjamín Sepúlveda", "Bases de DaID", "1003tos 1", "79" },
            { "1088", "Renata Molina", "Redes de Computadoras", "95" },
            { "1095", "Hugo Delgado", "Arquitectura de Computadoras", "82" },
            { "1043", "Ximena Olivares", "Programación 3", "90" },
            { "1077", "Leonardo Salazar", "Estructuras de Datos y Algoritmos 3", "77" },
            { "1084", "Isabella Araya", "Bases de Datos 1", "93" },
            { "1069", "Matías Contreras", "Redes de Computadoras", "81" },
            { "1052", "Constanza Figueroa", "Arquitectura de Computadoras", "89" },
            { "1091", "Octavio Espinosa", "Programación 3", "78" },
            { "1046", "Javiera Arce", "Estructuras de Datos y Algoritmos 3", "94" },
            { "1083", "Andrés Valenzuela", "Bases de Datos 1", "80" },
            { "1082", "Lucas Carrasco", "Ingeniería de Software 3", "88" },
            { "1067", "Maite Bustos", "Teoría de la Computación", "77" },
            { "1076", "Amaro Escobar", "Ingeniería de Software 3", "91" },
            { "1053", "Dominga Alarcón", "Arquitectura de Computadoras", "80" },
            { "1085", "Máximo Guerrero", "Ingeniería de Software 3", "96" },
            { "1066", "Esperanza Sandoval", "Programación 4", "75" },
            { "1072", "Pascual Arellano", "Ingeniería de Software 3", "90" },
            { "1041", "Miranda Cabrera", "Bases de Datos 2", "82" },
            { "1064", "Gonzalo Farías", "Ingeniería de Software 3", "87" },
            { "1070", "Amparo Gallardo", "Programación 4", "79" }
      };

      gestor.cargarDatos(cabeceras, datosEjemplo);
      gestor.crearIndice("Asignatura");
      gestor.crearIndice("ID");
   }

   private static void imprimirDataset(String[] resultado) {
      for (int i = 0; i < resultado.length; i++) {
         System.out.println(resultado[i]);
      }
   }

   private static void imprimirDataset(String[][] resultado) {
      for (int i = 0; i < resultado.length; i++) {
         for (int j = 0; j < resultado[i].length; j++) {
            System.out.print(resultado[i][j] + "\t");
         }
         System.out.println();
      }
      System.out.println();
   }
}
