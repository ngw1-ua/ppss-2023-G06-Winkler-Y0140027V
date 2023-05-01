import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class AlquilaCochesTest {
    @Test
    public void calculaPrecioC1(){
        Ticket expected = new Ticket();
        expected.setPrecio_final(75);
        TestableAlquilaCoches ac = new TestableAlquilaCoches();
        ServicioStub ss = new ServicioStub();
        ss.setPrecio(10);
        ac.setServicio(ss);
        CalendarioStub cs = new CalendarioStub();
        cs.setThingsToReturn(new ArrayList<Boolean>(Collections.nCopies(10, Boolean.FALSE)));
        ac.calendario = cs;
        Ticket res = assertDoesNotThrow(() -> { return ac.calculaPrecio(TipoCoche.TURISMO, LocalDate.of(2023, 05, 18), 10);});
        assertEquals(expected.getPrecio_final(), res.getPrecio_final());
    }

    @Test
    public void calculaPrecioC2(){
        Ticket expected = new Ticket();
        expected.setPrecio_final((float)62.5);
        TestableAlquilaCoches ac = new TestableAlquilaCoches();
        ServicioStub ss = new ServicioStub();
        ss.setPrecio(10);
        ac.setServicio(ss);
        CalendarioStub cs = new CalendarioStub();
        cs.setThingsToReturn(new ArrayList<Boolean>(Collections.nCopies(10, Boolean.FALSE)));
        cs.thingsToReturn.set(2, Boolean.TRUE);
        cs.thingsToReturn.set(6, Boolean.TRUE);
        ac.calendario = cs;
        Ticket res = assertDoesNotThrow(() -> { return ac.calculaPrecio(TipoCoche.CARAVANA, LocalDate.of(2023, 06, 19), 7);});
        assertEquals(expected.getPrecio_final(), res.getPrecio_final());
    }

    @Test
    public void calculaPrecioC3(){
        String expected = "Error en dia: 2023-04-18; Error en dia: 2023-04-21; Error en dia: 2023-04-22;";
        TestableAlquilaCoches ac = new TestableAlquilaCoches();
        ServicioStub ss = new ServicioStub();
        ss.setPrecio(10);
        ac.setServicio(ss);
        CalendarioStub cs = new CalendarioStub();
        ac.calendario = cs;
        MensajeException ex = assertThrows(MensajeException.class, () -> { ac.calculaPrecio(TipoCoche.TURISMO, LocalDate.of(2023, 04, 17), 8);});
        assertEquals(expected, ex.getMessage());
    }
}
