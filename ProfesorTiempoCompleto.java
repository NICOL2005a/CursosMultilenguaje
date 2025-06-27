package personas;

import excepciones.PagoInvalidoException;
import interfaces.Pagable;

public class ProfesorTiempoCompleto extends Persona implements Pagable {
    private double salarioMensual;

    public ProfesorTiempoCompleto(String nombre, String id, double salarioMensual) {
        super(nombre, id);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularPago() throws PagoInvalidoException {
        if (salarioMensual <= 0) {
            throw new PagoInvalidoException("Salario mensual inválido");
        }
        return salarioMensual;
    }

    @Override
    public void mostrarDetalle() {
        try {
            System.out.printf("PTC | %-10s | Pago: $%.2f%n", nombre, calcularPago());
        } catch (PagoInvalidoException e) {
            System.out.println("Error de pago: " + e.getMessage());
        }
    }
}
