package exercicio02.calculocomposicao;

import exercicio02.modelo.ItemComposicao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static exercicio02.utils.CurrencyUtils.toBigDecimal;

public class ModeloCalculoComposicao {

    public static final String INSUMO = "INSUMO";

    private Map<Integer, Composicao> composicoes;

    public List<Composicao> calcular(List<ItemComposicao> itemsComposicoes) {
        composicoes = new LinkedHashMap<>();

        itemsComposicoes.forEach(this::adiconaNaComposicao);
        return composicoes.values().stream().map(this::calculaComposicao)
                .collect(Collectors.toList());
    }

    private void adiconaNaComposicao(ItemComposicao itemComposicao) {
        int codigoComposicao = itemComposicao.getCodigoComposicao();

        Composicao composicao = null;
        if (composicoes.containsKey(codigoComposicao)) {
            composicao = composicoes.get(codigoComposicao);
        } else {
            composicao = new Composicao();
            composicoes.put(codigoComposicao, composicao);
        }
        composicao.add(itemComposicao);
    }

    private Composicao calculaComposicao(Composicao composicao) {
        if (isComposicaoCalculada(composicao)) {
            return composicao;
        }

        BigDecimal total = composicao.getItems().stream()
                .map(this::calculaItemComposicao)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        composicao.setValor(total);
        return composicao;
    }

    private BigDecimal calculaItemComposicao(ItemComposicao itemComposicao) {
        BigDecimal quantidade = toBigDecimal(itemComposicao.getQuantidadeComposicao());
        BigDecimal valor = null;

        if (isInsumo(itemComposicao)) {
            valor = quantidade.multiply(toBigDecimal(itemComposicao.getValorUnitario()));
        } else {
            int codigo = itemComposicao.getCodigoItem();
            Composicao composicao = calculaComposicao(composicoes.get(codigo));
            valor = quantidade.multiply(composicao.getValor());
        }

        return valor.setScale(2, RoundingMode.FLOOR);
    }

    private boolean isComposicaoCalculada(Composicao servico) {
        return servico.getValor() != null;
    }

    private boolean isInsumo(ItemComposicao itemComposicao) {
        return itemComposicao.getTipoItem().equals(INSUMO);
    }

}
