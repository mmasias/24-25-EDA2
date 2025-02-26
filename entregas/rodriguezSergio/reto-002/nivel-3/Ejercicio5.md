
# **Ejercicio 5: Contador de inversiones**

`Problema:` Cuente cuántos pares de elementos están en el orden incorrecto.

## **Solución (O(n^2))**

Usamos un doble bucle para contar inversiones.

```java
public static int contarInversiones(int[] arr) {
    int conteo = 0;
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) conteo++;
        }
    }
    return conteo;
}
```

`Complejidad:` O(n^2) debido al doble bucle anidado.
