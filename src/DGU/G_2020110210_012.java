package DGU;

import java.io.*;
import java.util.Arrays;
import java.util.List;

// stream 사용 입력1개 - 출력 1개
public class G_2020110210_012 {
    public static void main(String[] args) {
        List<String> dataList = Arrays.asList("Hello Stream", "2020110210 Kong Soyeon", "Java Programming");
        byte b[] = { 7, 51, 3, 4, -1, 24 };

        // 절대경로로 파일 지정
        String absolutePath = "C:\\Temp\\output.txt";
        String binaryAbsolutePath = "C:\\Temp\\binary.txt";

        /* ----------------------------------------------------- */

        // FileOutputStream 및 OutputStreamWriter 사용하여 파일 생성 및 데이터 쓰기
        try (FileOutputStream fout = new FileOutputStream(absolutePath); // 파일 출력 스트림 생성
                OutputStreamWriter osw = new OutputStreamWriter(fout, "MS949") // 문자 입력 스트림 생성
        ) {
            for (String data : dataList) {
                osw.write(data + "\n"); // dataList의 문자열을 파일에 기록
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(absolutePath + "에 저장할 수 없습니다.");
            return;
        }

        // FileInputStream 및 InputStreamReader 사용하여 파일 읽기 및 출력
        try (
                FileInputStream fin = new FileInputStream(absolutePath); // 파일 입력 스트림 생성
                InputStreamReader isr = new InputStreamReader(fin, "MS949") // 문자 읽기 스트림 생성
        ) {
            int readChar;
            StringBuilder content = new StringBuilder();

            System.out.println(absolutePath + "에서 읽은 내용을 출력합니다.");
            while ((readChar = isr.read()) != -1) {
                content.append((char) readChar); // 파일의 내용을 읽어서 content에 저장
            }
            System.out.println(content.toString());
            fin.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(absolutePath + "을 읽을 수 없습니다.");
        }

        /* ----------------------------------------------------- */

        // FileOutputStream 사용하여 바이너리 파일 생성 및 데이터 쓰기
        try {
            FileOutputStream fout = new FileOutputStream(binaryAbsolutePath);
            for (int i = 0; i < b.length; i++)
                fout.write(b[i]); // 배열 b의 바이너리를 그대로 기록
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(binaryAbsolutePath + "에 저장할 수 없습니다.");
            return;
        }

        // FileInputStream 사용하여 바이너리 파일 읽기 및 출력
        try {
            FileInputStream fin = new FileInputStream(binaryAbsolutePath);
            int n = 0, c;
            while ((c = fin.read()) != -1) {
                b[n] = (byte) c;
                n++;
            }
            System.out.println(binaryAbsolutePath + "에서 읽은 배열을 출력합니다.");
            for (int i = 0; i < b.length; i++)
                System.out.print(b[i] + " ");
            System.out.println();
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(binaryAbsolutePath + "을 읽을 수 없습니다.");
        }
    }
}
