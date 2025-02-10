# Apéndice

## Colores base

- `.` - NEGRO - Ausencia de señal
- `#` - BLANCO - Máxima intensidad
- `+` - CYAN - Intensidad media-alta
- `*` - MAGENTA - Intensidad media-alta

## Aritmética de colores por superposición temporal

<div align=center>

|Frame 2 →<br>Frame 1 ↓|`.` (NEGRO)|`#` (BLANCO)|`+` (CYAN)|`*` (MAGENTA)|
|-|-|-|-|-|
|`.` (NEGRO)|`.` (negro)|`@` (gris)|`:` (cyan tenue)|`;` (magenta tenue)|
|`#` (BLANCO)|`@` (gris)|`#` (blanco)|`=` (cyan brillante)|`&` (magenta brillante)|
|`+` (CYAN)|`:` (cyan tenue)|`=` (cyan brillante)|`+` (cyan)|`$` (blanco tenue)|
|`*` (MAGENTA)|`;` (magenta tenue)|`&` (magenta brillante)|`$` (blanco tenue)|`*` (magenta)|

</div>

### Notas sobre las combinaciones

1. La tabla es simétrica porque el orden de los frames no afecta al resultado
1. La diagonal representa la persistencia del mismo color
1. Los nuevos símbolos representan:
   - `@` - Gris
   - `:` - Cyan de baja intensidad
   - `;` - Magenta de baja intensidad
   - `=` - Cyan de alta intensidad
   - `&` - Magenta de alta intensidad
   - `$` - Blanco de intensidad media

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
