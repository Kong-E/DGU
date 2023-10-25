package DGU;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G_2020110210_013 {

    // 출력할 파일의 경로를 상수로 정의
    private static final String OUTPUT_FILE_PATH = "C:\\Temp\\output_buffer.txt";

    public static void main(String[] args) {
        // 콘솔로부터 데이터를 입력받아 파일에 저장하는 메서드 호출
        readConsoleAndWriteToFile(OUTPUT_FILE_PATH);
        // 저장된 파일의 내용을 콘솔에 출력하는 메서드 호출
        readFileAndPrintToConsole(OUTPUT_FILE_PATH);
    }

    /**
     * 콘솔로부터 데이터를 입력받아 주어진 파일에 저장하는 메서드.
     *
     * @param fileName 저장할 파일의 이름 또는 경로
     */
    public static void readConsoleAndWriteToFile(String fileName) {
        try (
                // 콘솔에서 문자를 읽기 위한 BufferedReader 생성
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                // 지정된 파일에 문자를 쓰기 위한 BufferedWriter 생성 (true는 기존 내용에 이어쓰기 모드)
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            System.out.println("데이터를 입력하세요. 'exit'를 입력하면 저장 후 종료됩니다.");

            String line;
            // 콘솔로부터 한 줄씩 입력받기
            while ((line = reader.readLine()) != null) {
                // 입력받은 내용이 'exit'인 경우 입력 종료
                if ("exit".equals(line.trim())) {
                    break;
                }
                writer.write(line); // 파일에 내용 작성
                writer.newLine(); // 줄 바꿈 문자 추가
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 주어진 파일의 내용을 콘솔에 출력하는 메서드.
     *
     * @param fileName 읽을 파일의 이름 또는 경로
     */
    public static void readFileAndPrintToConsole(String fileName) {
        try (
                // 지정된 파일에서 문자를 읽기 위한 BufferedReader 생성
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                // 콘솔에 문자를 쓰기 위한 BufferedWriter 생성
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line;
            // 파일로부터 한 줄씩 읽기
            while ((line = reader.readLine()) != null) {
                writer.write(line); // 콘솔에 내용 출력
                writer.newLine(); // 줄 바꿈 문자 추가
            }
            writer.flush(); // 버퍼의 내용을 모두 출력
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
