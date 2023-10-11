package DGU;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class G_2020110210_012 {
    public static void main(String[] args) {
        List<String> dataList = Arrays.asList("융합프로그래밍2", "Stream을 이용해 파일 생성하고 읽기", "2020110210 공소연");

        // 절대경로로 파일 지정
        String absolutePath = "C:\\Temp\\output.txt";

        // FileOutputStream 및 OutputStreamWriter 사용하여 파일 생성 및 데이터 쓰기
        try (FileOutputStream fos = new FileOutputStream(absolutePath);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            for (String data : dataList) {
                osw.write(data + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileInputStream 및 InputStreamReader 사용하여 파일 읽기 및 출력
        try (FileInputStream fis = new FileInputStream(absolutePath);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8)) {
            int readChar;
            StringBuilder content = new StringBuilder();
            while ((readChar = isr.read()) != -1) {
                content.append((char) readChar);
            }
            System.out.println(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
