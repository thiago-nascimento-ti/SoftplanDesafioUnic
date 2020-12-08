package exercicio01.observacao;

import exercicio01.modelo.Item;

import java.text.NumberFormat;
import java.util.Locale;

public class TemplateComValor {

    private static final String TEMPLATE = "%s cujo valor é %s";
    private static final String FORMATO_LINGUAGEM = "PT";
    private static final String FORMATO_PAIS = "BR";
    private final NumberFormat formatadorDinheiro;
    private final Item item;

    public TemplateComValor(Item item) {
        this.item = item;
        Locale local = new Locale(FORMATO_LINGUAGEM, FORMATO_PAIS);
        formatadorDinheiro = NumberFormat.getCurrencyInstance(local);
    }

    @Override
    public String toString() {
       return String.format(TEMPLATE, item.getNumero(), formatadorDinheiro.format(item.getValor()));
    }
}
