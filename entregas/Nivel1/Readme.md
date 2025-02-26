# Big o

## **Análisis de Complejidad (Big-O) de `SumaObjeto.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre las filas de la matriz** | `for (int i = 0; i < matriz.length; i++)` | **O(m)** |
| **Bucle interno que recorre los elementos de cada fila** | `for (int i = 0; i < numeros.length; i++)` | **O(n)** |
| **Bucle anidado que busca la pareja dentro de la fila** | `for (int j = i + 1; j < numeros.length; j++)` | **O(n)** |
| **Complejidad total del algoritmo** | - | **O(m * n²)** |



## **Análisis de Complejidad (Big-O) de `PuntoEquilibrio.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización de los arreglos `sumaIzquierda` y `sumaDerecha`** | `int[] sumaIzquierda = new int[n]; int[] sumaDerecha = new int[n];` | **O(n)** |
| **Cálculo de sumas acumuladas desde la izquierda** | `for (int i = 1; i < n; i++)` | **O(n)** |
| **Cálculo de sumas acumuladas desde la derecha** | `for (int i = n - 2; i >= 0; i--)` | **O(n)** |
| **Búsqueda del punto de equilibrio** | `for (int i = 0; i < n; i++)` | **O(n)** |
| **Complejidad total del algoritmo** | - | **O(n)** |


## **Análisis de Complejidad (Big-O) de `NumeroFaltante.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Cálculo de la suma esperada usando la fórmula de Gauss** | `int sumaEsperada = (n * (n + 1)) / 2;` | **O(1)** |
| **Cálculo de la suma real recorriendo el array** | `for (int num : numeros) { sumaReal += num; }` | **O(n)** |
| **Cálculo del número faltante** | `return sumaEsperada - sumaReal;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |

## **Análisis de Complejidad (Big-O) de `Montaña.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre las filas de la matriz** | `for (int i = 0; i < matriz.length; i++)` | **O(m)** |
| **Verificación de longitud mínima del array** | `if (arr.length < 3) return false;` | **O(1)** |
| **Bucle que encuentra el pico de la montaña** | `while (i < n - 1 && arr[i] < arr[i + 1])` | **O(n)** |
| **Verificación de si el pico está en un extremo** | `if (i == 0 || i == n - 1) return false;` | **O(1)** |
| **Bucle que verifica el descenso de la montaña** | `while (i < n - 1 && arr[i] > arr[i + 1])` | **O(n)** |
| **Verificación final de si llegó al final del array** | `return i == n - 1;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(m * n)** |

## **Análisis de Complejidad (Big-O) de `BuscarPalabra.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre cada letra de la palabra** | `for (int i = 0; i < palabra.length(); i++)` | **O(m)** |
| **Bucle interno que busca la letra en el array de caracteres** | `for (int j = 0; j < caracteres.length; j++)` | **O(n)** |
| **Comparación de caracteres** | `if (caracteres[j] == letra)` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(m * n)** |
