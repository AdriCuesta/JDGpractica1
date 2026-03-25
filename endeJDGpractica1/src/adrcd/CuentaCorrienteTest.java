package adrcd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CuentaCorrienteTest {

	private double saldo;
	private int comision;
	private double interes;

	private CuentaCorriente cuenta;

	private static ArrayList<CuentaBancaria> listaCuentasBancarias;

	public CuentaCorrienteTest(double saldo, int comision, double interes) {
		this.saldo = saldo;
		this.comision = comision;
		this.interes = interes;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {
		return Arrays.asList(new Object[][] { 
			{ 1000, 10, -10 }, 
			{ 500, 5, -5 }, 
			{ 2000, 20, -20 }, 
			{ 1500, 0, 0 },
			{ 0, 15, -15 } });
	}

	@Test
	public void testCalcularInteres() {
		assertEquals(interes, cuenta.calcularInteres(), 0.01);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		listaCuentasBancarias = new ArrayList<>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		listaCuentasBancarias = null;
	}

	@Before
	public void setUp() throws Exception {
		cuenta = new CuentaCorriente("titular", saldo, comision);
	}

	@After
	public void tearDown() throws Exception {
		cuenta = null;
	}

	@Ignore
	@Test
	public void testFiscal() {
		fail("Not yet implemented");
	}

}
