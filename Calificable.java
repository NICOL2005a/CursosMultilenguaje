package interfaces;

import excepciones.PromedioInvalidoException;

public interface Calificable {
    double calcularPromedio() throws PromedioInvalidoException;
}
