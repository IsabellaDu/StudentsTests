package org.example;

import java.io.*;

public class CommonFileMethods {
    public CommonFileMethods() {
    }

    // serialize - write
    // deserialize - read

    public static void serialize(String filePath) throws IOException {
        File firstFile = new File(filePath);
        if (!firstFile.exists()) {
            firstFile.createNewFile();
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(firstFile));

        fileWriter.write("name: Izabella");
        fileWriter.newLine();
        fileWriter.write("age: 25");
        fileWriter.newLine();
        fileWriter.write("hobby: hiking");
        fileWriter.newLine();

        fileWriter.flush();
    }

    public static void deserialize(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            }
        }
    }
}
