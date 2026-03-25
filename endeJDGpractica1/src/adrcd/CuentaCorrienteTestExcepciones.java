package adrcd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuentaCorrienteTestExcepciones {

	private static CuentaCorriente cuenta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		cuenta = new CuentaCorriente("Pillonarie", 100, 2);
	}

	@After
	public void tearDown() throws Exception {
		cuenta = null;
	}

	@Test
	public void testIngresoNegativo() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> cuenta.ingresar(-100));
		assertEquals("No puedes ingresar cantidades negativas", errorAtrapado.getMessage());
	}

	@Test
	public void testRetiroNegativo() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> cuenta.reintegrar(-1000));
		assertEquals("No puedes retirar cantidades negativas", errorAtrapado.getMessage());
	}
	
	@Test
	public void testRetiroSaldoMayor() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> cuenta.reintegrar(9999999));
		assertEquals("No puedes retirar más dinero del que tienes", errorAtrapado.getMessage());
	}

}
