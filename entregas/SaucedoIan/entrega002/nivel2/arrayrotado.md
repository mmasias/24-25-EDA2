# Array Rotado - Análisis de Complejidad

## Descripción del Problema

Encontrar el punto donde un arreglo ordenado fue rotado hacia la derecha.

## Solución Implementada

### Búsqueda Binaria Modificada

- **Complejidad Temporal**: O(log n)
  - Reducción del espacio de búsqueda a la mitad
  - Comparaciones constantes por iteración
- **Complejidad Espacial**: O(1)
  - Variables de índices
  - No usa estructuras adicionales

### Funcionamiento

1. Comparar elemento medio con adyacentes
2. Detectar punto de discontinuidad
3. Actualizar rango de búsqueda
4. Recuperar arreglo original

## Ejemplo de Uso

```java
int[] arreglo = {4, 5, 6, 1, 2, 3};  // rotado 3 posiciones
int puntoRotacion = encontrarPuntoRotacion(arreglo);
// Resultado: 3 (índice donde comienza 1,2,3)
```
