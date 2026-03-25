package solucion;

/**
 * Clase que representa una cuenta corriente.
 * Este tipo de cuenta puede tener una comisión de mantenimiento.
 */
public class CuentaCorriente extends CuentaBancaria {

    /** Comisión de mantenimiento de la cuenta */
    private double comision;

    /**
     * Constructor de la cuenta corriente.
     *
     * @param titular Nombre del titular de la cuenta
     * @param saldoInicial Saldo inicial de la cuenta
     * @param comision Comisión de mantenimiento aplicada
     */
    public CuentaCorriente(String titular, double saldoInicial, double comision) {
        super(titular, saldoInicial);
        this.comision = comision;
    }

    /**
     * Calcula el coste de mantenimiento de la cuenta.
     *
     * @return valor negativo que representa la comisión
     */
    @Override
    public double calcularInteres() {
        return -comision; // representa coste de mantenimiento
    }
}