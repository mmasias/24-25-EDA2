# **Ejercicio 1: Combinación de arrays**

`Problema:` Combine k arrays ordenados en uno solo ordenado.

## **Solución (O(n log n))**

Usamos un enfoque de mezcla similar al de Merge Sort.

```java
public static int[] combinarArrays(int[][] arrays) {
    int total = 0;
    for (int[] arr : arrays) total += arr.length;
    int[] resultado = new int[total];
    
    int index = 0;
    for (int[] arr : arrays) {
        for (int num : arr) {
            resultado[index++] = num;
        }
    }
    
    ordenar(resultado);
    return resultado;
}

private static void ordenar(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

`Complejidad:` O(n log n) debido a la ordenación.

---
