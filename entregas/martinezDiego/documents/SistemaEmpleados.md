# Sistema de empleados

Este programa utiliza los principios de **herencia** y **polimorfismo** en Java para gestionar diferentes tipos de empleados en una empresa. A continuación se describe brevemente cada clase y subclase.

## 1. Clase `Empleado` (Clase Abstracta)
- **Propósito**: Define la estructura base para los empleados. Contiene los atributos comunes como `nombre` y `salarioBase`, y un método abstracto `calcularSalario()` que deben implementar las subclases.
- **Métodos**:
  - `calcularSalario()`: Método abstracto que calcula el salario de los empleados.
  - `imprimirInformacion()`: Imprime el nombre y el salario calculado del empleado.

## 2. Subclase `Desarrollador`
- **Propósito**: Representa a un empleado de tipo desarrollador, que hereda de `Empleado` y calcula su salario basado en los proyectos completados.
- **Métodos**:
  - `calcularSalario()`: Calcula el salario sumando un bono de `500` por cada proyecto completado al salario base.

## 3. Subclase `Gerente`
- **Propósito**: Representa a un gerente, que también hereda de `Empleado`. El salario del gerente se calcula en función del número de equipos gestionados.
- **Métodos**:
  - `calcularSalario()`: Calcula el salario sumando un bono de `1000` por cada equipo gestionado al salario base.

## 4. Subclase `Interno`
- **Propósito**: Representa a un empleado interno, que hereda de `Empleado`. Su salario es simplemente el salario base sin bonos adicionales.
- **Métodos**:
  - `calcularSalario()`: Devuelve el salario base sin modificaciones.

## 5. Clase `Demo`
- **Propósito**: Es la clase que contiene el método `main` y se encarga de crear instancias de las diferentes subclases (`Desarrollador`, `Gerente`, `Interno`) y mostrar su información.
- **Métodos**:
  - `mostrarInformacionEmpleado()`: Imprime la información de un empleado, invocando el método `imprimirInformacion()` de cada subclase para mostrar su salario calculado.

## Resumen

- **Herencia**: Las subclases (`Desarrollador`, `Gerente`, `Interno`) heredan de la clase base `Empleado`, lo que les permite compartir atributos comunes y personalizar el cálculo del salario según el tipo de empleado.
- **Polimorfismo**: Usando el tipo `Empleado`, podemos manejar diferentes tipos de empleados de manera uniforme y llamar al método adecuado de cada subclase para calcular su salario.



