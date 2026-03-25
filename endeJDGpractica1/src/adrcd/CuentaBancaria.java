package adrcd;
/**
 * Clase abstracta que representa una cuenta bancaria predeterminada
 * 
 * Contiene las funciones esenciales como ingreso y retiro de saldo
 * como también el calculo de intereses que dependerá del tipo de cuenta
 */
public abstract class CuentaBancaria {
	
	/**
	 * Nombre del titular de la cuenta bancaria
	 */
    protected String titular;
    /**
     * Saldo de la cuenta
     */
    protected double saldo;
    
    /**
     * Constructor de la cuenta bancaria
     * 
     * @param titular
     * @param saldoInicial
     * 
     * @throws IllegalArgumentException si el saldo es nagativo
     */
    public CuentaBancaria(String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Devuelve el nombre del titular de la cuenta
     * @return nombre titular de la cuenta
     */
    public String getTitular() {
        return titular;
    }
    /**
     * Devuelve el saldo de la cuenta
     * @return saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }
    /**
     * Ingresa una cantidad de dinero al saldo de la cuenta
     * @param cantidad Dinero a ingresar en la cuenta
     * @throws IllegalArgumenException si se ingresa cantidades negativas
     */
    public void ingresar(double cantidad) {
    	if(cantidad < 0) {
    		throw new IllegalArgumentException("No puedes ingresar cantidades negativas");
    	}
        saldo += cantidad;
    }
    /**
     * Retira saldo de la cuenta
     * @param cantidad Cantidad de saldo a retirar
     * 
     * @throws IllegalArgumentException si la cantidad es negativa
     * @throws IllegalArgumentExceptio si la cantidad supera el saldo
     */
    public void reintegrar(double cantidad) {
    	if(cantidad < 0) {
    		throw new IllegalArgumentException("No puedes retirar cantidades negativas");
    	}
    	if(cantidad > saldo) {
    		throw new IllegalArgumentException("No puedes retirar más dinero del que tienes");
    	}
    	
        saldo -= cantidad;
    }
    /**
     * Calcula el interes de mantenimiento de la cuenta
     * Dependerá del tipo de cuenta
     * @return cantidad de interés calculado
     */
    public abstract double calcularInteres();

}
