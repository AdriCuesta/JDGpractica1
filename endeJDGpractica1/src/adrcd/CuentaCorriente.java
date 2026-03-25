package adrcd;
/**
 * Clase que representa una cuenta corriente
 */
public class CuentaCorriente extends CuentaBancaria{
	
	/**
	 * Comision de mantenimiento de la cuenta
	 */
	private int comision;
	
	/**
	 * Constructor de la cuenta corriente
	 * 
	 * @param titular Nombre del titular de la cuenta corriente
	 * @param saldoInicial Saldo incial de la cuenta
	 * @param comision Comision de mantenimiento de la cuenta
	 */
	public CuentaCorriente(String titular, double saldoInicial,int comision) {
		super(titular, saldoInicial);
		this.comision = comision;
	}
	
	/**
	 * Calcula el coste de mantenimiento de la cuenta (comision)
	 * 
	 * @return comision Comision por mantenimiento de la cuenta
	 */
	@Override
	public double calcularInteres() {
		return comision;
	}
	
}
