## Explicación del código
### Referencias:
Se declara un array de tipo Dispositivo que almacena objetos de sus subclases (Smartphone, Laptop y Televisor), permitiendo tratarlos de forma uniforme.

### Sobrescritura de métodos:
El método encender() se define en Dispositivo y cada subclase lo reimplementa para mostrar mensajes específicos, demostrando cómo se puede modificar el comportamiento heredado.

### Acceso a métodos específicos y uso de instanceof:
Aunque los objetos se manejan como Dispositivo, se utiliza instanceof y downcasting para llamar a métodos propios de una subclase (como hacerLlamada() o conectarInternet()).

### Covarianza en arrays:
Un array de Dispositivo puede contener cualquier subclase, lo que facilita trabajar con distintos tipos de dispositivos relacionados.

### Igualdad y polimorfismo:
Al usar equals() para comparar objetos, se evidencia que, sin sobrescribir el método, se comparan las referencias (ubicación en memoria) y no el contenido.

### Uso de super:
En los constructores de las subclases se invoca super(marca) para inicializar la propiedad común en la clase base y se aprovecha super.mostrarInfo() para reutilizar código ya definido.