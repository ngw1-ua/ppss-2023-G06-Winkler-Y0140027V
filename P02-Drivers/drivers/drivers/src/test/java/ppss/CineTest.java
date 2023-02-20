package ppss;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CineTest {
    @Test
    public void reservaButacasC1(){
        boolean[] asientos = new boolean[]{};
        int solicitados = 3;
        String expectedMessage = "No se puede procesar la solicitud";

        Cine cine = new Cine();
        Exception ex = assertThrows(ButacasException.class, () -> cine.reservaButacasV1(asientos, solicitados));

        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test
    public void reservaButacasC2() throws ButacasException {
        boolean[] asientos = new boolean[]{};
        int solicitados = 0;

        Cine cine = new Cine();
        boolean res = cine.reservaButacasV1(asientos, solicitados);

        assertFalse(res);
        assertEquals(0, asientos.length);
    }

    @Test
    public void reservaButacasC3() throws ButacasException {
        boolean[] asientos = new boolean[]{false, false, false, true, true};
        int solicitados = 2;

        boolean[] expectedAsientos = new boolean[]{true, true, false, true, true};

        Cine cine = new Cine();
        boolean res = cine.reservaButacasV1(asientos, solicitados);

        assertTrue(res);
        assertArrayEquals(asientos, expectedAsientos);
   }

    @Test
    public void reservaButacasC4() throws ButacasException {
        boolean[] asientos = new boolean[]{true, true, true};
        int solicitados = 1;

        boolean[] expectedAsientos = new boolean[]{true, true, true};

        Cine cine = new Cine();
        boolean res = cine.reservaButacasV1(asientos, solicitados);

        assertFalse(res);
        assertArrayEquals(asientos, expectedAsientos);
    }
}
