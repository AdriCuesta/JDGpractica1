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
public class CuentaAhorroTest {

	private static ArrayList<CuentaBancaria> listaCuentasBancarias;

	private double saldo;
	private double tasaInteres;
	private double interes;
	private CuentaAhorro cuenta;
	
	public CuentaAhorroTest(double saldo, double tasaInteres, double interes) {
		this.saldo = saldo;
		this.tasaInteres = tasaInteres;
		this.interes = interes;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {
		return Arrays.asList(new Object[][] {
			{1000,0.05,50},
			{500,0.02,10},
			{2000,0.03,60},
			{1500,0.04,60},
			{0,0.05,0}
			}); 
		}
	
	@Test
	public void testCalcularInteres() {
		assertEquals(interes, cuenta.calcularInteres(),0.01);
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
		cuenta = new CuentaAhorro("CuentaTest", saldo, tasaInteres);
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
