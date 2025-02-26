# Elemento Mayoritario - Análisis de Complejidad

## Descripción del Problema

Encontrar el elemento que aparece más de n/2 veces en un arreglo.

## Solución Implementada

### Algoritmo de Boyer-Moore

- **Complejidad Temporal**: O(n)
  - Una pasada para encontrar candidato
  - Una pasada para validar
- **Complejidad Espacial**: O(1)
  - Solo variables para candidato y contador
  - No requiere espacio adicional

### Funcionamiento

1. Seleccionar primer elemento como candidato
2. Incrementar/decrementar contador según coincidencia
3. Cambiar candidato cuando contador llega a 0
4. Validar candidato final

## Ejemplo de Uso

```java
int[] numeros = {1, 1, 1, 1, 2, 2, 3};
int mayoritario = encontrarElementoMayoritario(numeros);
// Resultado: 1 (aparece 4 veces en array de 7)
```
