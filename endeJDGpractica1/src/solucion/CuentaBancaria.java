package solucion;

/**
 * Clase abstracta que representa una cuenta bancaria genérica.
 * Define las operaciones básicas que cualquier tipo de cuenta debe tener,
 * como ingresar dinero, retirar dinero y calcular intereses.
 * 
 * Las clases que hereden de esta deberán implementar el método
 * {@link #calcularInteres()} según su tipo de cuenta.
 * 
 * @author 
 */
public abstract class CuentaBancaria {

    /** Nombre del titular de la cuenta */
    protected String titular;

    /** Saldo actual de la cuenta */
    protected double saldo;

    /**
     * Constructor de la cuenta bancaria.
     *
     * @param titular Nombre del titular de la cuenta
     * @param saldoInicial Cantidad inicial de dinero en la cuenta
     * @throws IllegalArgumentException si el saldo inicial es negativo
     */
    public CuentaBancaria(String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     *
     * @return nombre del titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     *
     * @return saldo disponible
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Ingresa una cantidad de dinero en la cuenta.
     *
     * @param cantidad dinero a ingresar
     * @throws IllegalArgumentException si la cantidad es negativa
     */
    public void ingresar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("No se pueden ingresar cantidades negativas");
        }
        saldo += cantidad;
    }

    /**
     * Retira una cantidad de dinero de la cuenta.
     *
     * @param cantidad dinero a retirar
     * @throws IllegalArgumentException si la cantidad es negativa
     * @throws IllegalArgumentException si no hay saldo suficiente
     */
    public void reintegrar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("No se pueden retirar cantidades negativas");
        }
        if (cantidad > saldo) {
            throw new IllegalArgumentException("No hay suficiente saldo para realizar la operación");
        }
        saldo -= cantidad;
    }

    /**
     * Calcula el interés o coste asociado a la cuenta.
     * Cada tipo de cuenta implementará su propia lógica.
     *
     * @return cantidad de interés generado o coste aplicado
     */
    public abstract double calcularInteres();
}