package adrcd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuentaAhorroTestExcepciones {

	private static CuentaAhorro cuenta;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cuenta = new CuentaAhorro("Tete", 2000, 2);
	}

	@After
	public void tearDown() throws Exception {
		cuenta = null;
	}

	@Test
	public void testIngresoNegativo() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> cuenta.ingresar(-1));
		assertEquals("No puedes ingresar cantidades negativas", errorAtrapado.getMessage());
	}

	@Test
	public void testRetiroNegativo() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> cuenta.reintegrar(-1));
		assertEquals("No puedes retirar cantidades negativas", errorAtrapado.getMessage());
	}

	@Test
	public void testRetiroSuperior() {
		Exception errorAtrapado = assertThrows(IllegalArgumentException.class, () -> cuenta.reintegrar(99999));
		assertEquals("No puedes retirar más dinero del que tienes", errorAtrapado.getMessage());
	}

}
