package adrcd;
/**
 * Clase que representa una cuenta de ahorro
 */
public class CuentaAhorro extends CuentaBancaria {
	
	/**
	 * Tasa de interes aplicada al saldo de la cuenta
	 */
	private double tasaInteres;
	
	/**
	 * Constructor de la clase cuenta de ahorro
	 * 
	 * @param titular Nombre del titular de la cuenta
	 * @param saldoInicial Saldo incial de la cuenta
	 * @param tasaInteres Tasa de interes al saldo
	 */
	public CuentaAhorro(String titular, double saldoInicial, double tasaInteres) {
		super(titular, saldoInicial);

		this.tasaInteres = tasaInteres;
	}
	
	/**
	 * Calcula el interes por mantener la cuenta
	 * 
	 * @return saldo multiplicado por la tasa de interes que tenga la cuenta
	 */
	@Override
	public double calcularInteres() {
		return (saldo * tasaInteres);
	}

}
