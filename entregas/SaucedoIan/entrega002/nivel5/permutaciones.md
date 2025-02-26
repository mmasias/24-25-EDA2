# Generador de Permutaciones - Análisis de Complejidad

## Descripción del Problema

Generar todas las permutaciones posibles de una cadena de caracteres.

## Solución Implementada

### Algoritmo Recursivo con Backtracking

- **Complejidad Temporal**: O(n!)
  - n factorial permutaciones posibles
  - Cada permutación requiere n pasos
- **Complejidad Espacial**: O(n! + n)
  - Array de resultados: O(n!)
  - Pila de recursión: O(n)

### Características del Algoritmo

1. Generación recursiva
2. Intercambio de caracteres in-place
3. Almacenamiento de todas las permutaciones
4. Manejo de strings como arrays de caracteres

## Ejemplo de Uso

```java
String entrada = "abc";
String[] permutaciones = generarPermutaciones(entrada);
// Salida: ["abc", "acb", "bac", "bca", "cab", "cba"]
```
