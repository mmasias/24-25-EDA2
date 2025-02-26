# Número Faltante - Análisis de Complejidad

## Descripción del Problema

Encontrar el número faltante en un arreglo que contiene números del 1 al n, donde exactamente un número está ausente.

## Soluciones Implementadas

### 1. Método de Suma

- **Complejidad Temporal**: O(n)
  - Un solo recorrido del arreglo
  - Operaciones aritméticas simples
- **Complejidad Espacial**: O(1)
  - Solo variables para sumas
- **Fórmula**: `numeroFaltante = sumaEsperada - sumaActual`
  - `sumaEsperada = n * (n + 1) / 2`

### 2. Método XOR

- **Complejidad Temporal**: O(n)
  - Dos recorridos lineales
- **Complejidad Espacial**: O(1)
  - Solo una variable para XOR
- **Ventaja**: No hay riesgo de desbordamiento

## Ejemplo de Uso

```java
int[] numeros = {1, 2, 4, 5, 6};
int faltante = encontrarFaltanteSuma(numeros); // Retorna 3
```
