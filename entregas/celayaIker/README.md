# 📘 Complejidad de los Ejercicios

Para obtener una respuesta correcta por parte de ChatGPT le pasamos primero las indicaciones previas a los ejercicios para que lo haga en Java Plain Vanilla. Luego en cada petición le recordamos que respete estas reglas.

Este documento contiene la complejidad temporal de cada ejercicio resuelto, incluyendo la versión normal y la versión extra optimizada.

## Nivel 1: O(1) y O(n)

### 1️⃣ Suma Objetivo

Normal: O(n²) - Fuerza bruta con dos bucles anidados.

Extra: O(n) - Algoritmo de una pasada con estructura auxiliar (no permitida en este caso, por lo que se mantiene en O(n²)).

### 2️⃣ Búsqueda de Palabra

Normal: O(n) - Recorrer el array buscando las letras en orden.

Extra: O(n) - Se permite encontrar la palabra sin importar el orden y para cualquier longitud.

### 3️⃣ Número faltante

Normal: O(n) - Suma esperada vs. suma real.

Extra: O(n) - Mismo enfoque sin espacio extra.

### 4️⃣ Array "Montaña"

Normal: O(n) - Recorrer el array validando la secuencia creciente y decreciente.

Extra: O(n) - Alternativa optimizada con un solo recorrido.

### 5️⃣ Punto de Equilibrio

Normal: O(n²) - Calcular suma izquierda y derecha en cada índice.

Extra: O(n) - Mantener acumulados para reducir sumas redundantes.

## Nivel 2: O(log n)

### 6️⃣ Elemento Mayoritario

Normal: O(n) - Contar apariciones.

Extra: O(log n) - Búsqueda binaria en un array ordenado.

### 7️⃣ Producto Defectuoso

Normal: O(n) - Recorrer el array hasta encontrar true.

Extra: O(log n) - Búsqueda binaria para minimizar comparaciones.

### 8️⃣ Array Rotado

Normal: O(n) - Buscar el punto de rotación linealmente.

Extra: O(log n) - Búsqueda binaria, incluso con duplicados.

### 9️⃣ Pico en Montaña

Normal: O(n) - Recorrer el array buscando el pico.

Extra: O(log n) - Búsqueda binaria para encontrar el pico más eficientemente.

### 🔟 Elemento Único

Normal: O(n²) - Comparar cada elemento con los demás.

Extra: O(n) - XOR para encontrar el elemento único sin espacio extra.

## Nivel 3: O(n log n)

### 1️⃣1️⃣ Combinación de Arrays

Normal: O(n log n) - Ordenar y combinar arrays ordenados.

Extra: O(n log k) - Optimizado para muchos arrays (k-way merge).

### 1️⃣2️⃣ K Elementos Más Cercanos

Normal: O(n log n) - Ordenar por diferencia y tomar los primeros k.

Extra: O(n log k) - Heap para obtener los k más cercanos sin ordenar todo el array.

### 1️⃣3️⃣ Casi Ordenado

Normal: O(n log n) - Ordenar completamente.

Extra: O(n log k) - Usar un heap con tamaño k para mantener la estructura casi ordenada.

### 1️⃣4️⃣ Mediana en Stream

Normal: O(n log n) - Ordenar en cada inserción.

Extra: O(log n) - Usar dos heaps para optimizar inserción/extracción.

### 1️⃣5️⃣ Contador de Inversiones

Normal: O(n²) - Comparar cada par.

Extra: O(n log n) - Merge Sort para contar inversiones eficientemente.

## Nivel 4: O(n²)

### 1️⃣6️⃣ Triángulos Posibles

Normal: O(n²) - Ordenar y usar dos punteros.

Extra: O(n²) - Encontrar todos los tríos sin repetición.

### 1️⃣7️⃣ Tripletes Suma Cero

Normal: O(n²) - Ordenar y usar dos punteros.

Extra: O(n²) - Alternativa sin ordenar pero manteniendo eficiencia.

### 1️⃣8️⃣ Suma Máxima

Normal: O(n) - Algoritmo de Kadane.

Extra: O(n log n) - Divide y Vencerás.

## Nivel 5: Complejidades Superiores

### 1️⃣9️⃣ Subsecuencia

Normal: O(n) - Dos punteros recorriendo t.

Extra: O(m * n) - Manejar múltiples strings s de manera eficiente.

### 2️⃣0️⃣ Pares con Diferencia k

Normal: O(n log n) - Ordenar y usar dos punteros.

Extra: O(n log n + m * n) - Optimizar para múltiples k.

### 2️⃣1️⃣ Permutaciones

Normal: O(n!) - Backtracking.

Extra: O(n! / k!) - Evitar duplicados con ordenamiento y marcas.

### 2️⃣2️⃣ Subconjuntos

Normal: O(2^n) - Backtracking.

Extra: O(nCk) - Generar subconjuntos de tamaño k.