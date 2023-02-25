package ppss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DataArrayTest {
    @Test
    public void deleteC1() {
        int entrada[] = new int[]{1,3,5,7};
        int elemBorrar = 5;
        int expectedArray[] = new int[]{1,3,7};

        DataArray da = new DataArray(entrada);

        assertDoesNotThrow(() -> da.delete(elemBorrar));

        Assertions.assertArrayEquals(expectedArray, entrada);
    }

    @Test
    public void deleteC2() {
        int entrada[] = new int[]{1,3,3,5,7};
        int elemBorrar = 3;
        int expectedArray[] = new int[]{1,3,5,7};

        DataArray da = new DataArray(entrada);

        assertDoesNotThrow(() -> da.delete(elemBorrar));

        Assertions.assertArrayEquals(expectedArray, entrada);
    }

    @Test
    public void deleteC3() {
        int entrada[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        int elemBorrar = 4;
        int expectedArray[] = new int[]{1,2,3,5,6,7,8,9,10};

        DataArray da = new DataArray(entrada);

        assertDoesNotThrow(() -> da.delete(elemBorrar));

        Assertions.assertArrayEquals(expectedArray, entrada);

    }

    @Test
    public void deleteC4(){
        int entrada[] = new int[]{};
        int elemBorrar = 8;
        //int expectedArray[] = new int[]{1,2,3,5,6,7,8,9,10}
        String expectedMessage = "No hay elementos en la colección";
        DataArray da = new DataArray(entrada);

        Exception ex = assertThrows(DataException.class, () -> da.delete(elemBorrar));
        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test
    public void deleteC5(){
        int entrada[] = new int[]{1,3,5,7};
        int elemBorrar = -5;
        //int expectedArray[] = new int[]{1,2,3,5,6,7,8,9,10}
        String expectedMessage = "El valor a borrar debe ser > 0";
        DataArray da = new DataArray(entrada);

        Exception ex = assertThrows(DataException.class, () -> da.delete(elemBorrar));
        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test
    public void deleteC6(){
        int entrada[] = new int[]{};
        int elemBorrar = 0;
        //int expectedArray[] = new int[]{1,2,3,5,6,7,8,9,10}
        String expectedMessage = "Colección vacía. Y el valor a borrar debe ser > 0";
        DataArray da = new DataArray(entrada);

        Exception ex = assertThrows(DataException.class, () -> da.delete(elemBorrar));
        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test
    public void deleteC7(){
        int entrada[] = new int[]{1,3,5,7};
        int elemBorrar = 8;
        //int expectedArray[] = new int[]{1,2,3,5,6,7,8,9,10}
        String expectedMessage = "Elemento no encontrado";
        DataArray da = new DataArray(entrada);

        Exception ex = assertThrows(DataException.class, () -> da.delete(elemBorrar));
        assertTrue(ex.getMessage().contains(expectedMessage));
    }

    private static Stream<Arguments> test (){ return Stream.of(
            Arguments.of(new int[]{}, 8, "No hay elementos en la colección"),
            Arguments.of(new int []{1,3,5,7}, -5, "El valor a borrar debe ser > 0"),
            Arguments.of(new int []{}, 0, "Colección vacía. Y el valor a borrar debe ser > 0"),
            Arguments.of(new int []{1,3,5,7}, 8, "Elemento no encontrado"));}

    @ParameterizedTest
    @MethodSource("test")
    @Tag("parametrizado")
    @Tag("conExcepciones")
    public void reservaButacasC5(int[] coleccion, int borrar, String expectedMsg){
        DataArray da = new DataArray(coleccion);
        Exception ex = assertThrows(DataException.class, () -> da.delete(borrar));

        assertTrue(ex.getMessage().contains(expectedMsg));
    }
}
