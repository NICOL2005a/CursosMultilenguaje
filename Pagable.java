package interfaces;

import excepciones.PagoInvalidoException;

public interface Pagable {
    double calcularPago() throws PagoInvalidoException;
}
