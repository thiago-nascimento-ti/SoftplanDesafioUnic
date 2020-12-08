package exercicio01.delimitador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DelimitadorPadraoTest {

    @Test
    public void deveRetornarSomenteUmValorComSufixoFinal() {
        DelimitadorPadrao delimitador = new DelimitadorPadrao();
        List<String> lista = Arrays.asList("1");
        String esperado = "1.";

        String resultado = delimitador.toString(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarDoisValoresComSufixoFinal() {
        DelimitadorPadrao delimitador = new DelimitadorPadrao();
        List<String> lista = Arrays.asList("1", "2");
        String esperado = "1 e 2.";

        String resultado = delimitador.toString(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarTresValoresComSufixoFinal() {
        DelimitadorPadrao delimitador = new DelimitadorPadrao();
        List<String> lista = Arrays.asList("1", "2", "3");
        String esperado = "1, 2 e 3.";

        String resultado = delimitador.toString(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarQuatroValoresComSufixoFinal() {
        DelimitadorPadrao delimitador = new DelimitadorPadrao();
        List<String> lista = Arrays.asList("1", "2", "3", "4");
        String esperado = "1, 2, 3 e 4.";

        String resultado = delimitador.toString(lista);

        Assertions.assertEquals(esperado, resultado);
    }
}
