package DGU;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class G_2020110210_014 {
  private static final String FILE_PATH = "C:\\Temp\\output_file.txt";

  // 파일 클래스 활용 입력 1개 - 출력 1개
  public static void main(String[] args) {
    File file = new File(FILE_PATH);
    String contentToWrite = "This is a sample content.";

    // Writing to the file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(contentToWrite);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Reading from the file
    try (FileInputStream fis = new FileInputStream(file)) {
      int contentByte; // 바이트 단위로 읽는다.
      while ((contentByte = fis.read()) != -1) {
        System.out.print((char) contentByte);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
