### Referencias
En la clase Main, se utilizan referencias de la clase Curso para almacenar objetos de sus subclases (Estudiante, Asignatura y Profesor), demostrando así el uso de referencias y la capacidad del polimorfismo para apuntar a diferentes instancias.
### Sobrescritura de métodos
En las clases Asignatura, Estudiante y Profesor. Cada subclase sobrescribe el método iniciar() heredado de Curso para proporcionar un comportamiento específico a cada tipo(por ejemplo comenzar la participación de un estudiante).
### Limitaciones de tipo
En la clase Main, cuando se recorre Curso, aunque las referencias son de tipo Curso, sólo se puede acceder directamente a los métodos declarados en esa clase. Para usar métodos propios de las subclases (como inscribirse(), asistirClase() o asignarProfesor()), es necesario realizar una comprobación y un cast, demostrando la limitación impuesta por el tipo de referencia.
### Acceso a métodos específicos

Dentro del bucle en Main (con uso de instanceof y casting). Se utiliza la comprobación instanceof para determinar el tipo real del objeto y, tras ello, se realiza el casting a ese tipo específico para acceder a métodos que no existen en la clase base Curso.
### Covarianza en arrays

En la declaración y uso de Curso[] cursos en Main. La clase Curso puede contener objetos de cualquier subclase, demostrando la covarianza en arrays en Java.
### Uso de instanceof

En el bucle de Main al evaluar cada elemento. La instrucción instanceof se emplea para determinar el tipo real del objeto antes de hacer un casting, asegurando que se accede de forma segura a los métodos específicos de cada subclase.
### Igualdad y polimorfismo
En Main, al comparar dos instancias de Asignatura usando equals(), aunque ambas variables están declaradas como Curso, en tiempo de ejecución se comportan como instancias de Asignatura. La comparación con equals() (no sobrescrito, por lo que utiliza el de Object) ilustra cómo la igualdad se evalúa en el contexto polimórfico, donde dos objetos con contenido idéntico pueden no ser considerados iguales si son instancias distintas.
### Uso de super
En los constructores de las subclases Asignatura, Estudiante y Profesor, la palabra clave super se usa para llamar al constructor de la clase Curso y así inicializar el atributo común nombre, evitando la duplicación de código y asegurando una correcta herencia de propiedades.
### Interacción entre interfaces y herencia
Aunque en el ejemplo no se definen interfaces, la estructura de herencia presentada es compatible con la incorporación de interfaces. Por ejemplo, se podría definir una interfaz como Evaluable y hacer que algunas clases (o subclases) la implementen, combinando la herencia con la implementación de contratos adicionales para enriquecer el diseño.