package personas;

import excepciones.PagoInvalidoException;
import interfaces.Pagable;

public class ProfesorPorHoras extends Persona implements Pagable {
    private int horasTrabajadas;
    private double pagoPorHora;

    public ProfesorPorHoras(String nombre, String id, int horasTrabajadas, double pagoPorHora) {
        super(nombre, id);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public double calcularPago() throws PagoInvalidoException {
        double total = horasTrabajadas * pagoPorHora;
        if (total <= 0) {
            throw new PagoInvalidoException("Pago total inválido");
        }
        return total;
    }

    @Override
    public void mostrarDetalle() {
        try {
            System.out.printf("PH  | %-10s | Pago: $%.2f (%d h)%n",
                    nombre, calcularPago(), horasTrabajadas);
        } catch (PagoInvalidoException e) {
            System.out.println("Error de pago: " + e.getMessage());
        }
    }
}
