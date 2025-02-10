# Técnicas avanzadas de la tarjeta CGA

> Se aporta una [propuesta de solución](propuestaDeSolucion.md). Abordaremos su implementación en EDA2.

## Contexto

En los primeros días de los ordenadores personales, IBM introdujo la tarjeta CGA (Color Graphics Adapter) como parte del IBM PC original en 1981. Esta tarjeta representó un hito significativo al ser uno de los primeros adaptadores gráficos en color accesibles.

<div align=center>

|![](/images/exodus-ultima-iii-dos.png)|![](/images/CGA_program_interface.png)|
|:-:|:-:|
|[Exodus, Ultima III](https://en.wikipedia.org/wiki/Ultima_III:_Exodus)|[PCPaint](https://en.wikipedia.org/wiki/PCPaint)|
|1983|1984|

**Especificaciones**<br>Resolución estándar: 320x200 píxeles. / [Paleta](anexoPaleta.md): 4 colores simultáneos. / Memoria de video: 16 KB. / Frecuencia de refresco: 60 Hz.


</div>

### Limitaciones y desafíos

La tarjeta CGA presentaba dos limitaciones principales que los programadores de la época buscaron superar:

<div align=center>

|Resolución limitada|Paleta de colores reducida|
|-|-|
|La resolución de 320x200 resultaba insuficiente para muchas aplicaciones.|Solo 4 colores simultáneos limitaban las posibilidades gráficas.|
|Los textos y gráficos detallados aparecían poco definidos.|Los degradados y efectos visuales eran difíciles de lograr.|
|Las aplicaciones profesionales requerían mayor precisión.|La representación realista de imágenes era casi imposible.|

</div>

### Innovaciones técnicas

Los programadores y desarrolladores de la época descubrieron dos técnicas innovadoras para superar estas limitaciones:

<div align=center>

|El modo entrelazado|La superposición temporal|
|-|-|
|Alternaba entre dos frames de 320x200  para obtener una resolución efectiva de 640x200.|Alternaba rápidamente entre diferentes patrones de color lo que permitía efectos visuales de colores adicionales.|
|![](/images/CGA_640x200_game.png)|![](/images/exodus-ultima-iii-dos-composite.png)|


</div>

Las dos técnicas descritas aprovechaban una característica fundamental de los monitores CRT de la época: la [persistencia del fósforo](https://github.com/mmasias/mmasias/blob/main/UNEATLANTICO/varios/persistenciaFosforo.md). Cuando el haz de electrones excitaba el revestimiento de fósforo de la pantalla, este no solo brillaba instantáneamente, sino que mantenía cierta luminosidad durante unos milisegundos después de que el haz pasara.

## Ejercicio 1: El modo entrelazado para alta resolución

Se requiere diseñar las estructuras de datos necesarias para implementar el modo entrelazado, de modo que permita duplicar la resolución horizontal de 320x200 a 640x200 píxeles.

### Requisitos

El sistema deberá:

- Gestionar dos frames de 320x200.
- Permitir la alternancia rápida entre frames.
- Mantener un sistema de doble buffer para evitar parpadeos.
- Permitir la actualización de píxeles individuales.

### Demostración ASCII (7x3)

<div align=center>

<table>
<tr>
<th>Frame 1 (7x3)</th><th>Frame 1 (7x3)</th><th>Resultado combinado (16x3)</th>
</tr>
<tr>
<td valign=top>

```
. . . # # . .
+ + . . . . .
# # # . . . .
```
</td>
<td valign=top>

```
. # # . . . .
. . + + . . .
. . # # # . .
```
</td>
<td valign=top>

```

. . . # # . . . # # . . . .
+ + . . . . . . . + + . . .
# # # . . . . . . # # # . .
```
</td>
</tr>
</table>

</div>

## Ejercicio 2: superposición temporal para paleta extendida

Se requiere diseñar las estructuras de datos necesarias para implementar una técnica de superposición temporal de píxeles que permita obtener colores adicionales mediante la persistencia del fósforo del monitor.

### Requisitos

El sistema deberá:

- Mantener los cuatro colores base: negro, blanco, cyan y magenta.
- Implementar la [tabla de combinación de colores](anexoPaleta.md#aritm%C3%A9tica-de-colores-por-superposici%C3%B3n-temporal).
- Permitir la alternancia entre patrones de color.
- Gestionar la temporización de la alternancia.

### Demostración ASCII (manteniendo resolución original)

<div align=center>

<table>
<tr>
<th>Frame 1</th><th>Frame 2</th><th>Resultado visual</th>
</tr>
<tr>
<td valign=top>

```
. . # .
+ . . *
# + * .
```
</td>
<td valign=top>

```
# . . #
. * + .
. # + *
```
</td>
<td valign=top>

```
@ . # @
+ $ + *
# + $ *
```
</td>
</tr>
</table>

</div>

## Criterios de evaluación

### Estructuras

- Proponer diagramas UML de clases que muestren las estructuras de datos necesarias.
- Especificar atributos y métodos principales de cada clase.
- Mostrar las relaciones entre las diferentes estructuras.

Deberá explicar:

- La elección de cada estructura de datos utilizada.
- Por qué las estructuras elegidas son apropiadas para el problema.
- Las ventajas y desventajas del diseño propuesto.

### Eficiencia y optimización

Deberá explicar cómo las estructuras y procesos propuestos:

- Facilitan las operaciones requeridas.
- Minimizan el uso de memoria.
- Permiten una implementación eficiente.

## Consideraciones adicionales

- ¿Cómo podrían las estructuras propuestas para un ejercicio adaptarse o reutilizarse para el otro?
- ¿Qué ventajas y desventajas presenta cada diseño?
- ¿Cómo se podrían combinar ambas técnicas en un único sistema?

> ***NOTA:*** No existe una única solución correcta. Se evaluará la justificación del diseño y cómo este aborda los requisitos planteados.

---

# Apéndice

## Aritmética de colores por superposición temporal

<div align=center>

||Colores base||
|-|:-:|-|
|`.`|NEGRO|Ausencia de señal
|`#`|BLANCO|Máxima intensidad
|`+`|CYAN|Intensidad media-alta
|`*`|MAGENTA|Intensidad media-alta

</div>


<div align=center>

|Frame 2 →<br>Frame 1 ↓|`.` (NEGRO)|`#` (BLANCO)|`+` (CYAN)|`*` (MAGENTA)|
|-|-|-|-|-|
|`.` **NEGRO**|`.` (negro)|`@` (gris)|`:` (cyan tenue)|`;` (magenta tenue)|
|`#` **BLANCO**|`@` (gris)|`#` (blanco)|`=` (cyan brillante)|`&` (magenta brillante)|
|`+` **CYAN**|`:` (cyan tenue)|`=` (cyan brillante)|`+` (cyan)|`$` (blanco tenue)|
|`*` **MAGENTA**|`;` (magenta tenue)|`&` (magenta brillante)|`$` (blanco tenue)|`*` (magenta)|

||Colores compuestos||
|-|-|-|
|`@`|Gris
|`:`|Cyan de baja intensidad
|`;`|Magenta de baja intensidad
|`=`|Cyan de alta intensidad
|`&`|Magenta de alta intensidad
|`$`|Blanco de intensidad media

</div>

### Aplicación

<div align=center>

<table>
<tr>
<th>Frame 1</th><th>Frame 2</th><th>Resultado</th>
</tr>
<tr>
<td valign=top>

```
. # +
+ . *
```
</td>
<td valign=top>

```
# . *
. * +
```
</td>
<td valign=top>

```
@ # $
: ; $
```
</td>
</tr>
</table>

</div>

Este efecto se logra por la persistencia del fósforo del monitor CRT, que hace que el ojo humano perciba una mezcla de los colores que se alternan rápidamente.
