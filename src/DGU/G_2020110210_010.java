package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 예제 10-2 InnerClassListener : 내부 클래스로 Action 이벤트 리스너 만들기
public class G_2020110210_010 extends JFrame {
  public G_2020110210_010() {
    setTitle("Action 이벤트 리스너 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료 설정

    Container c = getContentPane();
    c.setLayout(new FlowLayout()); // 컴포넌트들을 좌에서 우로 배치하는 레이아웃

    JButton btn = new JButton("Action"); // 버튼 생성
    btn.addActionListener(new MyActionListener()); // 버튼 클릭 이벤트 리스너 등록
    c.add(btn); // 버튼을 컨텐트팬에 추가

    setSize(350, 150); // 윈도우 크기 설정
    setVisible(true); // 윈도우를 화면에 표시
  }

  private class MyActionListener implements ActionListener { // 내부 클래스로 Action 이벤트 리스너 정의
    public void actionPerformed(ActionEvent e) {
      JButton b = (JButton) e.getSource(); // 이벤트 발생 원인 컴포넌트 가져오기
      if (b.getText().equals("Action"))
        b.setText("액션");
      else
        b.setText("Action");
      setTitle(b.getText()); // 프레임 타이틀 변경
    }
  }

  public static void main(String[] args) {
    new G_2020110210_010();
  }
}
