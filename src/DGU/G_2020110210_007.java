package DGU;

import javax.swing.*;
import java.awt.*;

// 예제 9-2 ContentPaneEx : 3개의 버튼 컴포넌트를 가진 스윙프레임 만들기
public class G_2020110210_007 extends JFrame {
  public G_2020110210_007() {
    setTitle("ContentPane과 JFrame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 설정

    Container contentPane = getContentPane();
    contentPane.setBackground(Color.ORANGE); // ContentPane 배경색 설정
    contentPane.setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정

    contentPane.add(new JButton("OK")); // "OK" 버튼 추가
    contentPane.add(new JButton("Cancel")); // "Cancel" 버튼 추가
    contentPane.add(new JButton("Ignore")); // "Ignore" 버튼 추가

    setSize(300, 150); // 윈도우 크기 설정
    setVisible(true); // 윈도우를 화면에 표시
  }

  public static void main(String[] args) {
    new G_2020110210_007();
  }
}
