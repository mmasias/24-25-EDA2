# Ejercicios

Estos ejercicios deben resolverse usando Java "plain vanilla", es decir:

- Sin usar estructuras de datos avanzadas de Java Collections (HashMap, TreeSet, etc.)
- Sin usar métodos utilitarios (Arrays.sort(), Collections.binarySearch(), etc.)
- Implementando las estructuras y algoritmos desde cero
- Solo se permite el uso de arrays primitivos y estructuras básicas como bucles y condicionales

El objetivo es comprender y practicar los algoritmos subyacentes, no usar implementaciones ya existentes.

Desarrolle (al menos) un algoritmo que resuelva el problema planteado, demuestre su funcionamiento y justifique su complejidad BigO

> ***NOTA:*** Se propone el buscar más de una forma de hacer cada ejercicio.

## Nivel 1: O(1) y O(n)

### Suma objetivo

Dado un conjunto de números enteros y un entero objetivo, devuelva los índices de dos números que sumados den el objetivo.

```
Entrada: números [3, 2, 9, 8], objetivo 10
Salida: índices [1, 3] (2 + 8 = 10)
```

**Reto adicional**: Resuélvalo en una sola pasada por el array.

### Búsqueda de palabra

Dado un array de caracteres y una palabra clave de tres letras, devuelva los índices de los elementos que conforman la palabra.

```
Entrada: ['a', 'c', 'd', 'i', 'm', 'r', 't', 'u'], palabra "dia"
Salida: [2, 3, 0]
```

**Reto adicional**: Adapte la solución para palabras de cualquier longitud.

### Número faltante

En un array que contiene números del 1 al n, falta un número. Encuéntrelo.

```
Entrada: [1, 2, 4, 5, 6]
Salida: 3
```

**Reto adicional**: Resuélvalo sin usar espacio extra.

### Array "montaña"

Verifique si un array es una montaña (primero estrictamente creciente y luego estrictamente decreciente).

```
Entrada: [1, 3, 5, 4, 2]
Salida: true
```

### Punto de equilibrio

Encuentre el índice donde la suma de los elementos a la izquierda es igual la suma de los elementos a la derecha.

```
Entrada: [1, 2, 3, 4, 6]
Salida: 3 (1+2+3 = 6)
```

**Reto adicional**: Minimice el número de sumas que realiza.

## Nivel 2: O(log n)

### Elemento mayoritario

Encuentre el elemento que aparece más de n/2 veces en un array ordenado.

```
Entrada: [1,1,1,1,2,2,3]
Salida: 1
```

**Reto adicional**: Resuélvalo en O(log n) aprovechando que está ordenado.

### Producto defectuoso

En una línea de producción los productos empiezan a salir defectuosos en cierto punto. Encuentre el primer producto defectuoso.

```
Entrada: [false, false, false, true, true]
Salida: 3
```

**Reto adicional**: Minimice el número de comparaciones.

### Array rotado

Encuentre el punto donde fue rotado un array originalmente ordenado.

```
Entrada: [4, 5, 6, 1, 2, 3]
Salida: 3
```

**Reto adicional**: ¿Qué pasa si hay elementos duplicados?

### Pico en montaña

Encuentre el elemento más grande en un array que primero crece y luego decrece.

```
Entrada: [1, 3, 5, 7, 6, 4, 2]
Salida: 7
```

**Reto adicional**: ¿Qué pasa si hay elementos duplicados?

### Elemento único

En un array donde todos los elementos aparecen dos veces excepto uno, encuentre el elemento único.

```
Entrada: [1, 2, 1, 3, 2]
Salida: 3
```

**Reto adicional**: Resuélvalo sin espacio extra.

## Nivel 3: O(n log n)

### Combinación de arrays

Combine k arrays ordenados en uno solo ordenado.

```
Entrada: [[1,4,7], [2,5,8], [3,6,9]]
Salida: [1,2,3,4,5,6,7,8,9]
```

**Reto adicional**: Optimice para k grande.

### K elementos más cercanos

Encuentre los k números más cercanos a un valor dado.

```
Entrada: [1,2,3,4,5], k=2, target=3.7
Salida: [3,4]
```

**Reto adicional**: Resuélvalo sin ordenar todo el array.

### Casi ordenado

Ordene un array donde cada elemento está a lo más *k* posiciones de su posición final.

```
Entrada: [2,1,3,5,4], k=2
Salida: [1,2,3,4,5]
```

**Reto adicional**: Minimice el uso de memoria.

### Mediana en stream

Encuentre la mediana a medida que llegan números.

```
Entrada (en flujo): 1, 3, 2, 4, 5
Salidas: 1, 2, 2, 2.5, 3
```

**Reto adicional**: Optimice las inserciones y extracciones.

### Contador de inversiones

Cuente cuántos pares de elementos están en el orden incorrecto.

```
Entrada: [2,4,1,3,5]
Salida: 3 (2,1), (4,1), (4,3)
```

## Nivel 4: O(n²)

### Triángulos posibles

Encuentre tres números que puedan formar un triángulo.

```
Entrada: [3, 4, 5, 6, 7]
Salida: true (3,4,5)
```

**Reto adicional**: Encuentre todos los triángulos posibles.

### Tripletes suma cero

Encuentre todos los tripletes que suman cero.

```
Entrada: [-1, 0, 1, 2, -1, -4]
Salida: [[-1,-1,2], [-1,0,1]]
```

### Suma máxima

Encuentre el subarreglo contiguo con suma máxima.

```
Entrada: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Salida: [4, -1, 2, 1]
```

### Subsecuencia

Determine si un string es subsecuencia de otro.

```
Entrada: s = "abc", t = "ahbgdc"
Salida: true
```

**Reto adicional**: ¿Qué pasa si hay múltiples strings para verificar?

### Pares con diferencia

Encuentre todos los pares que difieren en k.

```
Entrada: [1, 7, 5, 9, 2, 12, 3], k=2
Salida: [[1,3], [5,7], [7,9]]
```

**Reto adicional**: Optimice para múltiples k.

## Nivel 5: Complejidades superiores

### Permutaciones: O(n!)

Genere todas las permutaciones de un string.

```
Entrada: "abc"
Salida: ["abc", "acb", "bac", "bca", "cab", "cba"]
```

**Reto adicional**: Maneje caracteres duplicados.

### Subconjuntos: O(2^n)

Encuentre todos los subconjuntos de un conjunto.

```
Entrada: [1, 2, 3]
Salida: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
```

**Reto adicional**: Genere subconjuntos de tamaño k.
