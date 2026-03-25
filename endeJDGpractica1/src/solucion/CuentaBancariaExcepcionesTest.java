package solucion;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuentaBancariaExcepcionesTest {

    // ------------------ TESTS PARA CUENTA AHORRO ------------------

    @Test
    public void testIngresoNegativoCuentaAhorro() {
        CuentaAhorro cuenta = new CuentaAhorro("Ana", 1000, 0.05);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> cuenta.ingresar(-100)
        );

        assertEquals("No se pueden ingresar cantidades negativas", exception.getMessage());
    }

    @Test
    public void testReintegrarNegativoCuentaAhorro() {
        CuentaAhorro cuenta = new CuentaAhorro("Ana", 1000, 0.05);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> cuenta.reintegrar(-50)
        );

        assertEquals("No se pueden retirar cantidades negativas", exception.getMessage());
    }

    @Test
    public void testReintegrarMasQueSaldoCuentaAhorro() {
        CuentaAhorro cuenta = new CuentaAhorro("Ana", 1000, 0.05);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> cuenta.reintegrar(2000)
        );

        assertEquals("No hay suficiente saldo para realizar la operaci�n", exception.getMessage());
    }

    // ------------------ TESTS PARA CUENTA CORRIENTE ------------------

    @Test
    public void testIngresoNegativoCuentaCorriente() {
        CuentaCorriente cuenta = new CuentaCorriente("Luis", 500, 10);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> cuenta.ingresar(-200)
        );

        assertEquals("No se pueden ingresar cantidades negativas", exception.getMessage());
    }

    @Test
    public void testReintegrarNegativoCuentaCorriente() {
        CuentaCorriente cuenta = new CuentaCorriente("Luis", 500, 10);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> cuenta.reintegrar(-100)
        );

        assertEquals("No se pueden retirar cantidades negativas", exception.getMessage());
    }

    @Test
    public void testReintegrarMasQueSaldoCuentaCorriente() {
        CuentaCorriente cuenta = new CuentaCorriente("Luis", 500, 10);

        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> cuenta.reintegrar(1000)
        );

        assertEquals("No hay suficiente saldo para realizar la operaci�n", exception.getMessage());
    }
}