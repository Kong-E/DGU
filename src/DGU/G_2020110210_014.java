package DGU;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class G_2020110210_014 {
  private static final String FILE_PATH = "C:\\Temp\\output_file.txt";

  public static void main(String[] args) {
    System.out.println("내용을 입력하세요. 입력이 끝나면 'exit'를 입력하세요.");

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while (true) {
        line = reader.readLine();
        if ("exit".equalsIgnoreCase(line)) {
          break;
        }
        bw.write(line);
        bw.newLine();
      }
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
      return;
    }

    System.out.println("\n저장된 내용:");
    displayFileContents(FILE_PATH);
  }

  private static void displayFileContents(String filePath) {
    File file = new File(filePath);
    if (!file.exists()) {
      System.out.println("지정된 파일이 존재하지 않습니다.");
      return;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
    }
  }
}
