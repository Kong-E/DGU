package DGU;

import javax.swing.*;
import java.awt.*;

// 예제 9-5 GridLayoutEx : GridLayout으로 입력 폼 만들기
public class G_2020110210_008 extends JFrame {
    public G_2020110210_008() {
        setTitle("GridLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 설정

        Container c = getContentPane();
        c.setLayout(new FlowLayout()); // Frame의 기본 content pane의 레이아웃을 FlowLayout으로 설정

        JPanel gridPanel = new JPanel(); // JPanel 객체 생성
        GridLayout grid = new GridLayout(6, 2); // 6행 2열의 그리드 레이아웃 설정
        grid.setVgap(5); // 그리드 레이아웃의 수직 간격 설정
        gridPanel.setLayout(grid); // JPanel의 레이아웃 설정을 그리드 레이아웃으로 지정
        gridPanel.setPreferredSize(new Dimension(280, 170)); // JPanel의 크기 설정

        gridPanel.add(new JLabel(" 학교")); // 학교 라벨
        gridPanel.add(new JTextField("")); // 학교 입력 필드
        gridPanel.add(new JLabel(" 학과")); // 학과 라벨
        gridPanel.add(new JTextField("")); // 학과 입력 필드
        gridPanel.add(new JLabel(" 학번")); // 학번 라벨
        gridPanel.add(new JTextField("")); // 학번 입력 필드
        gridPanel.add(new JLabel(" 이름")); // 이름 라벨
        gridPanel.add(new JTextField("")); // 이름 입력 필드
        gridPanel.add(new JLabel(" 과목")); // 과목 라벨
        gridPanel.add(new JTextField("")); // 과목 입력 필드
        gridPanel.add(new JLabel(" 메일")); // 메일 라벨
        gridPanel.add(new JTextField("")); // 메일 입력 필드

        JTextArea textArea = new JTextArea(4, 26); // 텍스트 영역 크기(줄, 글자 수)
        textArea.setLineWrap(true); // 텍스트 영역에서 자동 줄 바꿈 활성화
        JScrollPane scrollPane = new JScrollPane(textArea); // 스크롤 가능한 패널로 텍스트 영역 감싸기

        c.add(gridPanel);
        c.add(scrollPane);

        setSize(300, 300); // 윈도우 크기 설정
        setVisible(true); // 윈도우를 화면에 표시
    }

    public static void main(String[] args) {
        new G_2020110210_008();
    }
}
