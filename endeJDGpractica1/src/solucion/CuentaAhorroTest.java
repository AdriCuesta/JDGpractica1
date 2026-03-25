package solucion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CuentaAhorroTest {

    private static List<CuentaBancaria> listaCuentas;  // lista compartida entre tests

    private double saldoInicial;
    private double tasaInteres;
    private double interesEsperado;
    private CuentaAhorro cuenta;

    public CuentaAhorroTest(double saldoInicial, double tasaInteres, double interesEsperado) {
        this.saldoInicial = saldoInicial;
        this.tasaInteres = tasaInteres;
        this.interesEsperado = interesEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][] {
            {1000, 0.05, 50},
            {500, 0.02, 10},
            {2000, 0.03, 60},
            {1500, 0.04, 60},
            {0, 0.05, 0},
            {1000, 0, 0},
            {1234, 0.05, 61.7},
            {999, 0.1, 99.9},
            {200, 0.25, 50},
            {750, 0.08, 60}
        });
    }

    // Se ejecuta una sola vez antes de todos los tests
    @BeforeClass
    public static void iniciarPruebasClase() {
        listaCuentas = new ArrayList<CuentaBancaria>();
        System.out.println("=== Creando lista de cuentas para todos los tests ===");
    }

    // Se ejecuta una sola vez despu�s de todos los tests
    @AfterClass
    public static void finalizarPruebasClase() {
        listaCuentas = null;  // liberar memoria
        System.out.println("=== Lista de cuentas liberada despu�s de todos los tests ===");
    }

    // Se ejecuta antes de cada test
    @Before
    public void preparar() {
        cuenta = new CuentaAhorro("Test", saldoInicial, tasaInteres);
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