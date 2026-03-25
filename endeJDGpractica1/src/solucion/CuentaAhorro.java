package solucion;

/**
 * Clase que representa una cuenta de ahorro.
 * Este tipo de cuenta genera intereses en función de una tasa aplicada al saldo.
 */
public class CuentaAhorro extends CuentaBancaria {

    /** Tasa de interés aplicada al saldo de la cuenta */
    private double tasaInteres;

    /**
     * Constructor de la cuenta de ahorro.
     *
     * @param titular Nombre del titular de la cuenta
     * @param saldoInicial Saldo inicial de la cuenta
     * @param tasaInteres Porcentaje de interés aplicado al saldo
     */
    public CuentaAhorro(String titular, double saldoInicial, double tasaInteres) {
        super(titular, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    /**
     * Calcula el interés generado por la cuenta de ahorro.
     *
     * @return interés calculado en función del saldo y la tasa
     */
    @Override
    public double calcularInteres() {
        return saldo * tasaInteres;
    }
}