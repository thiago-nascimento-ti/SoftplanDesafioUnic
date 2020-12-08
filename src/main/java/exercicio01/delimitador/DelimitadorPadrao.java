package exercicio01.delimitador;

import java.util.List;
import java.util.stream.Collectors;

public class DelimitadorPadrao implements Delimitador {

    private static final String DELIMITADOR = ", ";
    private static final String DELIMITADOR_FINAL = " e ";
    private static final String PREFIXO = "";
    private static final String SUFIXO = ".";

    public String toString(List<? extends Object> lista) {
        String texto = lista.stream()
                .map(item -> item.toString())
                .collect(Collectors.joining(DELIMITADOR, PREFIXO, SUFIXO));

        return lista.size() > 1 ? substituiUltimoDelimitador(texto) : texto;
    }

    private String substituiUltimoDelimitador(String texto) {
        int ultimoDelimitador = texto.lastIndexOf(DELIMITADOR);
        return new StringBuilder(texto)
                .replace(ultimoDelimitador, ultimoDelimitador + DELIMITADOR.length(), DELIMITADOR_FINAL).toString();
    }

}
