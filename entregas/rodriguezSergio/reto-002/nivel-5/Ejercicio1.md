# **Ejercicio 1: Permutaciones**

`Problema:` Genere todas las permutaciones de un string.

## **Solución (O(n!))**

Usamos recursión para intercambiar caracteres.

```java
public static void permutaciones(String s) {
    permutar(s.toCharArray(), 0);
}

private static void permutar(char[] arr, int inicio) {
    if (inicio == arr.length - 1) {
        System.out.println(new String(arr));
        return;
    }
    for (int i = inicio; i < arr.length; i++) {
        intercambiar(arr, inicio, i);
        permutar(arr, inicio + 1);
        intercambiar(arr, inicio, i);
    }
}

private static void intercambiar(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

`Complejidad:` O(n!) por la generación de todas las permutaciones.

---
