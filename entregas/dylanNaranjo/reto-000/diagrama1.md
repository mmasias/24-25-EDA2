# 📌 Diagrama UML - Ejercicio 1

## 📖 Descripción
Este diagrama UML representa la estructura de clases para un sistema de gestión de frames y píxeles en una pantalla. Se definen varias clases con sus atributos y métodos, además de las relaciones entre ellas.

## 🛠️ Clases y sus responsabilidades

### 🎨 Pantalla
- **Atributos:** `String atributos`
- **Métodos:** `getFrames()`
- **Descripción:** Representa la pantalla principal que interactúa con el `Buffer` para gestionar los frames.

### 🎭 Pixel
- **Atributos:** `char[][] atributos`
- **Métodos:** `ListaElementos()`
- **Descripción:** Representa los píxeles individuales que forman los frames.

### 🖼️ Frame1 y Frame2
- **Atributos:** `char[][] atributos`
- **Métodos:** `PosicionDeFrames(Pixel)`
- **Descripción:** Representan dos frames que pueden ser combinados para generar un resultado.

### 🔄 Buffer
- **Métodos:** `MostrarFrameElegido(Frame1, Frame2, Resultado)`
- **Descripción:** Actúa como un intermediario que gestiona qué frame se debe mostrar.

### 🎯 Resultado
- **Atributos:** `char[][] atributos`
- **Métodos:** `combinar(Frame1, Frame2)`
- **Descripción:** Combina dos frames en uno solo para su visualización final.

## 🔗 Relaciones entre clases
- `Pantalla` se comunica con `Buffer`.
- `Pixel` se relaciona con `Frame1` y `Frame2`.
- `Frame1` y `Frame2` interactúan con `Buffer`.
- `Buffer` gestiona la visualización y el resultado final.

### 🖼️ Diagrama UML

![Diagrama UML](/entregas/reto-000_dylanNaranjo/img/diagramaEjercicio1.svg)

