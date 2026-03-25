package adrcd;

public class CuentaCorriente extends CuentaBancaria{
	
	private int comision;
	
	public CuentaCorriente(String titular, double saldoInicial,int comision) {
		super(titular, saldoInicial);
		this.comision = comision;
	}

	@Override
	public double calcularInteres() {
		return comision;
	}
	
}
