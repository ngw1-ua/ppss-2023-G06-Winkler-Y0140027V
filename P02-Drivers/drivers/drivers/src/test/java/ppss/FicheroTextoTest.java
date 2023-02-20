package ppss;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FicheroTextoTest {
    @Test
    public void contarCaracteresC1(){
        String nombreFichero = "ficheroC1.txt";
        String expectedMessage = "ficheroC1.txt (No existe el archivo o el directorio)";

        FicheroTexto ft = new FicheroTexto();
        Exception ex = assertThrows(FicheroException.class, () -> ft.contarCaracteres(nombreFichero));

        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test
    public void contarCaracteresC2() throws FicheroException {
        String nombreFichero = "src/test/resources/ficheroCorrecto.txt";
        FicheroTexto ft = new FicheroTexto();
        int expextedRes = 3;

        int res = ft.contarCaracteres(nombreFichero);

        assertEquals(expextedRes, res);
    }

    @Test
    public void contarCaracteresC3(){
        String nombreFichero = "src/test/rescources/ficheroC3.txt";
        String expectedMessage = "ficheroC3.txt (Error al leer el archivo)";

        FicheroTexto ft = new FicheroTexto();
        Exception ex = assertThrows(IOException.class, () -> ft.contarCaracteres(nombreFichero));

        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test
    public void contarCaracteresC4(){
        String nombreFichero = "src/test/rescources/ficheroC4.txt";
        String expectedMessage = "ficheroC3.txt (Error al cerrar el archivo)";

        FicheroTexto ft = new FicheroTexto();
        Exception ex = assertThrows(IOException.class, () -> ft.contarCaracteres(nombreFichero));

        assertTrue(ex.getMessage().contains(expectedMessage));
    }
}
