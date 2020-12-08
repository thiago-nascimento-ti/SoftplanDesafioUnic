package exercicio02.calculocomposicao;

import exercicio02.ServicoExemplo;
import exercicio02.utils.FileUtils;
import exercicio02.modelo.ItemComposicao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static exercicio02.calculocomposicao.ModeloCalculoComposicao.INSUMO;

public class ModeloCalculoComposicaoTest {

    @Test
    public void devesomarCorretamente() {
        ModeloCalculoComposicao modeloCalculoComposicao = new ModeloCalculoComposicao();

        ItemComposicao item01 = new ItemComposicao();
        item01.setCodigoComposicao(1);
        item01.setTipoItem(INSUMO);
        item01.setQuantidadeComposicao("0,0190000");
        item01.setValorUnitario("9,40");

        ItemComposicao item02 = new ItemComposicao();
        item02.setCodigoComposicao(1);
        item02.setTipoItem(INSUMO);
        item02.setQuantidadeComposicao("1,0000000");
        item02.setValorUnitario("100,41");

        ItemComposicao item03 = new ItemComposicao();
        item03.setCodigoComposicao(1);
        item03.setTipoItem(INSUMO);
        item03.setQuantidadeComposicao("0,7890000");
        item03.setValorUnitario("15,19");

        ItemComposicao item04 = new ItemComposicao();
        item04.setCodigoComposicao(1);
        item04.setTipoItem(INSUMO);
        item04.setQuantidadeComposicao("0,7890000");
        item04.setValorUnitario("20,33");

        List<ItemComposicao> items = Arrays.asList(item01, item02, item03, item04);
        BigDecimal valorServicoEsperado = BigDecimal.valueOf(128.60).setScale(2, RoundingMode.FLOOR);

        List<Composicao> servicos = modeloCalculoComposicao.calcular(items);

        Assertions.assertEquals(valorServicoEsperado, servicos.get(0).getValor());
    }

    @Test
    public void deveSomarDoisInsumosDeUmServico() {
        ModeloCalculoComposicao modeloCalculoComposicao = new ModeloCalculoComposicao();

        ItemComposicao item01 = new ItemComposicao();
        item01.setCodigoComposicao(1);
        item01.setTipoItem(INSUMO);
        item01.setQuantidadeComposicao("0,5");
        item01.setValorUnitario("1,10");

        ItemComposicao item02 = new ItemComposicao();
        item02.setCodigoComposicao(1);
        item02.setTipoItem(INSUMO);
        item02.setQuantidadeComposicao("1,5");
        item02.setValorUnitario("1,10");

        List<ItemComposicao> items = Arrays.asList(item01, item02);
        BigDecimal valorServicoEsperado = BigDecimal.valueOf(2.20).setScale(2, RoundingMode.FLOOR);
        int quantidadeServicoEsperado = 1;

        List<Composicao> servicos = modeloCalculoComposicao.calcular(items);

        Assertions.assertFalse(servicos.isEmpty());
        Assertions.assertEquals(quantidadeServicoEsperado, servicos.size());
        Assertions.assertEquals(valorServicoEsperado, servicos.get(0).getValor());
    }

    @Test
    public void deveSomarInsumosDeMaisDeUmServico() {
        ModeloCalculoComposicao modeloCalculoComposicao = new ModeloCalculoComposicao();

        ItemComposicao item01 = new ItemComposicao();
        item01.setCodigoComposicao(1);
        item01.setTipoItem(INSUMO);
        item01.setQuantidadeComposicao("0,5");
        item01.setValorUnitario("1,10");

        ItemComposicao item02 = new ItemComposicao();
        item02.setCodigoComposicao(1);
        item02.setTipoItem(INSUMO);
        item02.setQuantidadeComposicao("1,5");
        item02.setValorUnitario("1,10");

        ItemComposicao item03 = new ItemComposicao();
        item03.setCodigoComposicao(2);
        item03.setTipoItem(INSUMO);
        item03.setQuantidadeComposicao("2,0");
        item03.setValorUnitario("1,5");

        List<ItemComposicao> items = Arrays.asList(item01, item02, item03);
        BigDecimal valor01Esperado = BigDecimal.valueOf(2.20).setScale(2, RoundingMode.FLOOR);
        BigDecimal valor02Esperado = BigDecimal.valueOf(3.00).setScale(2, RoundingMode.FLOOR);
        int quantidadeServicoEsperado = 2;

        List<Composicao> servicos = modeloCalculoComposicao.calcular(items);

        Assertions.assertFalse(servicos.isEmpty());
        Assertions.assertEquals(quantidadeServicoEsperado, servicos.size());
        Assertions.assertEquals(valor01Esperado, servicos.get(0).getValor());
        Assertions.assertEquals(valor02Esperado, servicos.get(1).getValor());
    }

    @Test
    public void deveSomarInsumosDeServicoDependenteDeOutroServico() {
        ModeloCalculoComposicao modeloCalculoServico = new ModeloCalculoComposicao();

        ItemComposicao item01 = new ItemComposicao();
        item01.setCodigoComposicao(1);
        item01.setTipoItem(INSUMO);
        item01.setQuantidadeComposicao("0,5");
        item01.setValorUnitario("1,10");

        ItemComposicao item02 = new ItemComposicao();
        item02.setCodigoComposicao(1);
        item02.setCodigoItem(2);
        item02.setTipoItem("COMPOSICAO");
        item02.setQuantidadeComposicao("1,5");

        ItemComposicao item03 = new ItemComposicao();
        item03.setCodigoComposicao(2);
        item03.setTipoItem(INSUMO);
        item03.setQuantidadeComposicao("1");
        item03.setValorUnitario("3,5");

        ItemComposicao item04 = new ItemComposicao();
        item04.setCodigoComposicao(2);
        item04.setTipoItem(INSUMO);
        item04.setQuantidadeComposicao("4");
        item04.setValorUnitario("2,5");

        List<ItemComposicao> items = Arrays.asList(item01, item02, item03, item04);
        BigDecimal valor01Esperado = BigDecimal.valueOf(20.80).setScale(2, RoundingMode.FLOOR);
        BigDecimal valor02Esperado = BigDecimal.valueOf(13.50).setScale(2, RoundingMode.FLOOR);
        int quantidadeServicoEsperado = 2;

        List<Composicao> servicos = modeloCalculoServico.calcular(items);

        Assertions.assertFalse(servicos.isEmpty());
        Assertions.assertEquals(quantidadeServicoEsperado, servicos.size());
        Assertions.assertEquals(valor01Esperado, servicos.get(0).getValor());
        Assertions.assertEquals(valor02Esperado, servicos.get(1).getValor());
    }

    @Test
    public void deveCalcularTodosOsDadosDeEntradaDoJson() throws IOException, URISyntaxException {
        ModeloCalculoComposicao modeloCalculoComposicao = new ModeloCalculoComposicao();

        List<ItemComposicao> items = FileUtils.toJson(FileUtils.loadFileContent(ServicoExemplo.DADOS_ENTRADA));

        String esperado = FileUtils.loadFileContent("dados-saida-servicos-composicoes.txt");
        List<Composicao> composicoes = modeloCalculoComposicao.calcular(items);

        String resultado = composicoes.stream().map(composicao -> composicao.toString()).collect(Collectors.joining("\n"));

        Assertions.assertEquals(esperado, resultado);
    }

}
