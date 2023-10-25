package DGU;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

// 자신만이 구사하는 입력1개- 출력1개
public class G_2020110210_015 {

  // 파일명을 상수로 선언
  private static final String FILE_NAME = "C:\\Temp\\large_data_file.txt";

  public static void main(String[] args) {
    // 파일에 데이터를 쓰는 부분
    try (
        // BufferedWriter를 사용하여 large_data_file.txt 파일에 쓰기를 수행
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_NAME), StandardOpenOption.CREATE)) {
      for (int i = 0; i < 1_000_000; i++) { // 1백만번 반복하여 데이터 쓰기 (데모를 위한 코드; 필요에 따라 조정 가능)
        writer.write("Hello, Files! Line number: " + i + "\n");
      }
    } catch (Exception e) { // 예외 처리
      e.printStackTrace();
    }

    // 파일에서 데이터를 읽는 부분
    try (
        // Files.lines() 메서드를 사용하여 large_data_file.txt 파일에서 각 줄을 스트림으로 읽기
        Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
      lines.forEach(line -> {
        // 여기에서 각 줄을 처리
        System.out.println(line);
      });
    } catch (Exception e) { // 예외 처리
      e.printStackTrace();
    }
  }
}
