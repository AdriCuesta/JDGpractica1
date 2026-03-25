package adrcd;

public class CuentaAhorro extends CuentaBancaria {

	private double tasaInteres;

	public CuentaAhorro(String titular, double saldoInicial, double tasaInteres) {
		super(titular, saldoInicial);

		this.tasaInteres = tasaInteres;
	}

	@Override
	public double calcularInteres() {
		return (saldo * tasaInteres);
	}

}
