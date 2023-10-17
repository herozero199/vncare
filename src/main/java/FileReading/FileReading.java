package FileReading;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReading {

    public static String ReadFile(String Path) throws IOException {

        Stream<String> lines = Files.lines(Paths.get(Path));
        String query = lines.collect(Collectors.joining(" "));
        lines.close();
        return query;
    }
}
