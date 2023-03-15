import ppss.exceptions.ReservaException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class ReservaTest {
    @Test
    public void realizaReservaC1(){
        TestableReserva tr = new TestableReserva();
        String expected = "ERROR de permisos; ";
        ReservaException ex = assertThrows(ReservaException.class, () -> {tr.realizaReserva("xxxx", "xxxx", "Luis", new String[]{"111111"});});
        assertEquals(expected, ex.getMessage());
    }
    @Test

    public void realizaReservaC2(){
        TestableReserva tr = new TestableReserva();
        tr.bool = true;
        tr.Operation = new ArrayList<String>(
                Arrays.asList("", ""));

        assertDoesNotThrow(() -> {tr.realizaReserva("ppss", "ppss", "Luis", new String[]{"11111", "22222"});});
    }

    @Test
    public void realizaReservaC3(){
        TestableReserva tr = new TestableReserva();
        String expected = "ISBN invalido:33333; ISBN invalido:44444; ";
        tr.bool = true;
        tr.Operation = new ArrayList<String>(
                Arrays.asList("", "IsbnInvalidoException", "IsbnInvalidoException"));
        ReservaException ex = assertThrows(ReservaException.class, () -> {tr.realizaReserva("ppss", "ppss", "Luis", new String[]{"111111", "33333", "44444"});});
        assertEquals(expected, ex.getMessage());
    }

    @Test
    public void realizaReservaC4(){
        TestableReserva tr = new TestableReserva();
        String expected = "SOCIO invalido; ";
        tr.bool = true;
        tr.Operation = new ArrayList<String>(
                Arrays.asList("SocioInvalidoException"));
        ReservaException ex = assertThrows(ReservaException.class, () -> {tr.realizaReserva("xxxx", "xxxx", "Pepe", new String[]{"111111"});});
        assertEquals(expected, ex.getMessage());
    }

    @Test
    public void realizaReservaC5(){
        TestableReserva tr = new TestableReserva();
        String expected = "CONEXION invalida; ";
        tr.bool = true;
        tr.Operation = new ArrayList<String>(
                Arrays.asList("", "JDBCException"));
        ReservaException ex = assertThrows(ReservaException.class, () -> {tr.realizaReserva("ppss", "ppss", "Luis", new String[]{"111111", "22222"});});
        assertEquals(expected, ex.getMessage());
    }
}
