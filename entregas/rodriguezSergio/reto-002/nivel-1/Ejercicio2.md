# **Ejercicio 2: Búsqueda de palabra**

`Problema:` Dado un array de caracteres y una palabra clave de tres letras, devuelva los índices de los elementos que conforman la palabra.

## **Solución (O(n²))**

Se comparan todas las posibles combinaciones de tres caracteres en el array.

```java
public static int[] buscarPalabra(char[] arr, String palabra) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr.length; k++) {
                if (arr[i] == palabra.charAt(0) && arr[j] == palabra.charAt(1) && arr[k] == palabra.charAt(2)) {
                    return new int[]{i, j, k};
                }
            }
        }
    }
    return new int[]{-1, -1, -1};
}
```

`Complejidad:` O(n³) en el peor caso.

## **Reto adicional (O(n))**

Adaptamos la solución para palabras de cualquier longitud.

```java
public static int[] buscarPalabraOpt(char[] arr, String palabra) {
    int[] indices = new int[palabra.length()];
    int encontrado = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == palabra.charAt(encontrado)) {
            indices[encontrado] = i;
            encontrado++;
            if (encontrado == palabra.length()) return indices;
        }
    }
    return new int[]{-1};
}
```

`Complejidad:` O(n) en el mejor caso.

---
