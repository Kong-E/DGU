package DGU;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// buffer 사용 입력1개 - 출력 1개
public class G_2020110210_013 {

    private static final String INPUT_FILE_PATH = "C:\\Temp\\output.txt";
    private static final String OUTPUT_FILE_PATH = "C:\\Temp\\output_buffer.txt";

    public static void main(String[] args) {
        try (
                // 파일에서 데이터를 읽는 BufferedInputStream 객체 생성
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(INPUT_FILE_PATH));
                // 파일로 데이터를 쓰는 BufferedOutputStream 객체 생성
                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE_PATH))) {
            int data;
            // 파일에서 데이터를 읽어서 다른 파일에 쓰기
            while ((data = bin.read()) != -1) {
                bout.write(data);
            }
            bout.flush(); // 버퍼의 내용을 출력 파일에 쓴다.
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please ensure that the input file exists.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
