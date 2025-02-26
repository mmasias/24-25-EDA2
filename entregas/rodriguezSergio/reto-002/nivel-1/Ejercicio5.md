# **Ejercicio 5: Punto de equilibrio**

`Problema:` Encuentre el índice donde la suma de los elementos a la izquierda es igual a la suma de los elementos a la derecha.

## **Solución (O(n))**

Calculamos la suma total y luego recorremos restando la suma izquierda.

```java
public static int puntoEquilibrio(int[] arr) {
    int sumaTotal = 0, sumaIzquierda = 0;
    for (int num : arr) sumaTotal += num;
    for (int i = 0; i < arr.length; i++) {
        sumaTotal -= arr[i];
        if (sumaIzquierda == sumaTotal) return i;
        sumaIzquierda += arr[i];
    }
    return -1;
}
```

`Complejidad:` O(n), recorremos el array dos veces.
