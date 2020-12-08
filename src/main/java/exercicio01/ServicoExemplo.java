package exercicio01;

import exercicio01.delimitador.DelimitadorPadrao;
import exercicio01.modelo.Item;
import exercicio01.observacao.GeradorObservacao;
import exercicio01.observacao.TemplateComValor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoExemplo {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1, 1),
                new Item(2, 10),
                new Item(3, 15.1),
                new Item(4, 16.30)
        );
        ServicoExemplo servicoExemplo = new ServicoExemplo();

        System.out.println("exemploOriginal: "+servicoExemplo.exemploOriginal(items));
        System.out.println("exemploNovo: "+servicoExemplo.exemploNovo(items));
        System.out.println("exemploComMudancaDoPrefixo: "+servicoExemplo.exemploComMudancaDoPrefixo(items));
        System.out.println("exemploComMudancaDelimitador: "+servicoExemplo.exemploComMudancaNoDelimitador(items));
    }

    public String exemploOriginal(List<Item> items) {
        List<Integer> numeros = items.stream().map(item -> item.getNumero()).collect(Collectors.toList());

        GeradorObservacao geradorObservacao = new GeradorObservacao();
        return geradorObservacao.geraObservacao(numeros);
    }

    public String exemploNovo(List<Item> items) {
        List<TemplateComValor> lista = items.stream().map(item -> new TemplateComValor(item)).collect(Collectors.toList());

        GeradorObservacao geradorObservacao = new GeradorObservacao();
        return geradorObservacao.geraObservacao(lista);
    }

    public String exemploComMudancaDoPrefixo(List<Item> items) {
        List<TemplateComValor> lista = items.stream().map(item -> new TemplateComValor(item)).collect(Collectors.toList());

        GeradorObservacao geradorObservacao = new GeradorObservacao(new DelimitadorPadrao(), "Listagem {0,choice,0#da nota emitida|1#de todas notas emitidas}: ");
        return geradorObservacao.geraObservacao(lista);
    }

    public String exemploComMudancaNoDelimitador(List<Item> items) {
        List<Integer> numeros = items.stream().map(item -> item.getNumero()).collect(Collectors.toList());

        GeradorObservacao geradorObservacao = new GeradorObservacao((List<? extends Object> lista) -> {
            String texto = lista.stream()
                    .map(item -> item.toString())
                    .collect(Collectors.joining("; ", "", "."));

            return texto;
        }, "Listagem {0,choice,0#da nota emitida|1#de todas notas emitidas}: ");

        return geradorObservacao.geraObservacao(numeros);
    }

}
