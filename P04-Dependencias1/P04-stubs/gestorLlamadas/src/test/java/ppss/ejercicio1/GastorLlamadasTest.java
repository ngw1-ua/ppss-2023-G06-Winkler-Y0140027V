package ppss.ejercicio1;
import static org.junit.jupiter.api.Assertions.*;
public class GastorLlamadasTest {
    public void calculaCosnumoTestC1(){
        TestableGestorLlamadas gestorLlamadas = new TestableGestorLlamadas();
        gestorLlamadas.setHora(15);
        int minutos = 10;
        int expected = 208;

        assertEquals(expected, gestorLlamadas.calculaConsumo(minutos));
    }

    public void calculaConsumoTestC2(){
        TestableGestorLlamadas gestorLlamadas = new TestableGestorLlamadas();
        gestorLlamadas.setHora(22);
        int minutos = 10;
        int expected = 105;

        assertEquals(expected, gestorLlamadas.calculaConsumo(minutos));
    }
}
