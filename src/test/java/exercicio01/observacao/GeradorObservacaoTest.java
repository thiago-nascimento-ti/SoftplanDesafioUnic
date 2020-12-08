package exercicio01.observacao;

import exercicio01.modelo.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeradorObservacaoTest {

    @Test
    public void naoDeveLancarNullPointerExceptionQuandoOParametroEhNull() {
        GeradorObservacao gerador = new GeradorObservacao();
        String esperado = "";

        String resultado = gerador.geraObservacao(null);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarStringVaziaQuandoAListaEhVazia() {
        GeradorObservacao gerador = new GeradorObservacao();
        List<Integer> lista = new ArrayList<>();
        String esperado = "";

        String resultado = gerador.geraObservacao(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarObservacaoParaApenasUmItem() {
        GeradorObservacao gerador = new GeradorObservacao();

        List<Integer> lista = Arrays.asList(1);
        String esperado = "Fatura da nota fiscal de simples remessa: 1.";

        String resultado = gerador.geraObservacao(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarObservacaoParaDoisItems() {
        GeradorObservacao gerador = new GeradorObservacao();

        List<Integer> lista = Arrays.asList(1, 2);
        String esperado = "Fatura das notas fiscais de simples remessa: 1 e 2.";

        String resultado = gerador.geraObservacao(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarObservacaoParaTresOuMaisItems() {
        GeradorObservacao gerador = new GeradorObservacao();

        List<Integer> lista = Arrays.asList(1, 2, 3);
        String esperado = "Fatura das notas fiscais de simples remessa: 1, 2 e 3.";

        String resultado = gerador.geraObservacao(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarObservacaoParaTresOuMaisItemsComListaDeString() {
        GeradorObservacao gerador = new GeradorObservacao();

        List<String> lista = Arrays.asList("1", "2", "3");
        String esperado = "Fatura das notas fiscais de simples remessa: 1, 2 e 3.";

        String resultado = gerador.geraObservacao(lista);

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarObservacaoParaTresOuMaisItemsComTemplateComValor() {
        GeradorObservacao gerador = new GeradorObservacao();

        List<TemplateComValor> lista = Arrays.asList(new TemplateComValor(new Item(1, 20.20)), new TemplateComValor(new Item(2, 1.20)), new TemplateComValor(new Item(3, 1000.20)));
        String esperado = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 20,20, 2 cujo valor é R$ 1,20 e 3 cujo valor é R$ 1.000,20.";

        String resultado = gerador.geraObservacao(lista);

        Assertions.assertEquals(esperado, resultado);
    }

}
