package exercicio01.observacao;

import exercicio01.modelo.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TamplateComValorTest {

    @Test
    public void testeDeveFormatarValoresComCasaDecimal() {
        Item item = new Item(10, 20.39);
        TemplateComValor template = new TemplateComValor(item);
        String esperado = "10 cujo valor é R$ 20,39";

        String resultado = template.toString();

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void testeDeveFormatarValoresComCasaDecimalEFinalZero() {
        Item item = new Item(1, 20.10);
        TemplateComValor template = new TemplateComValor(item);
        String esperado = "1 cujo valor é R$ 20,10";

        String resultado = template.toString();

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveFormatarValoresNaCasaDoMilhar() {
        Item item = new Item(2, 1000.10);
        TemplateComValor template = new TemplateComValor(item);
        String esperado = "2 cujo valor é R$ 1.000,10";

        String resultado = template.toString();

        Assertions.assertEquals(esperado, resultado);
    }

}
