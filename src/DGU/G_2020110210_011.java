package DGU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 예제 10-3 AnonymousClassListener : 익명 클래스로 Action 이벤트 리스너 만들기
public class G_2020110210_011 extends JFrame {
  public G_2020110210_011() {
    setTitle("Action 이벤트 리스너 작성");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭시 프로그램 종료 설정
    Container c = getContentPane(); // 컨테이너 참조
    c.setLayout(new FlowLayout()); // 레이아웃 매니저 설정
    JButton btn = new JButton("Action"); // 버튼 생성
    c.add(btn); // 컨테이너에 버튼 추가

    btn.addActionListener(new ActionListener() { // 버튼에 액션 리스너 추가
      public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource(); // 이벤트 소스 참조
        if (b.getText().equals("Action")) // 버튼의 텍스트 체크
          b.setText("액션");
        else
          b.setText("Action");
        setTitle(b.getText()); // 프레임 타이틀 변경
      }
    });

    setSize(350, 150); // 프레임 크기 설정
    setVisible(true); // 프레임을 화면에 보이도록 설정
  }

  public static void main(String[] args) {
    new G_2020110210_011(); // 프레임 객체 생성 및 실행
  }
}
