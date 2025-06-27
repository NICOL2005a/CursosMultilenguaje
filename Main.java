package app;

import personas.*;
import cursos.Curso;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProfesorTiempoCompleto ptc = new ProfesorTiempoCompleto("Ana", "PTC01", 25000);
        ProfesorPorHoras ph = new ProfesorPorHoras("Luis", "PH01", 40, 200);

        Estudiante e1 = new Estudiante("Carlos", "E01");
        e1.agregarCalificacion(8.5);
        e1.agregarCalificacion(9.0);
        e1.agregarCalificacion(8.0);

        Estudiante e2 = new Estudiante("María", "E02");
        e2.agregarCalificacion(10);

        Curso poo = new Curso("POO", ptc);
        poo.inscribirEstudiante(e1);
        poo.inscribirEstudiante(e2);

        List<Persona> personas = new ArrayList<>(Arrays.asList(ptc, ph, e1, e2));
        List<Curso> cursos = new ArrayList<>(List.of(poo));

        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver personas");
            System.out.println("2. Ver cursos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> personas.forEach(Persona::mostrarDetalle);
                case 2 -> cursos.forEach(Curso::mostrarDetalle);
            }
        } while (opcion != 0);

        sc.close();
    }
}
