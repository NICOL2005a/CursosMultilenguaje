package cursos;

import personas.Estudiante;
import personas.Persona;
import interfaces.Pagable;
import java.util.*;

public class Curso {
    private String nombreCurso;
    private List<Estudiante> estudiantes = new ArrayList<>();
    private Pagable profesor;

    public Curso(String nombreCurso, Pagable profesor) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
    }

    public void inscribirEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void mostrarDetalle() {
        System.out.println("\n=== Curso: " + nombreCurso + " ===");
        System.out.println("Profesor/a:");
        ((Persona) profesor).mostrarDetalle();
        System.out.println("-- Estudiantes (" + estudiantes.size() + ") --");
        for (Estudiante est : estudiantes) {
            est.mostrarDetalle();
        }
    }
}
