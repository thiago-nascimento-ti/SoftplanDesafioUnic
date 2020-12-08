package exercicio01.observacao;

import exercicio01.delimitador.Delimitador;
import exercicio01.delimitador.DelimitadorPadrao;

import java.util.List;

public class GeradorObservacao {

    public static final String PREFIXO_OBSERVACAO_PADRAO = "Fatura {0,choice,0#da nota fiscal|1#das notas fiscais} de simples remessa: ";

    private final AdaptadorPlural adaptadorPlural;
    private final Delimitador delimitador;


    public GeradorObservacao(Delimitador delimitador, AdaptadorPlural adaptadorPlural) {
        this.delimitador = delimitador;
        this.adaptadorPlural = adaptadorPlural;
    }

    public GeradorObservacao(Delimitador delimitador, String prefixoObservacao) {
        this(new DelimitadorPadrao(), new AdaptadorPlural(prefixoObservacao));
    }

    public GeradorObservacao() {
        this(new DelimitadorPadrao(), PREFIXO_OBSERVACAO_PADRAO);
    }

    public String geraObservacao(List<? extends Object> lista) {
        return lista == null || lista.isEmpty() ? "" : retornaCodigos(lista);
    }

    private String retornaCodigos(List<? extends Object> lista) {
        String prefixo = lista.size() >= 2 ? adaptadorPlural.toPlural() : adaptadorPlural.toSingular();
        return prefixo + this.delimitador.toString(lista);
    }

}