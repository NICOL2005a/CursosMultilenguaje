# Laboratorio 8 – Sistema de Gestión de Cursos Académicos
# Autor: <tu-nombre>

from abc import ABC, abstractmethod
from typing import List

# === Interfaces ===
class Pagable(ABC):
    @abstractmethod
    def calcular_pago(self) -> float: ...

class Calificable(ABC):
    @abstractmethod
    def calcular_promedio(self) -> float: ...

# === Excepciones personalizadas ===
class PagoInvalidoException(Exception): pass
class PromedioInvalidoException(Exception): pass

# === Clase abstracta ===
class Persona(ABC):
    def __init__(self, nombre: str, id: str):
        self.nombre = nombre
        self.id = id

    @abstractmethod
    def mostrar_detalle(self) -> None: ...

# === Subclases ===
class ProfesorTiempoCompleto(Persona, Pagable):
    def __init__(self, nombre: str, id: str, salario_mensual: float):
        super().__init__(nombre, id)
        self.salario_mensual = salario_mensual

    def calcular_pago(self) -> float:
        if self.salario_mensual <= 0:
            raise PagoInvalidoException("Salario mensual inválido")
        return self.salario_mensual

    def mostrar_detalle(self) -> None:
        try:
            print(f"PTC | {self.nombre:<10} | Pago: ${self.calcular_pago():.2f}")
        except PagoInvalidoException as e:
            print("Error de pago:", e)

class ProfesorPorHoras(Persona, Pagable):
    def __init__(self, nombre: str, id: str,
                 horas_trabajadas: int, pago_por_hora: float):
        super().__init__(nombre, id)
        self.horas_trabajadas = horas_trabajadas
        self.pago_por_hora = pago_por_hora

    def calcular_pago(self) -> float:
        total = self.horas_trabajadas * self.pago_por_hora
        if total <= 0:
            raise PagoInvalidoException("Pago total inválido")
        return total

    def mostrar_detalle(self) -> None:
        try:
            print(f"PH  | {self.nombre:<10} | Pago: ${self.calcular_pago():.2f}"
                  f" ({self.horas_trabajadas} h)")
        except PagoInvalidoException as e:
            print("Error de pago:", e)

class Estudiante(Persona, Calificable):
    def __init__(self, nombre: str, id: str):
        super().__init__(nombre, id)
        self.calificaciones: List[float] = []

    def agregar_calificacion(self, c: float) -> None:
        self.calificaciones.append(c)

    def calcular_promedio(self) -> float:
        if not self.calificaciones:
            raise PromedioInvalidoException("Sin calificaciones")
        return sum(self.calificaciones) / len(self.calificaciones)

    def mostrar_detalle(self) -> None:
        try:
            print(f"EST | {self.nombre:<10} | Prom.: {self.calcular_promedio():.2f}")
        except PromedioInvalidoException as e:
            print("Error de promedio:", e)

# === Clase Curso ===
class Curso:
    def __init__(self, nombre_curso: str, profesor: Pagable):
        self.nombre_curso = nombre_curso
        self.profesor = profesor
        self.estudiantes: List[Estudiante] = []

    def inscribir_estudiante(self, est: Estudiante) -> None:
        self.estudiantes.append(est)

    def mostrar_detalle(self) -> None:
        print(f"\n=== Curso: {self.nombre_curso} ===")
        print("Profesor/a:")
        self.profesor.mostrar_detalle()
        print(f"-- Estudiantes ({len(self.estudiantes)}) --")
        for est in self.estudiantes:
            est.mostrar_detalle()

# === Función principal tipo menú ===
def main() -> None:
    # Datos de prueba (mismo patrón que en Java)
    ptc = ProfesorTiempoCompleto("Ana", "PTC01", 25000)
    ph = ProfesorPorHoras("Luis", "PH01", 40, 200)
    e1 = Estudiante("Carlos", "E01")
    e1.calificaciones = [8.5, 9.0, 8.0]
    e2 = Estudiante("María", "E02")
    e2.agregar_calificacion(10)

    poo = Curso("POO", ptc)
    poo.inscribir_estudiante(e1)
    poo.inscribir_estudiante(e2)

    personas: List[Persona] = [ptc, ph, e1, e2]
    cursos: List[Curso] = [poo]

    while True:
        print("\n--- MENÚ PRINCIPAL ---")
        print("1. Ver personas")
        print("2. Ver cursos")
        print("0. Salir")
        opcion = input("Elige una opción: ")

        if opcion == "1":
            for p in personas:
                p.mostrar_detalle()
        elif opcion == "2":
            for c in cursos:
                c.mostrar_detalle()
        elif opcion == "0":
            break

if __name__ == "__main__":
    main()
