package ppss.ejercicio2;

import org.junit.Test;
import ppss.ejercicio2.TestableGestorLlamadas;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestorLlamadasTest {
    @Test
    public void calculaCosnumoTestC1(){
        ppss.ejercicio2.TestableGestorLlamadas gestorLlamadas = new ppss.ejercicio2.TestableGestorLlamadas();
        gestorLlamadas.setHora(15);
        int minutos = 10;
        int expected = 208;

        assertEquals(expected, gestorLlamadas.calculaConsumo(minutos));
    }
@Test
    public void calculaConsumoTestC2(){
        ppss.ejercicio2.TestableGestorLlamadas gestorLlamadas = new TestableGestorLlamadas();
        gestorLlamadas.setHora(22);
        int minutos = 10;
        int expected = 105;

        assertEquals(expected, gestorLlamadas.calculaConsumo(minutos));
    }
}
