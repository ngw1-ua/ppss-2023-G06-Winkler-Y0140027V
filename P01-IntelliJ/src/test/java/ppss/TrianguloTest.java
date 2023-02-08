package ppss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianguloTest {
    int a,b,c;
    String resultadoReal, resultadoEsperado;
    Triangulo tri;

    @Test
    public void testTipo_trianguloC1() {
       a = 1;
       b = 1;
       c = 1;
       resultadoEsperado = "Equilatero";
       tri= new Triangulo();
       resultadoReal = tri.tipo_triangulo(a,b,c);
       assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testTipo_trianguloC2() {
        a = 1;
        b = 1;
        c = 11;
        resultadoEsperado = "No es un triangulo";
        tri= new Triangulo();
        resultadoReal = tri.tipo_triangulo(a,b,c);
        //El método Assert.assertEquals devuelve cierto si el
        //resultadoEsperado = resultadoReal
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testTipo_trianguloC3() {
        a = 1;
        b = 2;
        c = 0;
        resultadoEsperado = "Valor c fuera del rango permitido";
        tri= new Triangulo();
        resultadoReal = tri.tipo_triangulo(a,b,c);
        assertEquals(resultadoEsperado, resultadoReal);
    }


    @Test
    public void testTipo_trianguloC4() {
        a = 14;
        b = 10;
        c = 10;
        resultadoEsperado = "Isosceles";
        tri= new Triangulo();
        resultadoReal = tri.tipo_triangulo(a,b,c);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    public void testTipo_trianguloC5() {
        //No conviene implementarlo por que en el C1 ya se comprueba la heurística.
    }

    @Test
    public void testTipo_trianguloC6() {
        a = 150;
        b = 100;
        c = 70;
        resultadoEsperado = "Escaleno";
        tri= new Triangulo();
        //Comprobamos que efectivamente reconoce triangulos escalenos
        resultadoReal = tri.tipo_triangulo(a,b,c);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testTipo_trianguloC7() {
        a = 1;
        b = -1234567;
        c = -1;
        resultadoEsperado = "Valor b fuera del rango permitido";
        tri= new Triangulo();
        resultadoReal = tri.tipo_triangulo(a,b,c);
        assertEquals(resultadoEsperado, resultadoReal);
    }
}
