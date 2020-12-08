package exercicio02.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CurrencyUtils {

    private static final Locale local = new Locale("pt", "BR");
    private static final String formato = "%.2f";

    public static BigDecimal toBigDecimal(String valor)  {
        NumberFormat format = NumberFormat.getInstance(local);

        DecimalFormat decimalFormat = (DecimalFormat) format;
        decimalFormat.setParseBigDecimal(true);

        try {
            return (BigDecimal) decimalFormat.parse(valor);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fromBigDecimal(BigDecimal valor)  {
        return String.format(local, formato, valor);
    }

}
