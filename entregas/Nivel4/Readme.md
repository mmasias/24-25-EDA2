# Big o

## **Análisis de Complejidad (Big-O) de `ParesDiferencia.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre cada elemento del array** | `for (int i = 0; i < n; i++)` | **O(n)** |
| **Bucle interno que compara cada par de elementos** | `for (int j = i + 1; j < n; j++)` | **O(n)** |
| **Cálculo de la diferencia absoluta** | `Math.abs(arr[i] - arr[j])` | **O(1)** |
| **Verificación de la diferencia con `k`** | `if (Math.abs(arr[i] - arr[j]) == k)` | **O(1)** |
| **Impresión del par encontrado** | `System.out.println("[" + arr[i] + ", " + arr[j] + "]");` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n²)** |


## **Análisis de Complejidad (Big-O) de `Subsecuencia.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización de los índices para recorrer `s` y `t`** | `int i = 0, j = 0;` | **O(1)** |
| **Bucle que recorre `t` mientras busca los caracteres de `s`** | `while (i < s.length() && j < t.length())` | **O(n)** |
| **Comparación de caracteres en `s` y `t`** | `if (s.charAt(i) == t.charAt(j)) { i++; }` | **O(1)** |
| **Incremento del índice `j` en `t`** | `j++;` | **O(1)** |
| **Verificación final si se recorrió toda la subsecuencia** | `return i == s.length();` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |


## **Análisis de Complejidad (Big-O) de `SumaMax.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización de variables** | `int maxSuma = Integer.MIN_VALUE; int inicio = 0, fin = 0;` | **O(1)** |
| **Bucle externo que recorre cada elemento como inicio del subarreglo** | `for (int i = 0; i < n; i++)` | **O(n)** |
| **Bucle interno que calcula la suma de cada subarreglo** | `for (int j = i; j < n; j++)` | **O(n)** |
| **Actualización de la suma y comparación con `maxSuma`** | `suma += arr[j]; if (suma > maxSuma) { ... }` | **O(1)** |
| **Impresión del subarreglo con suma máxima** | `System.out.print([...]);` | **O(n)** |
| **Complejidad total del algoritmo** | - | **O(n²)** |

## **Análisis de Complejidad (Big-O) de `Triangulo.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre cada elemento como primer lado** | `for (int i = 0; i < n; i++)` | **O(n)** |
| **Bucle medio que recorre cada elemento como segundo lado** | `for (int j = i + 1; j < n; j++)` | **O(n)** |
| **Bucle interno que recorre cada elemento como tercer lado** | `for (int k = j + 1; k < n; k++)` | **O(n)** |
| **Verificación de la desigualdad triangular** | `if (arr[i] + arr[j] > arr[k] && arr[i] + arr[k] > arr[j] && arr[j] + arr[k] > arr[i])` | **O(1)** |
| **Impresión de los lados del triángulo** | `System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);` | **O(1)** |
| **Retorno del resultado** | `return true;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n³)** |

## **Análisis de Complejidad (Big-O) de `TripleSumaCero.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre cada elemento como primer número** | `for (int i = 0; i < n - 2; i++)` | **O(n)** |
| **Bucle medio que recorre cada elemento como segundo número** | `for (int j = i + 1; j < n - 1; j++)` | **O(n)** |
| **Bucle interno que recorre cada elemento como tercer número** | `for (int k = j + 1; k < n; k++)` | **O(n)** |
| **Verificación de la suma de los tres números** | `if (arr[i] + arr[j] + arr[k] == 0)` | **O(1)** |
| **Impresión de los tripletes encontrados** | `System.out.println("[" + arr[i] + "," + arr[j] + "," + arr[k] + "]");` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n³)** |
