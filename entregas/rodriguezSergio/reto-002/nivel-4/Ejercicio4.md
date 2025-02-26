# **Ejercicio 4: Subsecuencia**

`Problema:` Determine si un string es subsecuencia de otro.

## **Solución (O(n))**

Usamos un puntero para recorrer el string objetivo.

```java
public static boolean esSubsecuencia(String s, String t) {
    int i = 0, j = 0;
    while (i < s.length() && j < t.length()) {
        if (s.charAt(i) == t.charAt(j)) i++;
        j++;
    }
    return i == s.length();
}
```

`Complejidad:` O(n) ya que recorremos ambos strings una vez.

---
