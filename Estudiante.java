package personas;

import excepciones.PromedioInvalidoException;
import interfaces.Calificable;
import java.util.*;

public class Estudiante extends Persona implements Calificable {
    private final List<Double> calificaciones = new ArrayList<>();

    public Estudiante(String nombre, String id) {
        super(nombre, id);
    }

    public void agregarCalificacion(double c) {
        calificaciones.add(c);
    }

    @Override
    public double calcularPromedio() throws PromedioInvalidoException {
        if (calificaciones.isEmpty()) {
            throw new PromedioInvalidoException("Sin calificaciones");
        }
        return calificaciones.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public void mostrarDetalle() {
        try {
            System.out.printf("EST | %-10s | Prom.: %.2f%n", nombre, calcularPromedio());
        } catch (PromedioInvalidoException e) {
            System.out.println("Error de promedio: " + e.getMessage());
        }
    }
}
