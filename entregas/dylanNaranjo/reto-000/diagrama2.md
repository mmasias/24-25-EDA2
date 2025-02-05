# 📌 Diagrama UML - Ejercicio 2

Este diagrama UML representa la estructura y relación entre clases utilizadas para gestionar la visualización y combinación de frames en una pantalla.

## 📌 Descripción de las Clases

### 🎨 Pantalla
- Contiene los atributos y métodos necesarios para gestionar la pantalla.
- Método principal: `getFrames()`.

### 🎨 Pixeles
- Representa la estructura de los pixeles en forma de una matriz de caracteres (`char[][]`).
- Contiene una lista de delineamiento.

### 🎨 Colores_compuestos
- Similar a `Pixeles`, maneja una matriz de caracteres (`char[][]`) para representar los colores compuestos.
- Método `listaColores()` para obtener los colores disponibles.

### 🎬 Frame1 & Frame2
- Contienen atributos de tipo matriz de caracteres (`char[][]`) para definir la estructura de los frames.
- Poseen posiciones específicas en la pantalla.
- Integran `Pixeles` y `Colores_compuestos`.

### 🔄 Buffer
- Clase encargada de gestionar la visualización de los frames.
- Método `mostrarFrameElegido(Frame1, Frame2, ResultadoVisual)` permite alternar entre los frames y el resultado visual final.

### 🎭 ResultadoVisual
- Combina los frames en un solo resultado visual.
- Método `combinar(Frame1, Frame2)` permite fusionar ambos frames.

## 🔗 Relaciones entre Clases
- `Pantalla` se comunica con `Buffer` para gestionar la visualización.
- `Buffer` interactúa con `Frame1`, `Frame2` y `ResultadoVisual`.
- `Frame1` y `Frame2` dependen de `Pixeles` y `Colores_compuestos` para definir su contenido visual.
- `ResultadoVisual` toma `Frame1` y `Frame2` para generar la visualización final.

### 🖼️ Diagrama UML

![Diagrama UML](/entregas/dylanNaranjo/reto-000/img/diagramaEjercicio2.svg)

![Diagrama UML - Examen](/entregas/dylanNaranjo/reto-000/img/Ejercicio%202.jpg)