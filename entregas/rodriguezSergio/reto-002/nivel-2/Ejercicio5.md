# **Ejercicio 5: Elemento único**

`Problema:` En un array donde todos los elementos aparecen dos veces excepto uno, encuentre el elemento único.

## **Solución (O(n))**

Usamos el operador XOR para encontrar el elemento único sin espacio extra.

```java
public static int encontrarUnico(int[] arr) {
    int unico = 0;
    for (int num : arr) {
        unico ^= num;
    }
    return unico;
}
```

`Complejidad:` O(n), recorremos el array una sola vez con operaciones constantes.
