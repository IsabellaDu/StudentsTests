import java.io.IOException;

import static org.example.CommonFileMethods.deserialize;
import static org.example.CommonFileMethods.serialize;

public class IOStreamTest {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/dataFile.txt";
        //serialize(filePath);
        deserialize(filePath);
    }
}
