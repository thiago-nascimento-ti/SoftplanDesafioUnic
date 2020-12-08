package exercicio01.observacao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdaptadorPluralTest {

    @Test
    public void deveFormatarParaPluralComUmaOpcao() {
        String template = "Fatura {0,choice,0#da nota fiscal|1#das notas fiscais} de simples remessa: ";
        String esperado = "Fatura das notas fiscais de simples remessa: ";

        String resultado = new AdaptadorPlural(template).toPlural();

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveFormatarParaSingularComUmaOpcao() {
        String template = "Fatura {0,choice,0#da nota fiscal|1#das notas fiscais} de simples remessa: ";
        String esperado = "Fatura da nota fiscal de simples remessa: ";

        String resultado = new AdaptadorPlural(template).toSingular();

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveFormatarParaPluralComMaisDeUmaOpcao() {
        String template = "Fatura da{0,choice,0#|1#s} nota{0,choice,0#|1#s} fisca{0,choice,0#l|1#is} de simples remessa: ";
        String esperado = "Fatura das notas fiscais de simples remessa: ";

        String resultado = new AdaptadorPlural(template).toPlural();

        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void deveFormatarParaSingularComMaisDeUmaOpcao() {
        String template = "Fatura da{0,choice,0#|1#s} nota{0,choice,0#|1#s} fisca{0,choice,0#l|1#is} de simples remessa: ";
        String esperado = "Fatura da nota fiscal de simples remessa: ";

        String resultado = new AdaptadorPlural(template).toSingular();

        Assertions.assertEquals(esperado, resultado);
    }

}
