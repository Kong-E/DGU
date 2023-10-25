package DGU;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 예제 10-1 IndepClassListener : 독립 클래스로 Action 이벤트 리스너 작성
public class G_2020110210_009 extends JFrame {
  public G_2020110210_009() {
    setTitle("Action 이벤트 리스너 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 설정

    Container c = getContentPane();
    c.setLayout(new FlowLayout()); // 컴포넌트들을 좌에서 우로 배치하는 레이아웃

    JButton btn = new JButton("Action"); // 버튼 생성
    btn.addActionListener(new MyActionListener()); // 버튼 클릭 이벤트 리스너 등록
    c.add(btn); // 버튼을 컨텐트팬에 추가

    setSize(350, 150); // 윈도우 크기 설정
    setVisible(true); // 윈도우를 화면에 표시
  }

  public static void main(String[] args) {
    new G_2020110210_009();
  }
}

class MyActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) e.getSource(); // 이벤트 발생 원인 컴포넌트 가져오기
    if (b.getText().equals("Action"))
      b.setText("액션");
    else
      b.setText("Action");
  }
}
