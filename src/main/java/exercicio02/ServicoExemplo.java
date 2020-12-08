package exercicio02;

import exercicio02.calculocomposicao.ModeloCalculoComposicao;
import exercicio02.calculocomposicao.Composicao;
import exercicio02.modelo.ItemComposicao;
import exercicio02.utils.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ServicoExemplo {

    public static final String DADOS_ENTRADA = "dados-entrada-servicos-composicoes.json";

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<ItemComposicao> items = FileUtils.toJson(FileUtils.loadFileContent(DADOS_ENTRADA));
        List<Composicao> composicoes = new ModeloCalculoComposicao().calcular(items);
        composicoes.forEach(System.out::println);
    }

}
