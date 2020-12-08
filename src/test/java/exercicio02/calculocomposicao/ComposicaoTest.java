package exercicio02.calculocomposicao;

import exercicio02.modelo.ItemComposicao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static exercicio02.calculocomposicao.ModeloCalculoComposicao.INSUMO;

public class ComposicaoTest {

    @Test
    public void deveConverterOServicoParaString() {
        Composicao composicao = new Composicao();

        ItemComposicao item01 = new ItemComposicao();
        item01.setCodigoComposicao(1);
        item01.setDescricaoComposicao("COMPOSICAO DESCRICAO");
        item01.setUnidadeComposicao("UN");
        item01.setTipoItem(INSUMO);
        item01.setQuantidadeComposicao("0,5");
        item01.setValorUnitario("1,10");

        ItemComposicao item02 = new ItemComposicao();
        item02.setCodigoComposicao(1);
        item02.setDescricaoComposicao("COMPOSICAO DESCRICAO");
        item02.setUnidadeComposicao("UN");
        item02.setTipoItem(INSUMO);
        item02.setQuantidadeComposicao("1,5");
        item02.setValorUnitario("1,10");

        composicao.add(item01);
        composicao.add(item02);
        composicao.setValor(BigDecimal.valueOf(2.25).setScale(2, RoundingMode.FLOOR));

        String descricaoEsperada = "1  COMPOSICAO DESCRICAO  UN  2,25";
        String resultadoDaDescricao = composicao.toString();

        Assertions.assertEquals(descricaoEsperada, resultadoDaDescricao);
    }

}
