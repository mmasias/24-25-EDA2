# Búsqueda de Palabra - Análisis de Complejidad

## Descripción del Problema

Dado un arreglo de caracteres y una palabra de tres letras, encontrar los índices de los elementos que forman la palabra.

## Soluciones Implementadas

### 1. Fuerza Bruta

- **Complejidad Temporal**: O(n³)
  - Tres bucles anidados
  - Cada bucle recorre n elementos
- **Complejidad Espacial**: O(n)
  - Array booleano para rastrear caracteres usados
  - Array para almacenar índices

### 2. Solución Optimizada

- **Complejidad Temporal**: O(n)
  - Un solo recorrido del arreglo para mapear posiciones
  - Búsqueda directa por cada letra O(1)
- **Complejidad Espacial**: O(1)
  - Arrays de tamaño fijo (26 para letras del alfabeto)

## Ejemplo de Uso

```java
char[] letras = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
String palabra = "dia";
// Resultado esperado: [2, 3, 0]
```
