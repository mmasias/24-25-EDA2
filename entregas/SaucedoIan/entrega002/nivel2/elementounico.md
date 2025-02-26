# Elemento Único - Análisis de Complejidad

## Solución Implementada

- **Complejidad Temporal**: O(n)
  - Una sola pasada por el arreglo
  - Operación XOR por elemento
- **Complejidad Espacial**: O(1)
  - Solo variable para resultado
  - No requiere espacio adicional

## Ejemplo

```java
int[] numeros = {1, 2, 1, 3, 2};
int unico = encontrarElementoUnico(numeros);
// Resultado: 3
```
