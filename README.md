#  Reporte de la Práctica: Sistema de Gestión de Cursos Académicos

##  Lenguajes utilizados

- **Java:** implementación principal basada en clases, interfaces, excepciones personalizadas y menú interactivo.
- **Python:** traducción del sistema manteniendo la misma lógica con `abc`, excepciones y estructuras de clases.

---

##  Objetivo de la práctica

Implementar un sistema de gestión académica en el que:

- Existan personas con diferentes roles (profesores y estudiantes).
- Se gestionen cursos que tienen un profesor responsable y estudiantes inscritos.
- Se calcule el pago de profesores y el promedio de los estudiantes usando polimorfismo.
- Se apliquen los conceptos de abstracción, herencia e interfaces (en Java) o clases abstractas (en Python).

---

##  Estructura general del sistema

### 🔹 Interfaces (Java)

- `Pagable`: define `calcularPago()`.
- `Calificable`: define `calcularPromedio()`.

Ambas son implementadas por clases concretas que tienen que definir su propio cálculo.

---

### 🔹 Excepciones personalizadas

- `PagoInvalidoException`: se lanza cuando el salario o cálculo de pago es inválido.
- `PromedioInvalidoException`: se lanza cuando un estudiante no tiene calificaciones.

Esto permite un manejo de errores más claro y orientado al dominio del sistema.

---

### 🔹 Clase abstracta `Persona`

Define los atributos `nombre` e `id` y el método abstracto `mostrarDetalle()`. Es extendida por:

- `ProfesorTiempoCompleto`: tiene salario mensual.
- `ProfesorPorHoras`: tiene número de horas y pago por hora.
- `Estudiante`: almacena calificaciones y calcula promedio.

---

### 🔹 Clase `Curso`

Cada curso tiene:

- Un nombre.
- Un profesor (objeto que implementa la interfaz `Pagable`).
- Una lista de estudiantes (objetos `Estudiante` que implementan `Calificable`).

Permite inscribir estudiantes y mostrar detalles completos del curso.

---

## 🧪 Ejecución del programa

El sistema tiene un menú en consola con opciones para:

- Mostrar personas (profesores y estudiantes).
- Mostrar cursos y sus participantes.
- Salir del sistema.

Datos de prueba precargados permiten ver resultados desde la primera ejecución.

---

##  Traducción de Java a Python

### Equivalencias utilizadas

| Java                          | Python                                  |
|------------------------------|-----------------------------------------|
| `interface`                  | `ABC` (Abstract Base Class)             |
| `abstract class`             | `ABC` + `@abstractmethod`               |
| `ArrayList<Persona>`         | `List[Persona]` (typing)                |
| `System.out.printf(...)`     | `print(f"...")`                         |
| `Exception extends`          | `class CustomException(Exception)`      |
| `Scanner` y menú `switch`    | `input()` y `if/elif`                   |

### Conservación de estilo

- Se mantuvieron los nombres en español.
- Se replicaron los métodos (`mostrarDetalle`, `calcularPago`, etc.).
- Se conservó la estructura de clases y lógica de negocio.
- Se tiparon los métodos y atributos con `typing`.

---

##  Conceptos aplicados

### ✅ Abstracción

- Java: `Persona` es abstracta, fuerza a implementar `mostrarDetalle`.
- Python: `Persona` es una clase base abstracta (`ABC`), igual.

Permite definir un modelo genérico común que otras clases pueden extender.

---

### ✅ Herencia

- `ProfesorTiempoCompleto`, `ProfesorPorHoras`, `Estudiante` heredan de `Persona`.
- Comparten atributos (`nombre`, `id`) y especializan comportamiento (`mostrarDetalle`).

---

### ✅ Polimorfismo

- En listas de `Persona` se puede recorrer y llamar a `mostrarDetalle` sin importar el tipo real del objeto.
- Igualmente, `Curso` invoca `mostrarDetalle` en `profesor` y estudiantes sin saber su clase exacta.

Ejemplo:

```java
for (Persona p : personas) {
    p.mostrarDetalle(); // Puede ser profesor o estudiante
}
```

---

###  Manejo de excepciones

- Cada clase valida sus propios datos y lanza excepciones si son inválidos.
- El sistema central (`Main` o `main()`) captura esas excepciones y muestra mensajes amigables.

---

##  Conclusión

Esta práctica integró todos los fundamentos de la programación orientada a objetos:

- Abstracción, herencia, interfaces y polimorfismo.
- Diseño limpio, modular y extensible.
- Traducción fiel a Python, conservando estilo y estructura.
- Separación en ramas (branches) por módulo facilita el trabajo colaborativo y el control de versiones.

---

## 🗂️ Archivos proporcionados

- `SistemaCursos_Ramas.zip`: carpetas separadas por rama (Java).
- `sistema_cursos.py`: versión completa del sistema en Python.
