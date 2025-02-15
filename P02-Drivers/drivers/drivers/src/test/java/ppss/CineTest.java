package ppss;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.stream.Stream;

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
    public void reservaButacasC2() {
        boolean[] asientos = new boolean[]{};
        int solicitados = 0;

        Cine cine = new Cine();

        boolean res = assertDoesNotThrow(() -> cine.reservaButacasV1(asientos, solicitados));

        assertFalse(res);
        assertEquals(0, asientos.length);
    }

    @Test
    public void reservaButacasC3() {
        boolean[] asientos = new boolean[]{false, false, false, true, true};
        int solicitados = 2;

        boolean[] expectedAsientos = new boolean[]{true, true, false, true, true};

        Cine cine = new Cine();
        boolean res = assertDoesNotThrow(() -> cine.reservaButacasV1(asientos, solicitados));

        assertTrue(res);
        assertArrayEquals(expectedAsientos, asientos);
   }

    @Test
    public void reservaButacasC4() {
        boolean[] asientos = new boolean[]{true, true, true};
        int solicitados = 1;

        boolean[] expectedAsientos = new boolean[]{true, true, true};

        Cine cine = new Cine();
        boolean res = assertDoesNotThrow(() -> cine.reservaButacasV1(asientos, solicitados));

        assertFalse(res);
        assertArrayEquals(expectedAsientos, asientos);
    }

    private static Stream<Arguments> test (){ return Stream.of(
            Arguments.of(false, new boolean[]{}, new boolean[]{}, 0),
            Arguments.of(true, new boolean[]{true, true, false, true, true}, new boolean []{false, false, false, true, true}, 2),
            Arguments.of(false,new boolean[]{true, true, true}, new boolean []{true, true, true}, 1));}

    @ParameterizedTest
    @MethodSource("test")
    @Tag("parametrizado")
    public void reservaButacasC5(boolean expected, boolean[] expectedAsientos, boolean[] asientos, int solicitados){
        Cine cine = new Cine();
        boolean res = assertDoesNotThrow(() -> cine.reservaButacasV1(asientos, solicitados));

        assertEquals(expected, res);
        assertArrayEquals(expectedAsientos, asientos);
    }
}
