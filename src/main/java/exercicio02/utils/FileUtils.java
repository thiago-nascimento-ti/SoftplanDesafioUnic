package exercicio02.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exercicio02.ServicoExemplo;
import exercicio02.modelo.ItemComposicao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public static List<ItemComposicao> toJson(String content) {
        Gson gson = new Gson();
        Type typeOfT = TypeToken.getParameterized(List.class, ItemComposicao.class).getType();
        return gson.fromJson(content, typeOfT);
    }

    public static String loadFileContent(String fileName) throws IOException, URISyntaxException {
        ClassLoader classLoader = ServicoExemplo.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        Path path = Paths.get(resource.toURI());
        String content = Files.lines(path, StandardCharsets.UTF_8).collect(Collectors.joining("\n"));

        return content;
    }

}
