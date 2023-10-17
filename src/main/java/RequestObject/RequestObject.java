package RequestObject;

import FileReading.FileReading;

import java.io.IOException;

public class RequestObject {

    public static String getRequestObjectName(String path) throws IOException {
        return FileReading.ReadFile(path);
    }
}
