# **Ejercicio 1: Elemento mayoritario**

`Problema:` Encuentre el elemento que aparece más de n/2 veces en un array ordenado.

## **Solución 1 (O(n))**

Se cuenta la frecuencia de cada número.

```java
public static int elementoMayoritario(int[] nums) {
    int contador = 1;
    int candidato = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == candidato) {
            contador++;
        } else {
            contador--;
            if (contador == 0) {
                candidato = nums[i];
                contador = 1;
            }
        }
    }
    return candidato;
}
```

`Complejidad:` O(n), recorremos el array una vez.

## **Reto adicional (O(log n))**

Dado que el array está ordenado, usamos búsqueda binaria.

```java
public static int elementoMayoritarioLog(int[] nums) {
    int n = nums.length;
    int medio = n / 2;
    int candidato = nums[medio];
    
    if (esMayoritario(nums, candidato)) {
        return candidato;
    }
    return -1;
}

private static boolean esMayoritario(int[] nums, int candidato) {
    int primera = buscarPrimeraOcurrencia(nums, candidato);
    int ultima = buscarUltimaOcurrencia(nums, candidato);
    return (ultima - primera + 1) > nums.length / 2;
}

private static int buscarPrimeraOcurrencia(int[] nums, int objetivo) {
    int inicio = 0, fin = nums.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin) / 2;
        if (nums[medio] >= objetivo) fin = medio;
        else inicio = medio + 1;
    }
    return inicio;
}

private static int buscarUltimaOcurrencia(int[] nums, int objetivo) {
    int inicio = 0, fin = nums.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin + 1) / 2;
        if (nums[medio] <= objetivo) inicio = medio;
        else fin = medio - 1;
    }
    return inicio;
}
```

`Complejidad:` O(log n) debido a la búsqueda binaria.

---
