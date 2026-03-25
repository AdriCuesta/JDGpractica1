package solucion;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CuentaCorrienteTest {

    private static List<CuentaBancaria> listaCuentas;  // lista compartida entre tests

    private double saldoInicial;
    private double comision;
    private double interesEsperado;
    private CuentaCorriente cuenta;

    public CuentaCorrienteTest(double saldoInicial, double comision, double interesEsperado) {
        this.saldoInicial = saldoInicial;
        this.comision = comision;
        this.interesEsperado = interesEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][] {
            {1000, 10, -10},
            {500, 5, -5},
            {2000, 20, -20},
            {1500, 0, 0},
            {0, 15, -15},
            {1000, 100, -100},
            {1234, 50, -50},
            {999, 25, -25},
            {200, 0, 0},
            {750, 10, -10}
        });
    }

    // Se ejecuta una sola vez antes de todos los tests
    @BeforeClass
    public static void iniciarPruebasClase() {
        listaCuentas = new ArrayList<CuentaBancaria>();
        System.out.println("=== Creando lista de cuentas corrientes para todos los tests ===");

    }

    // Se ejecuta una sola vez despu�s de todos los tests
    @AfterClass
    public static void finalizarPruebasClase() {
        listaCuentas = null;  // liberar memoria
        System.out.println("=== Lista de cuentas corrientes liberada despu�s de todos los tests ===");
    }

    // Se ejecuta antes de cada test
    @Before
    public void preparar() {
        cuenta = new CuentaCorriente("Test", saldoInicial, comision);
    }

    // Se ejecuta despu�s de cada test
    @After
    public void limpiar() {
        cuenta = null;
    }

    @Test
    public void testCalcularInteres() {
        assertEquals(interesEsperado, cuenta.calcularInteres(), 0.01);
    }

    @Ignore("Test ignorado temporalmente")
    @Test
    public void testFiscal() {
        throw new RuntimeException("Este test est� ignorado y no debe ejecutarse");
    }
}
