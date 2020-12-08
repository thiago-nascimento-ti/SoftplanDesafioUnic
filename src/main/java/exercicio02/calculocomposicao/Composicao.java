package exercicio02.calculocomposicao;

import exercicio02.modelo.ItemComposicao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static exercicio02.utils.CurrencyUtils.fromBigDecimal;

public class Composicao {

    private Integer codigo;
    private String descricao;
    private String unidade;
    private BigDecimal valor;

    private List<ItemComposicao> items;

    public Composicao() {
        items = new ArrayList<>();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ItemComposicao> getItems() {
        return items;
    }

    public void add(ItemComposicao itemComposicao) {
        if (codigo == null) {
            this.codigo = itemComposicao.getCodigoComposicao();
            this.descricao = itemComposicao.getDescricaoComposicao();
            this.unidade = itemComposicao.getUnidadeComposicao();
        }
        items.add(itemComposicao);
    }

    @Override
    public String toString() {
        return String.format("%s  %s  %s  %s", codigo, descricao, unidade, fromBigDecimal(valor));
    }
}
