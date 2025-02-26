# Big o

## **Análisis de Complejidad (Big-O) de `ElementoUnico.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre cada elemento del array** | `for (int i = 0; i < arr.length; i++)` | **O(n)** |
| **Bucle interno que cuenta cuántas veces aparece cada número** | `for (int j = 0; j < arr.length; j++)` | **O(n)** |
| **Comparación de valores** | `if (arr[i] == arr[j])` | **O(1)** |
| **Verificación de unicidad** | `if (count == 1) return arr[i];` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n²)** |


## **Análisis de Complejidad (Big-O) de `NúmeroRepetido.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle que recorre el array para encontrar el elemento mayoritario** | `for (int i = 0; i < n; i++)` | **O(n)** |
| **Condición para actualizar el elemento mayoritario** | `if (contador == 0) { ... }` | **O(1)** |
| **Condición para incrementar o decrementar el contador** | `else if (mayoritario == numeros[i]) { contador++; } else { contador--; }` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |

## **Análisis de Complejidad (Big-O) de `Pico.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización del valor máximo** | `int max = arr[0];` | **O(1)** |
| **Bucle que recorre el array para encontrar el pico** | `for (int i = 1; i < arr.length; i++)` | **O(n)** |
| **Condición para actualizar el máximo** | `if (arr[i] > max) { max = arr[i]; }` | **O(1)** |
| **Retorno del valor máximo** | `return max;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |

## **Análisis de Complejidad (Big-O) de `ProductoDefectuoso.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización de los punteros de búsqueda** | `int inicio = 0, fin = productos.length - 1;` | **O(1)** |
| **Búsqueda binaria para encontrar el primer producto defectuoso** | `while (inicio < fin)` | **O(log n)** |
| **Cálculo del punto medio** | `int medio = inicio + (fin - inicio) / 2;` | **O(1)** |
| **Actualización de los límites de búsqueda** | `if (productos[medio]) { fin = medio; } else { inicio = medio + 1; }` | **O(1)** |
| **Retorno del índice del primer producto defectuoso** | `return inicio;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(log n)** |

## **Análisis de Complejidad (Big-O) de `RotacionArray.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización del índice del valor mínimo** | `int minIndex = 0;` | **O(1)** |
| **Bucle que recorre el array para encontrar el punto de rotación** | `for (int i = 1; i < arr.length; i++)` | **O(n)** |
| **Condición para actualizar el índice mínimo** | `if (arr[i] < arr[minIndex]) { minIndex = i; }` | **O(1)** |
| **Retorno del índice del punto de rotación** | `return minIndex;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |
