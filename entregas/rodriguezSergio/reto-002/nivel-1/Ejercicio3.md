# **Ejercicio 3: Número faltante**

`Problema:` En un array que contiene números del 1 al n, falta un número. Encuéntrelo.

## **Solución 1 (O(n))**

Sumamos los valores esperados y los reales, restando el faltante.

```java
public static int numeroFaltante(int[] nums) {
    int n = nums.length + 1;
    int sumaEsperada = (n * (n + 1)) / 2;
    int sumaReal = 0;
    for (int num : nums) {
        sumaReal += num;
    }
    return sumaEsperada - sumaReal;
}
```

`Complejidad:` O(n) ya que recorremos el array una vez.

## **Reto adicional (O(n), sin espacio extra)**

Usamos XOR, ya que x ^ x = 0 y x ^ 0 = x.

```java
public static int numeroFaltanteXOR(int[] nums) {
    int xorTotal = 0, xorArray = 0;
    for (int i = 1; i <= nums.length + 1; i++) {
        xorTotal ^= i;
    }
    for (int num : nums) {
        xorArray ^= num;
    }
    return xorTotal ^ xorArray;
}
```

`Complejidad:` O(n), sin necesidad de arrays extra.

---
