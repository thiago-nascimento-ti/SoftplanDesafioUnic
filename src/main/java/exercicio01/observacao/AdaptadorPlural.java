package exercicio01.observacao;

import java.text.MessageFormat;

public class AdaptadorPlural {

    private static final int PLURAL = 1;
    private static final int SINGULAR = 0;

    private String texto;

    public AdaptadorPlural(String texto) {
        this.texto = texto;
    }

    public String toPlural() {
        return formatar(PLURAL);
    }

    public String toSingular() {
        return formatar(SINGULAR);
    }

    private String formatar(int opcao) {
        Object[] opcoes = {opcao};
        return new MessageFormat(texto).format(opcoes);
    }

}
