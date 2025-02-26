# Pico en Montaña - Análisis de Complejidad

## Descripción del Problema

Encontrar el elemento más alto en un arreglo que primero crece y luego decrece (forma de montaña).

## Solución Implementada

### Búsqueda Binaria del Pico

- **Complejidad Temporal**: O(log n)
  - División binaria del espacio de búsqueda
  - Comparación con elemento adyacente
- **Complejidad Espacial**: O(1)
  - Solo variables de índices
  - No requiere espacio adicional

### Características del Algoritmo

1. Aprovecha la forma de montaña
2. Encuentra pico en tiempo logarítmico
3. No requiere recorrer todo el arreglo
4. Funciona con montañas asimétricas

## Ejemplo de Uso

```java
int[] montana = {1, 3, 5, 7, 6, 4, 2};
int pico = encontrarPico(montana);
// Resultado: 7 (elemento más alto)
```
