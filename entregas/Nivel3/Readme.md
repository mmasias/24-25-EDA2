# Big o

## **Análisis de Complejidad (Big-O) de `CasiOrdenado.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle externo que recorre el array** | `for (int i = 1; i < n; i++)` | **O(n)** |
| **Bucle interno que desplaza elementos hasta `k` posiciones** | `while (j > 0 && j > i - k - 1 && numeros[j - 1] > valor)` | **O(k)** |
| **Asignación del valor en la posición correcta** | `numeros[j] = valor;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n * k)** |

# **Análisis de Complejidad (Big-O) de `CombinarArrays.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Cálculo del número total de elementos** | `for (int i = 0; i < k; i++) { totalElementos += arrays[i].length; }` | **O(k)** |
| **Inicialización de arrays `resultado` e `indices`** | `int[] resultado = new int[totalElementos]; int[] indices = new int[k];` | **O(k)** |
| **Bucle externo que recorre `totalElementos`** | `for (int i = 0; i < totalElementos; i++)` | **O(n)** donde `n` es `totalElementos` |
| **Bucle interno que busca el mínimo en `k` listas** | `for (int j = 0; j < k; j++)` | **O(k)** |
| **Asignación del menor elemento al array resultado** | `resultado[i] = minValor; indices[minIndex]++;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n * k)** |


## **Análisis de Complejidad (Big-O) de `ContadorInversiones.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Inicialización del contador de inversiones** | `int contador = 0;` | **O(1)** |
| **Bucle externo que recorre cada elemento del array** | `for (int i = 0; i < n; i++)` | **O(n)** |
| **Bucle interno que compara cada par de elementos** | `for (int j = i + 1; j < n; j++)` | **O(n)** |
| **Comparación para contar inversiones** | `if (numeros[i] > numeros[j]) { contador++; }` | **O(1)** |
| **Retorno del número total de inversiones** | `return contador;` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n²)** |

## **Análisis de Complejidad (Big-O) de `KCercanosSinArrays.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle en `main` que procesa cada número** | `encontrarKCercanos(num, target, k);` | **O(n)** |
| **Cálculo de la distancia absoluta** | `double distancia = Math.abs(numero - target);` | **O(1)** |
| **Comparación y actualización de los dos valores más cercanos** | `if (distancia < dist1) { ... } else if (distancia < dist2) { ... }` | **O(1)** |
| **Verificación y salida de los resultados** | `if (numero == 5) { System.out.println(mejor1 + " " + mejor2); }` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |

## **Análisis de Complejidad (Big-O) de `MedianaStream.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Bucle en `main` que procesa cada número del flujo** | `for (int num : stream) { ... }` | **O(n)** |
| **Comparaciones y actualizaciones de los valores menores y mayores** | `if (num < mayor1) { ... } else if (num < mayor2) { ... }` | **O(1)** |
| **Cálculo de la mediana** | `if ((count + 1) % 2 == 1) { return menor1; } else { return (menor1 + mayor1) / 2.0; }` | **O(1)** |
| **Complejidad total del algoritmo** | - | **O(n)** |
