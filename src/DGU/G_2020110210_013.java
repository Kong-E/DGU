package DGU;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class G_2020110210_013 {
    public static void main(String[] args) {
        List<String> dataList = Arrays.asList("융합프로그래밍2", "BufferStream을 이용해 파일 생성하고 읽기", "경제학과 공소연");

        // 절대경로로 파일 지정
        String absolutePath = "C:\\Temp\\output_buffer.txt";

        // FileWriter 및 BufferedWriter 사용하여 파일 생성 및 데이터 쓰기
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath, StandardCharsets.UTF_8))) {
            for (String data : dataList) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileReader 및 BufferedReader 사용하여 파일 읽기 및 출력
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
