package DGU;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

// 자신만이 구사하는 입력1개- 출력1개
public class G_2020110210_015 {

  private static final String FILE_NAME = "C:\\Temp\\large_data_file.txt";

  public static void main(String[] args) {
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_NAME), StandardOpenOption.CREATE)) {
      for (int i = 0; i < 1_000_000; i++) { // Just for demonstration; adjust as needed
        writer.write("Hello, Files! Line number: " + i + "\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
      lines.forEach(line -> {
        // Process each line here
        System.out.println(line);
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
