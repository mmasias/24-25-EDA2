# Big o

## **Análisis de Complejidad (Big-O) de `Permutaciones.java`**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Conversión de la cadena a un array de caracteres** | `char[] caracteres = entrada.toCharArray();` | **O(n)** |
| **Ordenación de los caracteres con Bubble Sort** | `ordenarCaracteres(caracteres);` | **O(n²)** |
| **Generación de permutaciones únicas con backtracking** | `generarPermutacionesUnicas(...)` | **O(n!)** |
| **Bucle externo en `ordenarCaracteres`** | `for (int i = 0; i < caracteres.length - 1; i++)` | **O(n)** |
| **Bucle interno en `ordenarCaracteres`** | `for (int j = i + 1; j < caracteres.length; j++)` | **O(n)** |
| **Llamada recursiva en `generarPermutacionesUnicas`** | `generarPermutacionesUnicas(cadena, prefijo + cadena.charAt(i), usados);` | **O(n!)** |
| **Complejidad total del algoritmo** | - | **O(n! + n²) ≈ O(n!)** |

## **Análisis de Complejidad (Big-O) de `Subconjuntos.java` (Método Recursivo)**

| **Ubicación en el Código** | **Código** | **Complejidad (Big-O)** |
|----------------------------|------------|-------------------------|
| **Llamada inicial a la función recursiva** | `generarSubconjuntos(numeros, 0, "");` | **O(1)** |
| **Condición base de la recursión** | `if (index == numeros.length) { ... }` | **O(1)** |
| **Llamada recursiva excluyendo el elemento actual** | `generarSubconjuntos(numeros, index + 1, subconjunto);` | **O(2ⁿ)** |
| **Llamada recursiva incluyendo el elemento actual** | `generarSubconjuntos(numeros, index + 1, subconjunto + numeros[index]);` | **O(2ⁿ)** |
| **Complejidad total del algoritmo** | - | **O(2ⁿ)** |

